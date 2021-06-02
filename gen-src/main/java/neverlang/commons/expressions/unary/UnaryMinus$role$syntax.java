package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class UnaryMinus$role$syntax extends Syntax {
 public UnaryMinus$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary", "math", "minus")
  );
  requires(
    tag(nt("AbstractUnaryOperand"))
  );
   declareProductions(
    p(nt("UnaryExpression"), "-", nt("UnaryExpression")).setLabel("minus").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("-"));


 }
}