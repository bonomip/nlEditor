package neverlang.commons.expressions.mul;
import neverlang.runtime.*;
public class MultiplicationOperandSlice extends Slice {
  public MultiplicationOperandSlice() {
    importSyntax("neverlang.commons.expressions.mul.MultiplicationOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
