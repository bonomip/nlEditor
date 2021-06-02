module neverlang.commons.expressions.rel.neq.NotEqualityEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.neq.NotEqualitySyntax

    role (expression-initialization) {
        when (% $equals[1].type.equals(java.lang.Character.class) && $equals[2].type.equals(java.lang.Character.class) %)
        equals: .{
            Supplier<java.lang.Character> leftExpr = $equals[1].expr;
            Supplier<java.lang.Character> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> ! (leftExpr.get().charValue() == rightExpr.get().charValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Short.class) && $equals[2].type.equals(java.lang.Short.class) %)
        equals: .{
            Supplier<java.lang.Short> leftExpr = $equals[1].expr;
            Supplier<java.lang.Short> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().shortValue() == rightExpr.get().shortValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Integer.class) && $equals[2].type.equals(java.lang.Integer.class) %)
        equals: .{
            Supplier<java.lang.Integer> leftExpr = $equals[1].expr;
            Supplier<java.lang.Integer> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().intValue() == rightExpr.get().intValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Long.class) && $equals[2].type.equals(java.lang.Long.class) %)
        equals: .{
            Supplier<java.lang.Long> leftExpr = $equals[1].expr;
            Supplier<java.lang.Long> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().longValue() == rightExpr.get().longValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Float.class) && $equals[2].type.equals(java.lang.Float.class) %)
        equals: .{
            Supplier<java.lang.Float> leftExpr = $equals[1].expr;
            Supplier<java.lang.Float> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().floatValue() == rightExpr.get().floatValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Double.class) && $equals[2].type.equals(java.lang.Double.class) %)
        equals: .{
            Supplier<java.lang.Double> leftExpr = $equals[1].expr;
            Supplier<java.lang.Double> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().doubleValue() == rightExpr.get().doubleValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        when (% $equals[1].type.equals(java.lang.Boolean.class) && $equals[2].type.equals(java.lang.Boolean.class) %)
        equals: .{
            Supplier<java.lang.Boolean> leftExpr = $equals[1].expr;
            Supplier<java.lang.Boolean> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> !(leftExpr.get().booleanValue() == rightExpr.get().booleanValue());
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.

        equals: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "!=", $equals[1].type, $equals[2].type);
            $$ErrorReport.add(error);
            $equals.type = UndefinedExpressionType.class;
            $equals.expr = null;
        }.
    }
}
