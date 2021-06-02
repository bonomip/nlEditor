module neverlang.commons.expressions.add.AdditionEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.add.AdditionSyntax

    role (expression-initialization) {
        when (% $addition[1].type.equals(java.lang.Character.class) && $addition[2].type.equals(java.lang.Character.class) %)
        addition: .{
            Supplier<java.lang.Character> leftExpr = $addition[1].expr;
            Supplier<java.lang.Character> rightExpr = $addition[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Integer.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.Short.class) && $addition[2].type.equals(java.lang.Short.class) %)
        addition: .{
            Supplier<java.lang.Short> leftExpr = $addition[1].expr;
            Supplier<java.lang.Short> rightExpr = $addition[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Integer.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.Integer.class) && $addition[2].type.equals(java.lang.Integer.class) %)
        addition: .{
            Supplier<java.lang.Integer> leftExpr = $addition[1].expr;
            Supplier<java.lang.Integer> rightExpr = $addition[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Integer.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.Long.class) && $addition[2].type.equals(java.lang.Long.class) %)
        addition: .{
            Supplier<java.lang.Long> leftExpr = $addition[1].expr;
            Supplier<java.lang.Long> rightExpr = $addition[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Long.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.Float.class) && $addition[2].type.equals(java.lang.Float.class) %)
        addition: .{
            Supplier<java.lang.Float> leftExpr = $addition[1].expr;
            Supplier<java.lang.Float> rightExpr = $addition[2].expr;

            Supplier<java.lang.Float> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Float.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.Double.class) && $addition[2].type.equals(java.lang.Double.class) %)
        addition: .{
            Supplier<java.lang.Double> leftExpr = $addition[1].expr;
            Supplier<java.lang.Double> rightExpr = $addition[2].expr;

            Supplier<java.lang.Double> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.Double.class;
            $addition.expr = expr;
        }.

        when (% $addition[1].type.equals(java.lang.String.class) && $addition[2].type.equals(java.lang.String.class) %)
        addition: .{
            Supplier<java.lang.String> leftExpr = $addition[1].expr;
            Supplier<java.lang.String> rightExpr = $addition[2].expr;

            Supplier<java.lang.String> expr = () -> leftExpr.get() + rightExpr.get();
            $addition[0].type = java.lang.String.class;
            $addition.expr = expr;
        }.

        addition: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "+", $addition[1].type, $addition[2].type);
            $$ErrorReport.add(error);
            $addition.type = UndefinedExpressionType.class;
            $addition.expr = null;
        }.
    }
}
