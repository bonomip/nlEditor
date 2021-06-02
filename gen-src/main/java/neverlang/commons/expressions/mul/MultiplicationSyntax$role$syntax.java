package neverlang.commons.expressions.mul;
import neverlang.runtime.Syntax;

public class MultiplicationSyntax$role$syntax extends Syntax {
 public MultiplicationSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "mul", "infix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), "*", nt("AbstractMulOperand")).setLabel("multiplication").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("*"));


 }
}