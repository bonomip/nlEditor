package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalLess extends neverlang.runtime.Module {
  public UniversalLess() {
    syntaxFrom("neverlang.commons.expressions.rel.lt.LessSyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
