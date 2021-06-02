package neverlang.commons.expressions.rel;
import neverlang.runtime.Syntax;

public class RelationalOperand$role$syntax extends Syntax {
 public RelationalOperand$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("RelExpression"), nt("AbstractRelOperand")).setScore(0)
   );
   

 }
}