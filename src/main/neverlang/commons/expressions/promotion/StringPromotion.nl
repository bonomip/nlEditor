module neverlang.commons.expressions.promotion.StringPromotion {
    imports {
        java.util.function.Supplier;
    }
    reference syntax from neverlang.commons.expressions.BinaryOperationAbstractSyntax

    role(type-promotion) {
        when(% $operation[1].type.equals(java.lang.String.class) && !($operation[2].type.equals(java.lang.String.class)) %)
        operation: .{
            Supplier<java.lang.Object> oldExpr = $operation[2].expr;
            Supplier<java.lang.String> newExpr = () -> oldExpr.get().toString();
            $operation[2].type = java.lang.String.class;
            $operation[2].expr = newExpr;
        }.

        when(% !($operation[1].type.equals(java.lang.String.class)) && $operation[2].type.equals(java.lang.String.class) %)
        operation: .{
            Supplier<java.lang.Object> oldExpr = $operation[1].expr;
            Supplier<java.lang.String> newExpr = () -> oldExpr.get().toString();
            $operation[1].type = java.lang.String.class;
            $operation[1].expr = newExpr;
        }.
    }
}
