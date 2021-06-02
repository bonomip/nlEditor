package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class ShortPromotion extends neverlang.runtime.Module {
  public ShortPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0, 0, 0, 0, 0, 0, 0);

    
  }

}
