package neverlang.commons.expressions.rel;
import neverlang.runtime.*;
public class EqualityOperandSlice extends Slice {
  public EqualityOperandSlice() {
    importSyntax("neverlang.commons.expressions.rel.EqualityOperand");
        imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
