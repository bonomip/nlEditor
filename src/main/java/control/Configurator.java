package control;

import model.ProductionDescriptor;
import neverlang.compiler.mdl.ModuleSource;

/*
 this class is used to get all the currently selected objects
 */
public class Configurator {

    //MODULES
    private ModuleSource abstract_syntax;
    private ModuleSource concrete_syntax;
    private ModuleSource semantic_module;
    private ModuleSource last_set_module;
    private String role;

    //MAPPING
    private ProductionDescriptor concrete_production;
    private int concrete_production_nt = -1;

    public ModuleSource getAbstractSyntax() {
        return abstract_syntax;
    }

    public ModuleSource getConcreteSyntax() {
        return concrete_syntax;
    }

    public ModuleSource getSemanticModule() {
        return semantic_module;
    }

    public String getRole() {
        return role;
    }

    public ModuleSource getLastSetModule()
    {
        return last_set_module;
    }

    public void setAbstractSyntax(ModuleSource abstract_syntax) {
        this.resetMappingValues();
        this.abstract_syntax = this.last_set_module = abstract_syntax;
        this.concrete_syntax = null;
        this.semantic_module = null;
        this.role = null;
    }

    public void setConcreteSyntax(ModuleSource concrete_syntax) {
        this.resetMappingValues();
        this.concrete_syntax = this.last_set_module = concrete_syntax;
        this.semantic_module = null;
        this.role = null;
    }

    public void setSemanticModule(ModuleSource semantic_module) {
        this.resetMappingValues();
        this.semantic_module = this.last_set_module = semantic_module;
        this.role = null;
    }

    public void setRole(String role) {
        this.resetMappingValues();
        this.role = role;
    }

    //MAPPING

    public int getConcreteProductionNt() {
        return concrete_production_nt;
    }

    public ProductionDescriptor getConcreteProduction() {
        return concrete_production;
    }

    public void setConcreteProductionAndNtId(ProductionDescriptor concrete_production, int nt_id) {
        this.concrete_production = concrete_production;
        this.concrete_production_nt = nt_id;
    }

    public void resetMappingValues() {
        this.concrete_production = null;
        this.concrete_production_nt = -1;
    }

    public void reset(){
        this.abstract_syntax =
                this.last_set_module =
                        this.concrete_syntax =
                                this.semantic_module = null;
        this.role = null;

        resetMappingValues();
    }
}
