package neverlang.commons.expressions.bitwise.and;
import neverlang.runtime.Syntax;

public class BitwiseAndOperand$role$syntax extends Syntax {
 public BitwiseAndOperand$role$syntax() {
  provides(
    tag(nt("BitwiseAndExpression"), "expressions", "bitwise", "and")
  );
  requires(
    tag(nt("AbstractBitwiseAndOperand"))
  );
   declareProductions(
    p(nt("BitwiseAndExpression"), nt("AbstractBitwiseAndOperand")).setScore(0)
   );
   

 }
}