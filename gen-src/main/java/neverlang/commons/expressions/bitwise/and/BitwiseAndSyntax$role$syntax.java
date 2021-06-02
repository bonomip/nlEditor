package neverlang.commons.expressions.bitwise.and;
import neverlang.runtime.Syntax;

public class BitwiseAndSyntax$role$syntax extends Syntax {
 public BitwiseAndSyntax$role$syntax() {
  provides(
    tag(nt("BitwiseAndExpression"), "expressions", "bitwise", "and")
  );
  requires(
    tag(nt("AbstractBitAndOperand"))
  );
   declareProductions(
    p(nt("BitwiseAndExpression"), nt("BitwiseAndExpression"), "&", nt("AbstractBitwiseAndOperand")).setLabel("and").setScore(0),
    p(nt("BitwiseAndExpression"), nt("BitwiseAndExpression"), "&", nt("AbstractBitwiseAndOperand")).setScore(0),
    p(nt("BitwiseAndExpression"), nt("BitwiseAndExpression"), "&", nt("AbstractBitwiseAndOperand"), "&", nt("AbstractBitwiseAndOperand")).setScore(0)
   );
   addCategoryDefinition("Operator",keyword("&"));


 }
}