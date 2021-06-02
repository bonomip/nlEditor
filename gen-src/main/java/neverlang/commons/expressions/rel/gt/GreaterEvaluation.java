package neverlang.commons.expressions.rel.gt;
import neverlang.runtime.*;
public class GreaterEvaluation extends neverlang.runtime.Module {
  public GreaterEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rel.gt.GreaterSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
