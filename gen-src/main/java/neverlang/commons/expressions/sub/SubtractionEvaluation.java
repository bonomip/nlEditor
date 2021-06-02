package neverlang.commons.expressions.sub;
import neverlang.runtime.*;
public class SubtractionEvaluation extends neverlang.runtime.Module {
  public SubtractionEvaluation() {
    syntaxFrom("neverlang.commons.expressions.sub.SubtractionSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
