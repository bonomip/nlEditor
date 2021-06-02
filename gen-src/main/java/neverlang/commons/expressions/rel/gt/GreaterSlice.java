package neverlang.commons.expressions.rel.gt;
import neverlang.runtime.*;
public class GreaterSlice extends Slice {
  public GreaterSlice() {
    importSyntax("neverlang.commons.expressions.rel.gt.GreaterSyntax");
        imports("neverlang.commons.expressions.rel.gt.GreaterEvaluation", 
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
    imports("neverlang.commons.expressions.rel.gt.GreaterSyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
