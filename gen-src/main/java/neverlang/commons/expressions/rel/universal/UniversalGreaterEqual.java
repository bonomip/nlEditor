package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalGreaterEqual extends neverlang.runtime.Module {
  public UniversalGreaterEqual() {
    syntaxFrom("neverlang.commons.expressions.rel.gteq.GreaterEqualSyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
