package neverlang.commons.expressions.rel.universal;
import neverlang.runtime.*;
public class UniversalNotEqualitySlice extends Slice {
  public UniversalNotEqualitySlice() {
    importSyntax("neverlang.commons.expressions.rel.neq.NotEqualitySyntax");
        imports("neverlang.commons.expressions.rel.universal.UniversalNotEquality", 
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
