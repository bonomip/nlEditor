module neverlang.commons.expressions.rel.lteq.LessEqualEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.lteq.LessEqualSyntax

    role (expression-initialization) {
        when (% $less[1].type.equals(java.lang.Character.class) && $less[2].type.equals(java.lang.Character.class) %)
        less: .{
            Supplier<java.lang.Character> leftExpr = $less[1].expr;
            Supplier<java.lang.Character> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        when (% $less[1].type.equals(java.lang.Short.class) && $less[2].type.equals(java.lang.Short.class) %)
        less: .{
            Supplier<java.lang.Short> leftExpr = $less[1].expr;
            Supplier<java.lang.Short> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        when (% $less[1].type.equals(java.lang.Integer.class) && $less[2].type.equals(java.lang.Integer.class) %)
        less: .{
            Supplier<java.lang.Integer> leftExpr = $less[1].expr;
            Supplier<java.lang.Integer> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        when (% $less[1].type.equals(java.lang.Long.class) && $less[2].type.equals(java.lang.Long.class) %)
        less: .{
            Supplier<java.lang.Long> leftExpr = $less[1].expr;
            Supplier<java.lang.Long> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        when (% $less[1].type.equals(java.lang.Float.class) && $less[2].type.equals(java.lang.Float.class) %)
        less: .{
            Supplier<java.lang.Float> leftExpr = $less[1].expr;
            Supplier<java.lang.Float> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        when (% $less[1].type.equals(java.lang.Double.class) && $less[2].type.equals(java.lang.Double.class) %)
        less: .{
            Supplier<java.lang.Double> leftExpr = $less[1].expr;
            Supplier<java.lang.Double> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() <= rightExpr.get();
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.

        less: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "<=", $less[1].type, $less[2].type);
            $$ErrorReport.add(error);
            $less.type = UndefinedExpressionType.class;
            $less.expr = null;
        }.
    }
}
