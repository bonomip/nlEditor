package neverlang.commons.expressions.rem;
import neverlang.runtime.Syntax;

public class PrefixRemainderSyntax$role$syntax extends Syntax {
 public PrefixRemainderSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "rem", "prefix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), "%", nt("MulExpression"), nt("AbstractMulOperand")).setLabel("remainder").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("%"));


 }
}