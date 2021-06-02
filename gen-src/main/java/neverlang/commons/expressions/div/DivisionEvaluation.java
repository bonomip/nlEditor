package neverlang.commons.expressions.div;
import neverlang.runtime.*;
public class DivisionEvaluation extends neverlang.runtime.Module {
  public DivisionEvaluation() {
    syntaxFrom("neverlang.commons.expressions.div.DivisionSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
