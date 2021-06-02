package model;

import javafx.util.Pair;
import neverlang.compiler.mdl.ModuleSource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Mapper {

    ArrayList<ProductionDescriptor> concrete_prod;
    ArrayList<ProductionDescriptor> semantic_prod;
    ArrayList<String> swaps;

    public Mapper(ModuleSource concrete_module, ModuleSource semantic_module, String role) {
        this.concrete_prod = (ArrayList<ProductionDescriptor>) Arrays
                .stream(concrete_module.getSyntax())
                .map(p -> new ProductionDescriptor(p, ProductionDescriptor.getNtIds(concrete_module).get(p.hashCode())))
                .collect(Collectors.toList());
        this.semantic_prod = (ArrayList<ProductionDescriptor>) Arrays
                .stream(semantic_module.getSyntax())
                .map(p -> new ProductionDescriptor(p, ProductionDescriptor.getNtIds(semantic_module).get(p.hashCode())))
                .collect(Collectors.toList());
        this.swaps = new ArrayList<>();
    }

    public ArrayList<ProductionDescriptor> getConcreteProductionDescriptors() {
        return this.concrete_prod;
    }

    public ArrayList<ProductionDescriptor> getSemanticProductionDescriptors() {
        return this.semantic_prod;
    }

    public ArrayList<Pair<ProductionDescriptor, int[]>> getValidNonTerminalsFrom(ProductionDescriptor p, int nt_idx) {
        ArrayList<Pair<ProductionDescriptor, int[]>> res = new ArrayList<>();

        for(ProductionDescriptor prod_desc : this.semantic_prod) {
            if(ProductionDescriptor.compareProductions(p, prod_desc)) {
                int[] nts = prod_desc.getAvailableNts(nt_idx);
                if (nts != null)
                    res.add(new Pair<>(prod_desc, nts));
            }
        }

        return res;
    }

    public boolean isNtAvailable(ProductionDescriptor p, int nt_idx) {
        return p.isAvailable(nt_idx);
    }

    public void swap(ProductionDescriptor concrete_prod, int concrete_nt_id, ProductionDescriptor semantic_prod, int semantic_nt_id) {
        ProductionDescriptor.linkProductions(concrete_prod, semantic_prod);
        concrete_prod.setUsed(concrete_nt_id);
        semantic_prod.setUsed(semantic_nt_id);

        this.swaps.add(concrete_prod.getGlobalId(concrete_nt_id)+" => "+semantic_prod.getGlobalId(semantic_nt_id));
    }

    public int getSwapsNumber(){
        return this.swaps.size();
    }

    public String getString(){
        StringBuilder sb = new StringBuilder();
        String comma = "";
        String format = "\n\t\t";
        for(String s : this.swaps){
            sb.append(comma).append(format).append(s);
            comma = ",";
        }
        return sb.toString();
    }

    public void reset(){
        this.swaps.clear();
        for(ProductionDescriptor p :
                Stream.concat(this.concrete_prod.stream(), this.semantic_prod.stream())
                        .collect(Collectors.toList()))
            p.reset();
    }

}
