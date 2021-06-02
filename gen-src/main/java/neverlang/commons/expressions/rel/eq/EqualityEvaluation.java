package neverlang.commons.expressions.rel.eq;
import neverlang.runtime.*;
public class EqualityEvaluation extends neverlang.runtime.Module {
  public EqualityEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.eq.EqualitySyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
