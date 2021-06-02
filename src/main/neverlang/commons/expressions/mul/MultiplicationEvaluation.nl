module neverlang.commons.expressions.mul.MultiplicationEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.mul.MultiplicationSyntax

    role (expression-initialization) {
        when (% $multiplication[1].type.equals(java.lang.Character.class) && $multiplication[2].type.equals(java.lang.Character.class) %)
        multiplication: .{
            Supplier<java.lang.Character> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Character> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Integer.class;
            $multiplication.expr = expr;
        }.

        when (% $multiplication[1].type.equals(java.lang.Short.class) && $multiplication[2].type.equals(java.lang.Short.class) %)
        multiplication: .{
            Supplier<java.lang.Short> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Short> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Integer.class;
            $multiplication.expr = expr;
        }.

        when (% $multiplication[1].type.equals(java.lang.Integer.class) && $multiplication[2].type.equals(java.lang.Integer.class) %)
        multiplication: .{
            Supplier<java.lang.Integer> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Integer> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Integer.class;
            $multiplication.expr = expr;
        }.

        when (% $multiplication[1].type.equals(java.lang.Long.class) && $multiplication[2].type.equals(java.lang.Long.class) %)
        multiplication: .{
            Supplier<java.lang.Long> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Long> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Long.class;
            $multiplication.expr = expr;
        }.

        when (% $multiplication[1].type.equals(java.lang.Float.class) && $multiplication[2].type.equals(java.lang.Float.class) %)
        multiplication: .{
            Supplier<java.lang.Float> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Float> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Float> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Float.class;
            $multiplication.expr = expr;
        }.

        when (% $multiplication[1].type.equals(java.lang.Double.class) && $multiplication[2].type.equals(java.lang.Double.class) %)
        multiplication: .{
            Supplier<java.lang.Double> leftExpr = $multiplication[1].expr;
            Supplier<java.lang.Double> rightExpr = $multiplication[2].expr;

            Supplier<java.lang.Double> expr = () -> leftExpr.get() * rightExpr.get();
            $multiplication[0].type = java.lang.Double.class;
            $multiplication.expr = expr;
        }.

        multiplication: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "*", $multiplication[1].type, $multiplication[2].type);
            $$ErrorReport.add(error);
            $multiplication.type = UndefinedExpressionType.class;
            $multiplication.expr = null;
        }.
    }
}
