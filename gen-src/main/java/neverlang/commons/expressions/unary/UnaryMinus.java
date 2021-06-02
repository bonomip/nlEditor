package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryMinus extends neverlang.runtime.Module {
  public UnaryMinus() {
    declareSyntax(); //null
    declareRole("terminal_evaluation", 0);
declareRole("expression_initialization", 0, 0, 0, 0, 0, 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
