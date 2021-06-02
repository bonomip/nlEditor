package neverlang.commons.expressions.ternary;
import neverlang.runtime.*;
public class TernaryEvaluation extends neverlang.runtime.Module {
  public TernaryEvaluation() {
    syntaxFrom("neverlang.commons.expressions.ternary.TernarySyntax");
    declareRole("expression_initialization", 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
