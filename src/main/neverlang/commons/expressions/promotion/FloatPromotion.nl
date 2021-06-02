module neverlang.commons.expressions.promotion.FloatPromotion {
    imports {
        java.util.function.Supplier;
    }
    reference syntax from neverlang.commons.expressions.BinaryOperationAbstractSyntax

    role(type-promotion) {
        when(% $operation[1].type.equals(java.lang.Float.class) && $operation[2].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Float> oldExpr = $operation[1].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().floatValue());
            $operation[1].type = java.lang.Double.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Float.class) && $operation[1].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Float> oldExpr = $operation[2].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().floatValue());
            $operation[2].type = java.lang.Double.class;
            $operation[2].expr = newExpr;
        }.
    }
}
