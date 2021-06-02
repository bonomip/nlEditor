package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalLessEqual extends neverlang.runtime.Module {
  public UniversalLessEqual() {
    syntaxFrom("neverlang.commons.expressions.rel.lteq.LessEqualSyntax");
    declareRole("expression_initialization", 0);
declareRole("translate", 0);

    
  }

}
