package neverlang.commons.expressions.add;
import neverlang.runtime.Syntax;

public class PostfixAdditionSyntax$role$syntax extends Syntax {
 public PostfixAdditionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "add", "postfix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), nt("AddExpression"), nt("AbstractAddOperand"), "+").setLabel("addition").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("+"));


 }
}