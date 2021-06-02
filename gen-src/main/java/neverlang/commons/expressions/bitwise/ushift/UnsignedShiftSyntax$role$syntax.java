package neverlang.commons.expressions.bitwise.ushift;
import neverlang.runtime.Syntax;

public class UnsignedShiftSyntax$role$syntax extends Syntax {
 public UnsignedShiftSyntax$role$syntax() {
  provides(
    tag(nt("ShiftExpression"), "expressions", "bitwise", "shift")
  );
  requires(
    tag(nt("AbstractShiftOperand"))
  );
   declareProductions(
    p(nt("ShiftExpression"), nt("ShiftExpression"), ">>>", nt("AbstractShiftOperand")).setLabel("shift").setScore(0)
   );
   addCategoryDefinition("Operator",keyword(">>>"));


 }
}