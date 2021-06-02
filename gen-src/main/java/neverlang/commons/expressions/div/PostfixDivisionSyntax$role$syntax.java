package neverlang.commons.expressions.div;
import neverlang.runtime.Syntax;

public class PostfixDivisionSyntax$role$syntax extends Syntax {
 public PostfixDivisionSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "div", "postfix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), nt("AbstractMulOperand"), "/").setLabel("division").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("/"));


 }
}