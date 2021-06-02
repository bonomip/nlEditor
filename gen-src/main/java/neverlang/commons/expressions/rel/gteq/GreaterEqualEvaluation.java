package neverlang.commons.expressions.rel.gteq;
import neverlang.runtime.*;
public class GreaterEqualEvaluation extends neverlang.runtime.Module {
  public GreaterEqualEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.gteq.GreaterEqualSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
