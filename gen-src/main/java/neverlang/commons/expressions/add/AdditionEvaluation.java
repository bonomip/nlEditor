package neverlang.commons.expressions.add;
import neverlang.runtime.*;
public class AdditionEvaluation extends neverlang.runtime.Module {
  public AdditionEvaluation() {
    syntaxFrom("neverlang.commons.expressions.add.AdditionSyntax");
    declareRole("expression_initialization", 3, 3, 3, 3, 3, 3, 3, 3);

    requireEndemicSlices("ErrorReport");
  }

}
