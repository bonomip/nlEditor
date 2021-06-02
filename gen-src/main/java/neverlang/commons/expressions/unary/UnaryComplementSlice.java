package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryComplementSlice extends Slice {
  public UnaryComplementSlice() {
    importSyntax("neverlang.commons.expressions.unary.UnaryComplement");
        imports("neverlang.commons.expressions.unary.UnaryComplement", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.unary.UnaryExpr", 
         role("expression_initialization"), 
         role("translate"));

  }
}
