package neverlang.commons.expressions.rem;
import neverlang.runtime.Syntax;

public class RemainderSyntax$role$syntax extends Syntax {
 public RemainderSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "infix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), "%", nt("AbstractMulOperand")).setLabel("remainder").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("%"));


 }
}