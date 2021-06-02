package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class StringPromotion extends neverlang.runtime.Module {
  public StringPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0);

    
  }

}
