package neverlang.commons.expressions.ternary;
import neverlang.runtime.*;
public class TernaryAlternativesSlice extends Slice {
  public TernaryAlternativesSlice() {
    importSyntax("neverlang.commons.expressions.ternary.TernaryAlternatives");
        imports("neverlang.commons.expressions.ternary.TernaryAlternatives", 
         role("terminal_evaluation"), 
         role("expression_initialization"));
    imports("neverlang.commons.expressions.promotion.BytePromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.CharPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.ShortPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.IntegerPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.LongPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.FloatPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.promotion.StringPromotion", 
         role("type_promotion"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
