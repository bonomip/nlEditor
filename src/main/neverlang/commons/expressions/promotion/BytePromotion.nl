module neverlang.commons.expressions.promotion.BytePromotion {
    imports {
        java.util.function.Supplier;
    }
    reference syntax from neverlang.commons.expressions.BinaryOperationAbstractSyntax

    role(type-promotion) {
        when(% $operation[1].type.equals(java.lang.Byte.class) && $operation[2].type.equals(java.lang.Short.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[1].expr;
            Supplier<java.lang.Short> newExpr = () -> new java.lang.Short(oldExpr.get().byteValue());
            $operation[1].type = java.lang.Short.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Byte.class) && $operation[1].type.equals(java.lang.Short.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[2].expr;
            Supplier<java.lang.Short> newExpr = () -> new java.lang.Short(oldExpr.get().byteValue());
            $operation[2].type = java.lang.Short.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[1].type.equals(java.lang.Byte.class) && $operation[2].type.equals(java.lang.Integer.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[1].expr;
            Supplier<java.lang.Integer> newExpr = () -> new java.lang.Integer(oldExpr.get().byteValue());
            $operation[1].type = java.lang.Integer.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Byte.class) && $operation[1].type.equals(java.lang.Integer.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[2].expr;
            Supplier<java.lang.Integer> newExpr = () -> new java.lang.Integer(oldExpr.get().byteValue());
            $operation[2].type = java.lang.Integer.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[1].type.equals(java.lang.Byte.class) && $operation[2].type.equals(java.lang.Long.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[1].expr;
            Supplier<java.lang.Long> newExpr = () -> new java.lang.Long(oldExpr.get().byteValue());
            $operation[1].type = java.lang.Long.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Byte.class) && $operation[1].type.equals(java.lang.Long.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[2].expr;
            Supplier<java.lang.Long> newExpr = () -> new java.lang.Long(oldExpr.get().byteValue());
            $operation[2].type = java.lang.Long.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[1].type.equals(java.lang.Byte.class) && $operation[2].type.equals(java.lang.Float.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[1].expr;
            Supplier<java.lang.Float> newExpr = () -> new java.lang.Float(oldExpr.get().byteValue());
            $operation[1].type = java.lang.Float.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Byte.class) && $operation[1].type.equals(java.lang.Float.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[2].expr;
            Supplier<java.lang.Float> newExpr = () -> new java.lang.Float(oldExpr.get().byteValue());
            $operation[2].type = java.lang.Float.class;
            $operation[2].expr = newExpr;
        }.

        when(% $operation[1].type.equals(java.lang.Byte.class) && $operation[2].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[1].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().byteValue());
            $operation[1].type = java.lang.Double.class;
            $operation[1].expr = newExpr;
        }.

        when(% $operation[2].type.equals(java.lang.Byte.class) && $operation[1].type.equals(java.lang.Double.class) %)
        operation: .{
            Supplier<java.lang.Byte> oldExpr = $operation[2].expr;
            Supplier<java.lang.Double> newExpr = () -> new java.lang.Double(oldExpr.get().byteValue());
            $operation[2].type = java.lang.Double.class;
            $operation[2].expr = newExpr;
        }.
    }
}
