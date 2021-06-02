package neverlang.commons.expressions.bitwise.or;
import neverlang.runtime.*;
public class BitwiseOrEvaluation extends neverlang.runtime.Module {
  public BitwiseOrEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.or.BitwiseOrSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
