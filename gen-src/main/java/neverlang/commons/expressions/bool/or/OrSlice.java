package neverlang.commons.expressions.bool.or;
import neverlang.runtime.*;
public class OrSlice extends Slice {
  public OrSlice() {
    importSyntax("neverlang.commons.expressions.bool.or.OrSyntax");
        imports("neverlang.commons.expressions.bool.or.OrEvaluation", 
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
    imports("neverlang.commons.expressions.bool.or.OrSyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
