import neverlang.runtime.Syntax;

public class SumExpr$role$syntax extends Syntax {
 public SumExpr$role$syntax() {
   declareProductions(
    p(nt("AddExpression"), nt("Term"), "+", nt("Expression")).setScore(0)
   );
   

 }
}