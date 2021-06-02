package neverlang.commons.expressions.rel;
import neverlang.runtime.*;
public class RelationalOperandSlice extends Slice {
  public RelationalOperandSlice() {
    importSyntax("neverlang.commons.expressions.rel.RelationalOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
