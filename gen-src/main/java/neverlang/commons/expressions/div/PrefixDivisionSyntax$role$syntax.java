package neverlang.commons.expressions.div;
import neverlang.runtime.Syntax;

public class PrefixDivisionSyntax$role$syntax extends Syntax {
 public PrefixDivisionSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "div", "prefix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), "/", nt("MulExpression"), nt("AbstractMulOperand")).setLabel("division").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("/"));


 }
}