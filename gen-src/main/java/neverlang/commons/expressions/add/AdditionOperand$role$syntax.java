package neverlang.commons.expressions.add;
import neverlang.runtime.Syntax;

public class AdditionOperand$role$syntax extends Syntax {
 public AdditionOperand$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "add", "operand")
  );
  requires(
    tag(nt("AbstractAdditionOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), nt("AbstractAddOperand")).setScore(0)
   );
   

 }
}