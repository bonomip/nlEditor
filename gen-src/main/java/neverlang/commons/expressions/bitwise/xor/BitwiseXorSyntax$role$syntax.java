package neverlang.commons.expressions.bitwise.xor;
import neverlang.runtime.Syntax;

public class BitwiseXorSyntax$role$syntax extends Syntax {
 public BitwiseXorSyntax$role$syntax() {
  provides(
    tag(nt("BitwiseXorExpression"), "expressions", "bitwise", "xor")
  );
  requires(
    tag(nt("AbstractBitwiseXorOperand"))
  );
   declareProductions(
    p(nt("BitwiseXorExpression"), nt("BitwiseXorExpression"), "^", nt("AbstractBitwiseXorOperand")).setLabel("xor").setScore(0)
   );
   addCategoryDefinition("Operator",keyword("^"));


 }
}