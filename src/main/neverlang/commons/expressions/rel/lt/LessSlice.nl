slice neverlang.commons.expressions.rel.lt.LessSlice {
    concrete syntax from neverlang.commons.expressions.rel.lt.LessSyntax
    module neverlang.commons.expressions.rel.lt.LessEvaluation with role expression-initialization
    module neverlang.commons.expressions.promotion.BytePromotion with role type-promotion
    module neverlang.commons.expressions.promotion.CharPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.ShortPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.IntegerPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.LongPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.FloatPromotion with role type-promotion
    module neverlang.commons.expressions.promotion.StringPromotion with role type-promotion

    module neverlang.commons.expressions.rel.lt.LessSyntax with role terminal-evaluation
    module neverlang.commons.expressions.BinaryOperationAbstractSyntax with role translate
}
