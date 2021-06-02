package neverlang.commons.expressions.bitwise.xor;
import neverlang.runtime.*;
public class BitwiseXorEvaluation extends neverlang.runtime.Module {
  public BitwiseXorEvaluation() {
    syntaxFrom("neverlang.commons.expressions.bitwise.xor.BitwiseXorSyntax");
    declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
