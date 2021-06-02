import neverlang.runtime.Syntax;

public class ProdExpr$role$syntax extends Syntax {
 public ProdExpr$role$syntax() {
   declareProductions(
    p(nt("MulExpression"), nt("Factor"), "*", nt("Expression")).setScore(0)
   );
   

 }
}