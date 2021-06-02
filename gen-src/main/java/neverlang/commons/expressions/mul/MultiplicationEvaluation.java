package neverlang.commons.expressions.mul;
import neverlang.runtime.*;
public class MultiplicationEvaluation extends neverlang.runtime.Module {
  public MultiplicationEvaluation() {
    syntaxFrom("neverlang.commons.expressions.mul.MultiplicationSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
