package neverlang.commons.expressions.unary;
import neverlang.runtime.Syntax;

public class ParenthesizedExpression$role$syntax extends Syntax {
 public ParenthesizedExpression$role$syntax() {
  provides(
    tag(nt("UnaryExpression"), "expressions", "unary", "parenthesis")
  );
  requires(
    tag(nt("AbstractExpression"))
  );
   declareProductions(
    p(nt("UnaryExpression"), "(", nt("AbstractExpression"), ")").setLabel("unary").setScore(0)
   );
   addCategoryDefinition("Brackets",keyword("("),keyword(")"));


 }
}