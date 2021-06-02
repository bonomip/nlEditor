package model;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;

public class Slice {

    public enum Entry {
        OTHER,
        NAME,
        SYNTAX,
        SEMANTIC,
        ROLE,
        MAPPING
    }

    String slice_name;
    String syntax_module_name;

    ArrayList<String> semantic_module_names, role_names;
    HashMap<String, String> mappings;

    public Slice(String name){
        this.slice_name = name;
        this.syntax_module_name = null;
        this.semantic_module_names = new ArrayList<>();
        this.role_names = new ArrayList<>();
        this.mappings = new HashMap<>();
    }

    public void addSliceName(String s){
        this.slice_name = s;
    }

    public void addSyntaxModule(String s){
        this.syntax_module_name = s;
    }

    public boolean addSemantic(String module_name, String role_name, String mapping){
        if(this.isRoleFree(role_name)) return false;

        this.semantic_module_names.add(module_name);
        this.role_names.add(role_name);
        this.mappings.put(role_name, mapping);

        return true;
    }

    public boolean addSemantic(String module_name, String role_name){
        if(this.isRoleFree(role_name)) return false;

        this.semantic_module_names.add(module_name);
        this.role_names.add(role_name);

        return true;
    }

    public boolean removeSyntax(){
        if( this.syntax_module_name == null ) return false;

        this.syntax_module_name = null;
        this.semantic_module_names.clear();
        this.role_names.clear();
        this.mappings.clear();

        return true;
    }

    public boolean removeSemanticModule(int group){
        if( this.semantic_module_names.size() < group ) return  false;

        this.mappings.remove(this.semantic_module_names.get(group));
        this.semantic_module_names.remove(group);
        this.role_names.remove(group);

        return true;
    }

    public boolean removeMapping(int group){

        System.out.println(group);
        System.out.println(this.role_names.get(group));
        System.out.println(this.mappings.keySet());

        if( !this.mappings.containsKey(this.role_names.get(group)) ) return false;

        this.mappings.remove(this.role_names.get(group));

        return true;
    }

    public boolean isValid(){
        return this.syntax_module_name != null &&
                this.semantic_module_names.size() > 0 &&
                this.role_names.size() > 0;
    }

    private boolean isRoleFree(String role){
        return this.role_names.contains(role);
    }

    public ArrayList<Pair<Entry,String>> getElements(){
        assert isValid();

        ArrayList<Pair<Entry,String>> tmp = new ArrayList<>();

        tmp.add(new Pair<>(Entry.OTHER, "slice "));
        tmp.add(new Pair<>(Entry.NAME, this.slice_name));
        tmp.add(new Pair<>(Entry.OTHER, " {\n\tconcrete syntax from "));
        tmp.add(new Pair<>(Entry.SYNTAX, this.syntax_module_name));

        for(int i = 0; i < this.semantic_module_names.size(); i++) {
            tmp.add(new Pair<>(Entry.OTHER, "\n\tmodule "));
            tmp.add(new Pair<>(Entry.SEMANTIC, this.semantic_module_names.get(i)));
            tmp.add(new Pair<>(Entry.OTHER, " with role "));
            tmp.add(new Pair<>(Entry.ROLE, this.role_names.get(i)));
            if (this.mappings.containsKey(this.role_names.get(i)))
                tmp.add(new Pair<>(Entry.MAPPING, " mapping {" + this.mappings.get(this.role_names.get(i)) + "\n\t}"));
        }

        tmp.add(new Pair<>(Entry.OTHER,"\n}"));

        return tmp;
    }

    public String getSource() {

        /*
        StringBuilder s = new StringBuilder("slice " + this.slice_name + " {\n" +
                "\tconcrete syntax from " + this.syntax_module_name);

        for (int i = 0; i < this.semantic_module_names.size(); i++) {
            s.append("\n\tmodule ")
                    .append(this.semantic_module_names.get(i))
                    .append(" with role ")
                    .append(this.role_names.get(i));
            if (this.mappings.size() > i)
                s.append(" mapping {").append(this.mappings.get(i)).append("\n\t}");
        }
        return s.append("\n}").toString();

        */

        StringBuilder sb = new StringBuilder();
        for(Pair<Entry,String> s : this.getElements())
            sb.append(s.getValue());

        return sb.toString();
    }
}
