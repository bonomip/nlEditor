package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryPlusSlice extends Slice {
  public UnaryPlusSlice() {
    importSyntax("neverlang.commons.expressions.unary.UnaryPlus");
        imports("neverlang.commons.expressions.unary.UnaryPlus", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
