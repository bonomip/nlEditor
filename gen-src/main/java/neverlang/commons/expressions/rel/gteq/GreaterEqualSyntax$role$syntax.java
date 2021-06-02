package neverlang.commons.expressions.rel.gteq;
import neverlang.runtime.Syntax;

public class GreaterEqualSyntax$role$syntax extends Syntax {
 public GreaterEqualSyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "greater")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("RelExpression"), nt("RelExpression"), ">=", nt("AbstractRelOperand")).setLabel("greater").setScore(0)
   );
   addCategoryDefinition("Operator",keyword(">="));


 }
}