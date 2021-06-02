package neverlang.commons.expressions.sub;
import neverlang.runtime.Syntax;

public class SubtractionSyntax$role$syntax extends Syntax {
 public SubtractionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "sub", "infix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), nt("AddExpression"), "-", nt("AbstractAddOperand")).setLabel("subtraction").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("-"));


 }
}