package neverlang.commons.expressions.bitwise.lshift;
import neverlang.runtime.*;
public class LeftShiftEvaluation extends neverlang.runtime.Module {
  public LeftShiftEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.lshift.LeftShiftSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
