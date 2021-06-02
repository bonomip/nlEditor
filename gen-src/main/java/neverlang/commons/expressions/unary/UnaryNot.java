package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryNot extends neverlang.runtime.Module {
  public UnaryNot() {
    declareSyntax(); //null
    declareRole("terminal_evaluation", 0);
declareRole("expression_initialization", 0, 0);

    requireEndemicSlices("ErrorReport");
  }

}
