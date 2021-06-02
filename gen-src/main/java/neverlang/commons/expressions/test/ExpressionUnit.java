package neverlang.commons.expressions.test;
import neverlang.runtime.*;
public class ExpressionUnit extends neverlang.runtime.Module {
  public ExpressionUnit() {
    declareSyntax(); //null
    declareRole("evaluation", 0);
declareRole("expression_initialization", 0);
declareRole("translate", 0);

    requireEndemicSlices("ErrorReport");
  }

}
