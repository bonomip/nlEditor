module neverlang.commons.expressions.sub.SubtractionEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.sub.SubtractionSyntax

    role (expression-initialization) {
        when (% $subtraction[1].type.equals(java.lang.Character.class) && $subtraction[2].type.equals(java.lang.Character.class) %)
        subtraction: .{
            Supplier<java.lang.Character> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Character> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Integer.class;
            $subtraction.expr = expr;
        }.

        when (% $subtraction[1].type.equals(java.lang.Short.class) && $subtraction[2].type.equals(java.lang.Short.class) %)
        subtraction: .{
            Supplier<java.lang.Short> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Short> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Integer.class;
            $subtraction.expr = expr;
        }.

        when (% $subtraction[1].type.equals(java.lang.Integer.class) && $subtraction[2].type.equals(java.lang.Integer.class) %)
        subtraction: .{
            Supplier<java.lang.Integer> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Integer> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Integer.class;
            $subtraction.expr = expr;
        }.

        when (% $subtraction[1].type.equals(java.lang.Long.class) && $subtraction[2].type.equals(java.lang.Long.class) %)
        subtraction: .{
            Supplier<java.lang.Long> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Long> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Long.class;
            $subtraction.expr = expr;
        }.

        when (% $subtraction[1].type.equals(java.lang.Float.class) && $subtraction[2].type.equals(java.lang.Float.class) %)
        subtraction: .{
            Supplier<java.lang.Float> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Float> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Float> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Float.class;
            $subtraction.expr = expr;
        }.

        when (% $subtraction[1].type.equals(java.lang.Double.class) && $subtraction[2].type.equals(java.lang.Double.class) %)
        subtraction: .{
            Supplier<java.lang.Double> leftExpr = $subtraction[1].expr;
            Supplier<java.lang.Double> rightExpr = $subtraction[2].expr;

            Supplier<java.lang.Double> expr = () -> leftExpr.get() - rightExpr.get();
            $subtraction[0].type = java.lang.Double.class;
            $subtraction.expr = expr;
        }.

        subtraction: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "-", $subtraction[1].type, $subtraction[2].type);
            $$ErrorReport.add(error);
            $subtraction.type = UndefinedExpressionType.class;
            $subtraction.expr = null;
        }.
    }
}
