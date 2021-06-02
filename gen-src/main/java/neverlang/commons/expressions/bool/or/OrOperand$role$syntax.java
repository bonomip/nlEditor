package neverlang.commons.expressions.bool.or;
import neverlang.runtime.Syntax;

public class OrOperand$role$syntax extends Syntax {
 public OrOperand$role$syntax() {
  provides(
    tag(nt("OrExpression"), "expressions", "boolean", "or")
  );
  requires(
    tag(nt("AbstractOrOperand"))
  );
   declareProductions(
    p(nt("OrExpression"), nt("AbstractOrOperand")).setScore(0)
   );
   

 }
}