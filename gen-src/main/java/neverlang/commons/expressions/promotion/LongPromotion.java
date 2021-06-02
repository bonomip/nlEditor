package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class LongPromotion extends neverlang.runtime.Module {
  public LongPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0, 0, 0);

    
  }

}
