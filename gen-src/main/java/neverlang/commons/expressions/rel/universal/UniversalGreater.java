package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalGreater extends neverlang.runtime.Module {
  public UniversalGreater() {
    syntaxFrom("neverlang.commons.expressions.rel.gt.GreaterSyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
