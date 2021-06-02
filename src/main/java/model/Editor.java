package model;

import it.unimi.di.adaptlab.aide.utils.AiDEEnvironment;
import neverlang.compiler.mdl.ModuleSource;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Editor {

    private final AiDEEnvironment env;

    private HashMap<String, ModuleSource> abs_syntax = new HashMap<String, ModuleSource>();
    private HashMap<String, ModuleSource> cnc_syntax = new HashMap<String, ModuleSource>();
    private HashMap<String, ModuleSource> semantic = new HashMap<String, ModuleSource>();

    public Editor(String dir_path) throws IOException {
        env = new AiDEEnvironment();
        env.loadDir(dir_path);

        this.extractAbstractSyntax();
        this.extractConcreteSyntax();
    }

    /*
    * Module MS is considered as an Abstract Syntax if:
    *   1) MS.getRoles().length > 0 && MS.getSyntaxFrom() == null
    *   2) MS.getCanonicalName() == OTHER_MODULE.getSyntaxFrom() && OTHER_MODULE.geRoles().length > 0
    *
    * Modules in .semanticLayer() have always .getRoles().length > 0
    */
    private void extractAbstractSyntax() {
        for(ModuleSource msA : env.semanticLayer().values())
        {
            String cnB = msA.getSyntaxFrom();
            if(cnB != null) {
                ModuleSource msB = env.syntacticLayer().get(cnB);
                if (msB.getRoles().length > 0)
                    this.abs_syntax.putIfAbsent(cnB, msB);
            } else
                this.abs_syntax.putIfAbsent(msA.getCanonicalName(), msA);
        }
    }

    private void extractConcreteSyntax() {
        this.cnc_syntax = (HashMap<String, ModuleSource>) Stream.concat(
                    this.env.semanticLayer()
                            .entrySet()
                            .stream()
                            .filter(e -> e.getValue().getSyntaxFrom() == null),
                    this.env.syntacticLayer()
                            .entrySet()
                            .stream()
        ).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a1,a2) -> a2));
    }

    public HashMap<String, ModuleSource> getAbstractSyntaxes() {
        return this.abs_syntax;
    }

    public HashMap<String, ModuleSource> getSyntaxesFrom(ModuleSource module) {

        return (HashMap<String, ModuleSource>) this.cnc_syntax
                .entrySet()
                .stream()
                .filter(e -> ProductionDescriptor.compareModules(module, e.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public HashMap<String, ModuleSource> getSemanticFrom(ModuleSource module) {
        return (HashMap<String, ModuleSource>) env.semanticLayer()
                .entrySet()
                .stream()
                .filter(e -> ProductionDescriptor.compareModules(module, e.getValue()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    public void createSlice(Module syntax, Module semantic) {
        /*
            String template = "slice %s { \n    concrete syntax from %s \n    %s \n} \n";
            return String.format(template, this.getUnitName(), this.getModule().getCanonicalName(), String.join("\n    ", this.collectActiveModules()));
        */
    }

}
