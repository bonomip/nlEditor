package neverlang.commons.expressions.rem;
import neverlang.runtime.*;
public class RemainderEvaluation extends neverlang.runtime.Module {
  public RemainderEvaluation() {
    syntaxFrom("neverlang.commons.expressions.rem.RemainderSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
