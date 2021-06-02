package neverlang.commons.expressions.sub;
import neverlang.runtime.Syntax;

public class PostfixSubtractionSyntax$role$syntax extends Syntax {
 public PostfixSubtractionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "sub", "postfix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), nt("AddExpression"), nt("AbstractAddOperand"), "-").setLabel("subtraction").setScore(0)
   );
   

 }
}