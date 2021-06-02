package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryMinusSlice extends Slice {
  public UnaryMinusSlice() {
    importSyntax("neverlang.commons.expressions.unary.UnaryMinus");
        imports("neverlang.commons.expressions.unary.UnaryMinus", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
