package neverlang.commons.expressions.bitwise.rshift;
import neverlang.runtime.*;
public class RightShiftEvaluation extends neverlang.runtime.Module {
  public RightShiftEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.rshift.RightShiftSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
