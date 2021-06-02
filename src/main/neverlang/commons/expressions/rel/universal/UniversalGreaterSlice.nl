slice neverlang.commons.expressions.rel.universal.UniversalGreaterSlice {
    concrete syntax from neverlang.commons.expressions.rel.gt.GreaterSyntax
    module neverlang.commons.expressions.rel.universal.UniversalGreater with role expression-initialization translate
    module neverlang.commons.expressions.promotion.BytePromotion with role type-promotion
    module neverlang.commons.expressions.promotion.CharPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.ShortPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.IntegerPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.LongPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.FloatPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.StringPromotion with role type-promotion
}
