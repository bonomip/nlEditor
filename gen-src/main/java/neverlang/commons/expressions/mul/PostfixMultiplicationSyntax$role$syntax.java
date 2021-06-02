package neverlang.commons.expressions.mul;
import neverlang.runtime.Syntax;

public class PostfixMultiplicationSyntax$role$syntax extends Syntax {
 public PostfixMultiplicationSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "mul", "postfix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), nt("AbstractMulOperand"), "*").setLabel("multiplication").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("*"));


 }
}