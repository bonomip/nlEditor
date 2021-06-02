package neverlang.commons.expressions.bitwise;
import neverlang.runtime.*;
public class ShiftOperandSlice extends Slice {
  public ShiftOperandSlice() {
    importSyntax("neverlang.commons.expressions.bitwise.ShiftOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
