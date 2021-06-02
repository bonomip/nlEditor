module neverlang.commons.expressions.rem.RemainderEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rem.RemainderSyntax

    role (expression-initialization) {
        when (% $remainder[1].type.equals(java.lang.Character.class) && $remainder[2].type.equals(java.lang.Character.class) %)
        remainder: .{
            Supplier<java.lang.Character> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Character> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Integer.class;
            $remainder.expr = expr;
        }.

        when (% $remainder[1].type.equals(java.lang.Short.class) && $remainder[2].type.equals(java.lang.Short.class) %)
        remainder: .{
            Supplier<java.lang.Short> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Short> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Integer.class;
            $remainder.expr = expr;
        }.

        when (% $remainder[1].type.equals(java.lang.Integer.class) && $remainder[2].type.equals(java.lang.Integer.class) %)
        remainder: .{
            Supplier<java.lang.Integer> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Integer> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Integer.class;
            $remainder.expr = expr;
        }.

        when (% $remainder[1].type.equals(java.lang.Long.class) && $remainder[2].type.equals(java.lang.Long.class) %)
        remainder: .{
            Supplier<java.lang.Long> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Long> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Long.class;
            $remainder.expr = expr;
        }.

        when (% $remainder[1].type.equals(java.lang.Float.class) && $remainder[2].type.equals(java.lang.Float.class) %)
        remainder: .{
            Supplier<java.lang.Float> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Float> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Float> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Float.class;
            $remainder.expr = expr;
        }.

        when (% $remainder[1].type.equals(java.lang.Double.class) && $remainder[2].type.equals(java.lang.Double.class) %)
        remainder: .{
            Supplier<java.lang.Double> leftExpr = $remainder[1].expr;
            Supplier<java.lang.Double> rightExpr = $remainder[2].expr;

            Supplier<java.lang.Double> expr = () -> leftExpr.get() % rightExpr.get();
            $remainder[0].type = java.lang.Double.class;
            $remainder.expr = expr;
        }.

        remainder: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "%", $remainder[1].type, $remainder[2].type);
            $$ErrorReport.add(error);
            $remainder.type = UndefinedExpressionType.class;
            $remainder.expr = null;
        }.
    }
}
