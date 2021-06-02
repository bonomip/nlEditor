package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class ParenthesizedExpressionSlice extends Slice {
  public ParenthesizedExpressionSlice() {
    importSyntax("neverlang.commons.expressions.unary.ParenthesizedExpression");
        imports("neverlang.commons.expressions.unary.ParenthesizedExpression", 
         role("translate"));
    imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
