package neverlang.commons.expressions.rel.eq;
import neverlang.runtime.Syntax;

public class EqualitySyntax$role$syntax extends Syntax {
 public EqualitySyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "equals")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("EqExpression"), nt("EqExpression"), "==", nt("AbstractEqOperand")).setLabel("equals").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("=="));


 }
}