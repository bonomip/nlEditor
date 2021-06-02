import neverlang.runtime.Syntax;

public class Expr$role$syntax extends Syntax {
 public Expr$role$syntax() {
   declareProductions(
    p(nt("Expression"), nt("MulExpression")).setScore(0),
    p(nt("Expression"), nt("AddExpression")).setScore(0),
    p(nt("Expression"), nt("Integer")).setScore(0),
    p(nt("Expression"), nt("Factor")).setScore(0)
   );
   

 }
}