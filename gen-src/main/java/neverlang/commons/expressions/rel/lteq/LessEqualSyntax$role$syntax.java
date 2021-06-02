package neverlang.commons.expressions.rel.lteq;
import neverlang.runtime.Syntax;

public class LessEqualSyntax$role$syntax extends Syntax {
 public LessEqualSyntax$role$syntax() {
  provides(
    tag(nt("RelExpression"), "expressions", "relational", "less")
  );
  requires(
    tag(nt("AbstractRelOperand"))
  );
   declareProductions(
    p(nt("RelExpression"), nt("RelExpression"), "<=", nt("AbstractRelOperand")).setLabel("less").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("<="));


 }
}