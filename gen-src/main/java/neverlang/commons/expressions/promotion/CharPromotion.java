package neverlang.commons.expressions.promotion;
import neverlang.runtime.*;
public class CharPromotion extends neverlang.runtime.Module {
  public CharPromotion() {
    syntaxFrom("neverlang.commons.expressions.BinaryOperationAbstractSyntax");
    declareRole("type_promotion", 0, 0, 0, 0, 0, 0, 0, 0);

    
  }

}
