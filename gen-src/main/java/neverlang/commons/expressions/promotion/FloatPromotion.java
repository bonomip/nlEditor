package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class FloatPromotion extends neverlang.runtime.Module {
  public FloatPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0);

    
  }

}
