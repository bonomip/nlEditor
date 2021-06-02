package neverlang.commons.expressions.rel.lteq;
import neverlang.runtime.*;
public class LessEqualEvaluation extends neverlang.runtime.Module {
  public LessEqualEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.lteq.LessEqualSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
