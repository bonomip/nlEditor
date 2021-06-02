package neverlang.commons.expressions.rel.neq;
import neverlang.runtime.*;
public class NotEqualityEvaluation extends neverlang.runtime.Module {
  public NotEqualityEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.neq.NotEqualitySyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
