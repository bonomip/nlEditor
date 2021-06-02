package neverlang.commons.expressions.ternary;
import neverlang.runtime.Syntax;

public class TernaryAlternatives$role$syntax extends Syntax {
 public TernaryAlternatives$role$syntax() {
  provides(
    tag(nt("TernaryAlternatives"), "expressions", "ternary")
  );
  requires(
    tag(nt("AbstractTernaryOperand"))
  );
   declareProductions(
    p(nt("TernaryAlternatives"), nt("AbstractTernaryOperand"), ":", nt("AbstractTernaryOperand")).setScore(0)
   );
   addCategoryDefinition("Operator",keyword(":"));


 }
}