package neverlang.commons.expressions.bool.or;
import neverlang.runtime.*;
public class OrEvaluation extends neverlang.runtime.Module {
  public OrEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bool.or.OrSyntax");
    declareRole("expression_initialization", 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
