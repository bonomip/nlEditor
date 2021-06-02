slice neverlang.commons.expressions.ternary.TernarySlice {
    concrete syntax from neverlang.commons.expressions.ternary.TernarySyntax
    module neverlang.commons.expressions.ternary.TernaryEvaluation with role expression-initialization

    module neverlang.commons.expressions.ternary.TernarySyntax with role terminal-evaluation
    module neverlang.commons.expressions.BinaryOperationAbstractSyntax with role translate
}
