module neverlang.commons.expressions.div.DivisionEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.div.DivisionSyntax

    role (expression-initialization) {
        when (% $division[1].type.equals(java.lang.Character.class) && $division[2].type.equals(java.lang.Character.class) %)
        division: .{
            Supplier<java.lang.Character> leftExpr = $division[1].expr;
            Supplier<java.lang.Character> rightExpr = $division[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Integer.class;
            $division.expr = expr;
        }.

        when (% $division[1].type.equals(java.lang.Short.class) && $division[2].type.equals(java.lang.Short.class) %)
        division: .{
            Supplier<java.lang.Short> leftExpr = $division[1].expr;
            Supplier<java.lang.Short> rightExpr = $division[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Integer.class;
            $division.expr = expr;
        }.

        when (% $division[1].type.equals(java.lang.Integer.class) && $division[2].type.equals(java.lang.Integer.class) %)
        division: .{
            Supplier<java.lang.Integer> leftExpr = $division[1].expr;
            Supplier<java.lang.Integer> rightExpr = $division[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Integer.class;
            $division.expr = expr;
        }.

        when (% $division[1].type.equals(java.lang.Long.class) && $division[2].type.equals(java.lang.Long.class) %)
        division: .{
            Supplier<java.lang.Long> leftExpr = $division[1].expr;
            Supplier<java.lang.Long> rightExpr = $division[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Long.class;
            $division.expr = expr;
        }.

        when (% $division[1].type.equals(java.lang.Float.class) && $division[2].type.equals(java.lang.Float.class) %)
        division: .{
            Supplier<java.lang.Float> leftExpr = $division[1].expr;
            Supplier<java.lang.Float> rightExpr = $division[2].expr;

            Supplier<java.lang.Float> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Float.class;
            $division.expr = expr;
        }.

        when (% $division[1].type.equals(java.lang.Double.class) && $division[2].type.equals(java.lang.Double.class) %)
        division: .{
            Supplier<java.lang.Double> leftExpr = $division[1].expr;
            Supplier<java.lang.Double> rightExpr = $division[2].expr;

            Supplier<java.lang.Double> expr = () -> leftExpr.get() / rightExpr.get();
            $division[0].type = java.lang.Double.class;
            $division.expr = expr;
        }.

        division: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "/", $division[1].type, $division[2].type);
            $$ErrorReport.add(error);
            $division.type = UndefinedExpressionType.class;
            $division.expr = null;
        }.
    }
}
