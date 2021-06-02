package neverlang.commons.expressions.ternary;
import neverlang.runtime.Syntax;

public class TernaryOperand$role$syntax extends Syntax {
 public TernaryOperand$role$syntax() {
  provides(
    tag(nt("TernaryExpression"), "expressions", "ternary")
  );
  requires(
    tag(nt("AbstractTernaryOperand"))
  );
   declareProductions(
    p(nt("TernaryExpression"), nt("AbstractTernaryOperand")).setScore(0)
   );
   

 }
}