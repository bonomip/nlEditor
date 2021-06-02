package neverlang.commons.expressions.bitwise.xor;
import neverlang.runtime.Syntax;

public class BitwiseXorOperand$role$syntax extends Syntax {
 public BitwiseXorOperand$role$syntax() {
  provides(
    tag(nt("BitwiseXorExpression"), "expressions", "bitwise", "xor")
  );
  requires(
    tag(nt("AbstractBitwiseXorOperand"))
  );
   declareProductions(
    p(nt("BitwiseXorExpression"), nt("AbstractBitwiseXorOperand")).setScore(0)
   );
   

 }
}