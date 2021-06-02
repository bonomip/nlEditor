package neverlang.commons.expressions.mul;
import neverlang.runtime.Syntax;

public class PrefixMultiplicationSyntax$role$syntax extends Syntax {
 public PrefixMultiplicationSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "mul", "prefix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), "*", nt("MulExpression"), nt("AbstractMulOperand")).setLabel("multiplication").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("*"));


 }
}