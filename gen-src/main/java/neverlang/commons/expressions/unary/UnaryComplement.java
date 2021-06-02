package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryComplement extends neverlang.runtime.Module {
  public UnaryComplement() {
    declareSyntax(); //null
    declareRole("terminal_evaluation", 0);
declareRole("expression_initialization", 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
