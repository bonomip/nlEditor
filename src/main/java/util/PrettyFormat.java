package util;

import dexter.grammar.Production;
import neverlang.compiler.mdl.ModuleSource;

import java.io.*;
import java.net.URL;
import java.util.stream.Collectors;

public class PrettyFormat {
    private static String toStringSyntax(Production production){
            return production.nt.toString() + " --> " + production.body.toString();
    }

    public static String getSyntax(ModuleSource module) {
        StringBuilder sb = new StringBuilder();
        for ( Production p : module.getSyntax() )
            sb.append(toStringSyntax(p)).append("\n");
        return sb.toString();
    }

    public static String getSemanticRoles(ModuleSource module) {
        StringBuilder sb = new StringBuilder();
        for( String s : module.getRoles() )
            sb.append(s).append("\n");

        return sb.toString();
    }

    public static String getPlainSourceCode(ModuleSource module) throws IOException {
        BufferedReader reader = new BufferedReader(Resource.getFile(module.getCanonicalName()));
        return reader.lines().collect(Collectors.joining("\n"));
    }



    public static String getHTMLFromModule(ModuleSource module) throws  IOException {
        //todo checks
        String file_path = "src/main/"+module.getCanonicalName().replace(".","/")+".nl";
        String command = "pygmentize -O full,style=emacs,linenos=1 -f html -x -l lexer.py:NeverlangLexer "+file_path;
        Process proc = Runtime.getRuntime().exec(command);

        BufferedReader reader =
                new BufferedReader(new InputStreamReader(proc.getInputStream()));

        return reader.lines().collect(Collectors.joining("\n"));
    }
}
