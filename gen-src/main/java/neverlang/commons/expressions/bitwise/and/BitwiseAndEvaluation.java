package neverlang.commons.expressions.bitwise.and;
import neverlang.runtime.*;
public class BitwiseAndEvaluation extends neverlang.runtime.Module {
  public BitwiseAndEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.and.BitwiseAndSyntax");
    declareRole("expression_initialization", 3, 3, 3, 3, 3);

    requireEndemicSlices("ErrorReport");
  }

}
