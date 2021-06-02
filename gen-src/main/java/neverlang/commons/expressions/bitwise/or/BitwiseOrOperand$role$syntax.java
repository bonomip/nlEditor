package neverlang.commons.expressions.bitwise.or;
import neverlang.runtime.Syntax;

public class BitwiseOrOperand$role$syntax extends Syntax {
 public BitwiseOrOperand$role$syntax() {
  provides(
    tag(nt("BitwiseOrExpression"), "expressions", "bitwise", "or")
  );
  requires(
    tag(nt("AbstractBitwiseOrOperand"))
  );
   declareProductions(
    p(nt("BitwiseOrExpression"), nt("AbstractBitwiseOrOperand")).setScore(0)
   );
   

 }
}