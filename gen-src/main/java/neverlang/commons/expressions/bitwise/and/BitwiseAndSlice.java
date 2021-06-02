package neverlang.commons.expressions.bitwise.and;
import neverlang.runtime.*;
public class BitwiseAndSlice extends Slice {
  public BitwiseAndSlice() {
    importSyntax("neverlang.commons.expressions.bitwise.and.BitwiseAndSyntax");
        imports("neverlang.commons.expressions.bitwise.and.BitwiseAndEvaluation", 
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
    imports("neverlang.commons.expressions.bitwise.and.BitwiseAndSyntax", 
         role("terminal_evaluation"));
    imports("neverlang.commons.expressions.BinaryOperationAbstractSyntax", 
         role("translate"));

  }
}
