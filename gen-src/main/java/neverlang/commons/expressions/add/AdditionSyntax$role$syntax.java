package neverlang.commons.expressions.add;
import neverlang.runtime.Syntax;

public class AdditionSyntax$role$syntax extends Syntax {
 public AdditionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "add", "infix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), nt("AddExpression"), "+", nt("AbstractAddOperand")).setLabel("addition").setScore(0),
    p(nt("AddExpression"), nt("AddExpression"), "+", nt("AbstractAddOperand")).setScore(0),
    p(nt("AddExpression"), nt("AddExpression"), "+", nt("AbstractAddOperand"), "+", nt("AbstractAddOperand")).setScore(0)
   );
   addCategoryDefinition("Operator",keyword("+"));


 }
}