package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class UnaryNot$role$syntax extends Syntax {
 public UnaryNot$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary", "boolean", "not")
  );
  requires(
    tag(nt("AbstractUnaryOperand"))
  );
   declareProductions(
    p(nt("UnaryExpression"), "!", nt("UnaryExpression")).setLabel("not").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("!"));


 }
}