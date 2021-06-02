package neverlang.commons.expressions.rel;
import neverlang.runtime.Syntax;

public class EqualityOperand$role$syntax extends Syntax {
 public EqualityOperand$role$syntax() {
  provides(
    tag(nt("EqExpression"), "expressions", "relational")
  );
  requires(
    tag(nt("AbstractEqOperand"))
  );
   declareProductions(
    p(nt("EqExpression"), nt("AbstractEqOperand")).setScore(0)
   );
   

 }
}