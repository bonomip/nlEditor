package neverlang.commons.expressions.rem;
import neverlang.runtime.Syntax;

public class PostfixRemainderSyntax$role$syntax extends Syntax {
 public PostfixRemainderSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "rem", "postfix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), nt("AbstractMulOperand"), "%").setLabel("remainder").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("%"));


 }
}