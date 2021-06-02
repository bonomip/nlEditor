package neverlang.commons.expressions.bitwise.ushift;
import neverlang.runtime.*;
public class UnsignedShiftEvaluation extends neverlang.runtime.Module {
  public UnsignedShiftEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.ushift.UnsignedShiftSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
