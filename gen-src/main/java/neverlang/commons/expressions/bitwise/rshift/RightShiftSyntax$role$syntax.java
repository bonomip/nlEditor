package neverlang.commons.expressions.bitwise.rshift;
import neverlang.runtime.Syntax;

public class RightShiftSyntax$role$syntax extends Syntax {
 public RightShiftSyntax$role$syntax() {
  provides(
    tag(nt("ShiftExpression"), "expressions", "bitwise", "shift")
  );
  requires(
    tag(nt("AbstractShiftOperand"))
  );
   declareProductions(
    p(nt("ShiftExpression"), nt("ShiftExpression"), ">>", nt("AbstractShiftOperand")).setLabel("shift").setScore(0)
   );
   addCategoryDefinition("Operator",keyword(">>"));


 }
}