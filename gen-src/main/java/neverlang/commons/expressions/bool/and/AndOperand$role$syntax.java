package neverlang.commons.expressions.bool.and;
import neverlang.runtime.Syntax;

public class AndOperand$role$syntax extends Syntax {
 public AndOperand$role$syntax() {
  provides(
    tag(nt("AndExpression"), "expressions", "boolean", "and")
  );
  requires(
    tag(nt("AbstractAndOperand"))
  );
   declareProductions(
    p(nt("AndExpression"), nt("AbstractAndOperand")).setScore(0)
   );
   

 }
}