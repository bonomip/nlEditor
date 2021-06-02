package neverlang.commons.expressions.rel.lt;
import neverlang.runtime.Syntax;

public class LessSyntax$role$syntax extends Syntax {
 public LessSyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "less")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("RelExpression"), nt("RelExpression"), "<", nt("AbstractRelOperand")).setLabel("less").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("<"));


 }
}