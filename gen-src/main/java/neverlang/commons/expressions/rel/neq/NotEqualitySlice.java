package neverlang.commons.expressions.rel.neq;
import neverlang.runtime.*;
public class NotEqualitySlice extends Slice {
  public NotEqualitySlice() {
    importSyntax("neverlang.commons.expressions.rel.neq.NotEqualitySyntax");
        imports("neverlang.commons.expressions.rel.neq.NotEqualityEvaluation", 
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
    imports("neverlang.commons.expressions.rel.neq.NotEqualitySyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
