package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalGreaterSlice extends Slice {
  public UniversalGreaterSlice() {
    importSyntax("neverlang.commons.expressions.rel.gt.GreaterSyntax");
        imports("neverlang.commons.expressions.rel.universal.UniversalGreater", 
         role("expression_initialization"), 
         role("translate"));
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

  }
}
