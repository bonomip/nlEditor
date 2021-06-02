package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalGreaterEqualSlice extends Slice {
  public UniversalGreaterEqualSlice() {
    importSyntax("neverlang.commons.expressions.rel.gteq.GreaterEqualSyntax");
        imports("neverlang.commons.expressions.rel.universal.UniversalGreaterEqual", 
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
