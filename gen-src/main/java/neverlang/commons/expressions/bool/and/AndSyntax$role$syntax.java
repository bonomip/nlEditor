package neverlang.commons.expressions.bool.and;
import neverlang.runtime.Syntax;

public class AndSyntax$role$syntax extends Syntax {
 public AndSyntax$role$syntax() {
  provides(
    tag(nt("AndExpression"), "expressions", "boolean", "and", "infix")
  );
  requires(
    tag(nt("AbstractAndOperand"))
  );
   declareProductions(
    p(nt("AndExpression"), nt("AndExpression"), "&&", nt("AbstractAndOperand")).setLabel("and").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("&&"));


 }
}