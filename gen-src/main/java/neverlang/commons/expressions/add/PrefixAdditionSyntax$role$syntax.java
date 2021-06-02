package neverlang.commons.expressions.add;
import neverlang.runtime.Syntax;

public class PrefixAdditionSyntax$role$syntax extends Syntax {
 public PrefixAdditionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "add", "prefix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), "+", nt("AddExpression"), nt("AbstractAddOperand")).setLabel("addition").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("+"));


 }
}