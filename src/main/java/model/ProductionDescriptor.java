package model;

import dexter.grammar.Production;
import dexter.grammar.Symbol;
import neverlang.compiler.mdl.ModuleSource;

import java.util.*;

public class ProductionDescriptor {

    private Production production;
    private ProductionDescriptor link;
    private int [] global_nt_ids;
    private int [] nt_ids;
    private boolean [] nt_av;

    public ProductionDescriptor(Production p, int[] ntIds) {
        this.production = p;

        this.link = null;

        /*nonterminal ids globally to the whole semantic
         *      0     1 2
         *  p1) A <-- B C
         *
         *      3     4
         *  p2) D <-- E
         */
        this.global_nt_ids = ntIds;


       /* nonterminal ids relative to the production
        *      0     1 2
        *  p1) A <-- B C
        *
        *      0     1
        *  p2) D <-- E
        */
        this.nt_ids = new int[this.global_nt_ids.length];
        for(int i = 0; i < this.nt_ids.length; i++)
            this.nt_ids[i] = i;
       /*
        * an array of boolean containing all the nonterminal
        * availabilities (the nonterminal not mapped yet)
        * it reset when the production is unlinked
        */
        this.nt_av = new boolean[this.global_nt_ids.length];
        Arrays.fill(this.nt_av, true);
    }

    /*
     * return ProductionDescriptor to chain methods
     * es: ProductionDescriptor A, B;
     *     A.linkProduction(B.linkProduction(A));
     */
    public ProductionDescriptor linkProduction(ProductionDescriptor p) {
        assert this.link == null;
        this.link = p;
        return this;
    }

    /*
     * return ProductionDescriptor to chain methods
     * es: ProductionDescriptor A, B;
     *     A.unlinkProduction(B.unlinkProduction(A));
     */
    public ProductionDescriptor unlinkProduction(Production p) {
        assert this.link != null;

        Arrays.fill(this.nt_av, true);
        this.link = null;
        return this;
    }

    public int getNtCount() {
        return this.production.body.ntCount()+1;
    }

    public int getGlobalId(int id) {
        return this.global_nt_ids[id];
    }

    /*
     * this method return all the compatible nonterminal ids that are currently available
     * the result is an array of Integers. The value are the relative position of the available
     * nonterminals;
     *
     * returns null if no terminals are available
     */
    public int[] getAvailableNts(int ntId) {
        if(ntId == 0 && this.nt_av[0]) //if the request is about the left nt
                return new int[]{0};

        List<Integer> tmp = new ArrayList<>();

        for(int i = 1; i < this.nt_ids.length; i++)
            if(this.nt_av[i]) tmp.add(this.nt_ids[i]);

        return tmp.stream().mapToInt(i -> i).toArray();
    }

    public static boolean compareProductions(ProductionDescriptor p1, ProductionDescriptor p2) {
        boolean sameNonTerminals = p1.getNtCount() == p2.getNtCount();
        boolean sameLink = p1.link == p2 && p2.link == p1;
        boolean notLink = p1.link == null && p2.link == null;
        return  sameNonTerminals && ( sameLink || notLink);
    }

    public LinkedList<Symbol> getTokenizedProduction() {
        LinkedList<Symbol> result = new LinkedList<>();

        result.add(this.production.nt);
        result.addAll(this.production.body);

        return result;
    }

    public void setUsed(int id)
    {
        this.nt_av[id] = false;
    }

    public boolean isAvailable(int id){
        return this.nt_av[id];
    }

    public static HashMap<Integer, int[]> getNtIds(ModuleSource ms) {
        int id = 0;
        HashMap<Integer, int[]> tmp = new HashMap<>();
        int[] value;

        for(int i = 0; i < ms.getSyntax().length; i++) {
            value = new int[ms.getSyntax()[i].body.ntCount() + 1];
            for (int j = 0; j < ms.getSyntax()[i].body.ntCount() + 1; j++)
                value[j] = id++;
            tmp.put(ms.getSyntax()[i].hashCode(), value);
        }
        return tmp;
    }

    private static int[] getAllNtCount(ModuleSource ms){
        assert ms.getSyntax().length > 0;

        int [] tmp = new int[ms.getSyntax().length];

        for ( int i = 0; i < tmp.length; i++)
            tmp[i] = ms.getSyntax()[i].body.ntCount();

        return tmp;
    }

    /*
    creates a sorted array containing for each production the number
    of nonterminals inside its body
*/
    private static int[] getAllNtCountSorted(ModuleSource ms) {
        int [] tmp = getAllNtCount(ms);

        Arrays.sort(tmp);

        return tmp;
    }

    public static void linkProductions(ProductionDescriptor p1, ProductionDescriptor p2)
    {
        p1.linkProduction(p2.linkProduction(p1));
    }

    public static boolean compareModules(ModuleSource ms1, ModuleSource ms2){
        return Arrays.equals(getAllNtCountSorted(ms1), getAllNtCountSorted(ms2));
    }

    public static boolean isMappingOptional(ModuleSource ms1, ModuleSource ms2){
        return Arrays.equals(getAllNtCount(ms1), getAllNtCount(ms2));
    }

    public void reset() {
        Arrays.fill(this.nt_av, true);
        this.link = null;
    }

}
