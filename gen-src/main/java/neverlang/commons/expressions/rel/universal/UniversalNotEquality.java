package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalNotEquality extends neverlang.runtime.Module {
  public UniversalNotEquality() {
    syntaxFrom("neverlang.commons.expressions.rel.neq.NotEqualitySyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
