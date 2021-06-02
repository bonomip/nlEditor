module neverlang.commons.expressions.promotion.LongPromotion {
    imports {
        java.util.function.Supplier;
    }
    reference syntax from neverlang.commons.expressions.BinaryOperationAbstractSyntax

    role(type-promotion) {
        when(% $operation[1].type.equals(java.lang.Long.class) && $operation[2].type.equals(java.lang.Float.class) %)
        operation: .{
            Supplier<java.lang.Long> oldExpr = $operation[1].expr;
            Supplier<java.lang.Float> newExpr = () -> new java.lang.Float(oldExpr.get().longValue());
            $operation[1].type = java.lang.Float.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Long.class) && $operation[1].type.equals(java.lang.Float.class) %)
        operation: .{
            Supplier<java.lang.Long> oldExpr = $operation[2].expr;
            Supplier<java.lang.Float> newExpr = () -> new java.lang.Float(oldExpr.get().longValue());
            $operation[2].type = java.lang.Float.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[1].type.equals(java.lang.Long.class) && $operation[2].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Long> oldExpr = $operation[1].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().longValue());
            $operation[1].type = java.lang.Double.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Long.class) && $operation[1].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Long> oldExpr = $operation[2].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().longValue());
            $operation[2].type = java.lang.Double.class;
            $operation[2].expr = newExpr;
        }.
    }
}
