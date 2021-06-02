package neverlang.commons.expressions.bitwise.lshift;
import neverlang.runtime.Syntax;

public class LeftShiftSyntax$role$syntax extends Syntax {
 public LeftShiftSyntax$role$syntax() {
  provides(
    tag(nt("ShiftExpression"), "expressions", "bitwise", "shift")
  );
  requires(
    tag(nt("AbstractShiftOperand"))
  );
   declareProductions(
    p(nt("ShiftExpression"), nt("ShiftExpression"), "<<", nt("AbstractShiftOperand")).setLabel("shift").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("<<"));


 }
}