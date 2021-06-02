package neverlang.commons.expressions.rel.neq;
import neverlang.runtime.Syntax;

public class NotEqualitySyntax$role$syntax extends Syntax {
 public NotEqualitySyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "equals")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("EqExpression"), nt("EqExpression"), "!=", nt("AbstractEqOperand")).setLabel("equals").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("!="));


 }
}