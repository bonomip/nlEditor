package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalEquality extends neverlang.runtime.Module {
  public UniversalEquality() {
    syntaxFrom("neverlang.commons.expressions.rel.eq.EqualitySyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
