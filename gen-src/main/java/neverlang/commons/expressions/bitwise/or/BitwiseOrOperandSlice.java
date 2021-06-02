package neverlang.commons.expressions.bitwise.or;
import neverlang.runtime.*;
public class BitwiseOrOperandSlice extends Slice {
  public BitwiseOrOperandSlice() {
    importSyntax("neverlang.commons.expressions.bitwise.or.BitwiseOrOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
