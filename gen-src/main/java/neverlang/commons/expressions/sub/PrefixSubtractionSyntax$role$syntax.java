package neverlang.commons.expressions.sub;
import neverlang.runtime.Syntax;

public class PrefixSubtractionSyntax$role$syntax extends Syntax {
 public PrefixSubtractionSyntax$role$syntax() {
  provides(
    tag(nt("AddExpression"), "expressions", "math", "sub", "prefix")
  );
  requires(
    tag(nt("AbstractAddOperand"))
  );
   declareProductions(
    p(nt("AddExpression"), "-", nt("AddExpression"), nt("AbstractAddOperand")).setLabel("subtraction").setScore(0)
   );
   

 }
}