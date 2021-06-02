package neverlang.commons.expressions.rel.gt;
import neverlang.runtime.Syntax;

public class GreaterSyntax$role$syntax extends Syntax {
 public GreaterSyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "greater")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("RelExpression"), nt("RelExpression"), ">", nt("AbstractRelOperand")).setLabel("greater").setScore(0)
   );
   addCategoryDefinition("Operator",keyword(">"));


 }
}