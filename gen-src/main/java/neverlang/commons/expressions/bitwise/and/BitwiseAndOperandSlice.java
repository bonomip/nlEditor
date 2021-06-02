package neverlang.commons.expressions.bitwise.and;
import neverlang.runtime.*;
public class BitwiseAndOperandSlice extends Slice {
  public BitwiseAndOperandSlice() {
    importSyntax("neverlang.commons.expressions.bitwise.and.BitwiseAndOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
