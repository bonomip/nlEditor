package neverlang.commons.expressions.add;
import neverlang.runtime.*;
public class AdditionOperandSlice extends Slice {
  public AdditionOperandSlice() {
    importSyntax("neverlang.commons.expressions.add.AdditionOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
