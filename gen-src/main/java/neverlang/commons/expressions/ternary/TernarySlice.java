package neverlang.commons.expressions.ternary;
import neverlang.runtime.*;
public class TernarySlice extends Slice {
  public TernarySlice() {
    importSyntax("neverlang.commons.expressions.ternary.TernarySyntax");
        imports("neverlang.commons.expressions.ternary.TernaryEvaluation", 
         role("expression_initialization"));
    imports("neverlang.commons.expressions.ternary.TernarySyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
