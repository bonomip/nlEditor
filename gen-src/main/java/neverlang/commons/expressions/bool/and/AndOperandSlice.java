package neverlang.commons.expressions.bool.and;
import neverlang.runtime.*;
public class AndOperandSlice extends Slice {
  public AndOperandSlice() {
    importSyntax("neverlang.commons.expressions.bool.and.AndOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
