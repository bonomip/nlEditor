package neverlang.commons.expressions.bitwise;
import neverlang.runtime.Syntax;

public class ShiftOperand$role$syntax extends Syntax {
 public ShiftOperand$role$syntax() {
  provides(
    tag(nt("ShiftExpression"), "expressions", "bitwise", "shift")
  );
  requires(
    tag(nt("AbstractShiftOperand"))
  );
   declareProductions(
    p(nt("ShiftExpression"), nt("AbstractShiftOperand")).setScore(0)
   );
   

 }
}