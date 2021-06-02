package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryNotSlice extends Slice {
  public UnaryNotSlice() {
    importSyntax("neverlang.commons.expressions.unary.UnaryNot");
        imports("neverlang.commons.expressions.unary.UnaryNot", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
