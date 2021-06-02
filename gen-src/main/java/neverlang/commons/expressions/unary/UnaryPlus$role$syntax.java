package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class UnaryPlus$role$syntax extends Syntax {
 public UnaryPlus$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary", "math", "plus")
  );
  requires(
    tag(nt("AbstractUnaryOperand"))
  );
   declareProductions(
    p(nt("UnaryExpression"), "+", nt("UnaryExpression")).setLabel("plus").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("+"));


 }
}