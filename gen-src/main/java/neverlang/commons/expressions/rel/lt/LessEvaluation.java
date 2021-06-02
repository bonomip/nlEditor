package neverlang.commons.expressions.rel.lt;
import neverlang.runtime.*;
public class LessEvaluation extends neverlang.runtime.Module {
  public LessEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.lt.LessSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
