package neverlang.commons.expressions.unary;
import neverlang.runtime.*;
public class UnaryExpr extends neverlang.runtime.Module {
  public UnaryExpr() {
    declareSyntax(); //null
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
