package neverlang.commons.expressions.bool.and;
import neverlang.runtime.*;
public class AndEvaluation extends neverlang.runtime.Module {
  public AndEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bool.and.AndSyntax");
    declareRole("expression_initialization", 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
