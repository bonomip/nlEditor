package neverlang.commons.expressions.bitwise.or;
import neverlang.runtime.Syntax;

public class BitwiseOrSyntax$role$syntax extends Syntax {
 public BitwiseOrSyntax$role$syntax() {
  provides(
    tag(nt("BitwiseOrExpression"), "expressions", "bitwise", "or")
  );
  requires(
    tag(nt("AbstractBitOrOperand"))
  );
   declareProductions(
    p(nt("BitwiseOrExpression"), nt("BitwiseOrExpression"), "|", nt("AbstractBitwiseOrOperand")).setLabel("or").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("|"));


 }
}