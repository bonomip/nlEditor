package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class UnaryExpr$role$syntax extends Syntax {
 public UnaryExpr$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary")
  );
  requires(
    tag(nt("AbstractUnaryOperand"))
  );
   declareProductions(
    p(nt("UnaryExpression"), nt("AbstractUnaryOperand")).setLabel("unary").setScore(0)
   );
   
   addInputBuckets(item(0, 1),"Variables");

 }
}