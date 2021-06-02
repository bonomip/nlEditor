package neverlang.commons.expressions.rel.lteq;
import neverlang.runtime.*;
public class LessEqualSlice extends Slice {
  public LessEqualSlice() {
    importSyntax("neverlang.commons.expressions.rel.lteq.LessEqualSyntax");
        imports("neverlang.commons.expressions.rel.lteq.LessEqualEvaluation", 
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
    imports("neverlang.commons.expressions.rel.lteq.LessEqualSyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
