package neverlang.commons.expressions.bool.or;
import neverlang.runtime.*;
public class OrOperandSlice extends Slice {
  public OrOperandSlice() {
    importSyntax("neverlang.commons.expressions.bool.or.OrOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
