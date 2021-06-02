package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class IntegerPromotion extends neverlang.runtime.Module {
  public IntegerPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0, 0, 0, 0, 0);

    
  }

}
