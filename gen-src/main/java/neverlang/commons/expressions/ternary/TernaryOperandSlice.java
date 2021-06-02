package neverlang.commons.expressions.ternary;
import neverlang.runtime.*;
public class TernaryOperandSlice extends Slice {
  public TernaryOperandSlice() {
    importSyntax("neverlang.commons.expressions.ternary.TernaryOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
