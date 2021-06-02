package neverlang.commons.expressions.div;
import neverlang.runtime.Syntax;

public class DivisionSyntax$role$syntax extends Syntax {
 public DivisionSyntax$role$syntax() {
  provides(
    tag(nt("MulExpression"), "expressions", "math", "div", "infix")
  );
  requires(
    tag(nt("AbstractMulOperand"))
  );
   declareProductions(
    p(nt("MulExpression"), nt("MulExpression"), "/", nt("AbstractMulOperand")).setLabel("division").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("/"));


 }
}