slice neverlang.commons.expressions.unary.UnaryNotSlice {
    concrete syntax from neverlang.commons.expressions.unary.UnaryNot
    module neverlang.commons.expressions.unary.UnaryNot with role terminal-evaluation
    module neverlang.commons.expressions.unary.UnaryExpr with role translate expression-initialization
}
