package neverlang.commons.expressions.bool.or;
import neverlang.runtime.Syntax;

public class OrSyntax$role$syntax extends Syntax {
 public OrSyntax$role$syntax() {
  provides(
    tag(nt("OrExpression"), "expressions", "boolean", "or", "infix")
  );
  requires(
    tag(nt("AbstractOrOperand"))
  );
   declareProductions(
    p(nt("OrExpression"), nt("OrExpression"), "||", nt("AbstractOrOperand")).setLabel("or").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("||"));


 }
}