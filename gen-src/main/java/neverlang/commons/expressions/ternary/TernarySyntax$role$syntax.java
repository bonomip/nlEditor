package neverlang.commons.expressions.ternary;
import neverlang.runtime.Syntax;

public class TernarySyntax$role$syntax extends Syntax {
 public TernarySyntax$role$syntax() {
  provides(
    tag(nt("TernaryExpression"), "expressions", "ternary")
  );
  requires(
    tag(nt("TernaryAlternatives"))
  );
   declareProductions(
    p(nt("TernaryExpression"), nt("TernaryCondition"), "?", nt("TernaryAlternatives")).setLabel("ternary").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("?"));


 }
}