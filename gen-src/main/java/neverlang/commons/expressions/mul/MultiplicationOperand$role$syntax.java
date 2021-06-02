package neverlang.commons.expressions.mul;
import neverlang.runtime.Syntax;

public class MultiplicationOperand$role$syntax extends Syntax {
 public MultiplicationOperand$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "mul", "operand")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("AbstractMulOperand")).setScore(0)
   );
   

 }
}