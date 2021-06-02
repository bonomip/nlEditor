package neverlang.commons.expressions.bitwise.xor;
import neverlang.runtime.*;
public class BitwiseXorOperandSlice extends Slice {
  public BitwiseXorOperandSlice() {
    importSyntax("neverlang.commons.expressions.bitwise.xor.BitwiseXorOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
