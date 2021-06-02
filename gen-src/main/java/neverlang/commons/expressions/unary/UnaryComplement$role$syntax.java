package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class UnaryComplement$role$syntax extends Syntax {
 public UnaryComplement$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary", "bitwise", "complement")
  );
  requires(
    tag(nt("AbstractUnaryOperand"))
  );
   declareProductions(
    p(nt("UnaryExpression"), "~", nt("UnaryExpression")).setLabel("complement").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("~"));


 }
}