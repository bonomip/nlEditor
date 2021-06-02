module neverlang.commons.expressions.rel.gt.GreaterEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.gt.GreaterSyntax

    role (expression-initialization) {
        when (% $greater[1].type.equals(java.lang.Character.class) && $greater[2].type.equals(java.lang.Character.class) %)
        greater: .{
            Supplier<java.lang.Character> leftExpr = $greater[1].expr;
            Supplier<java.lang.Character> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        when (% $greater[1].type.equals(java.lang.Short.class) && $greater[2].type.equals(java.lang.Short.class) %)
        greater: .{
            Supplier<java.lang.Short> leftExpr = $greater[1].expr;
            Supplier<java.lang.Short> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        when (% $greater[1].type.equals(java.lang.Integer.class) && $greater[2].type.equals(java.lang.Integer.class) %)
        greater: .{
            Supplier<java.lang.Integer> leftExpr = $greater[1].expr;
            Supplier<java.lang.Integer> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        when (% $greater[1].type.equals(java.lang.Long.class) && $greater[2].type.equals(java.lang.Long.class) %)
        greater: .{
            Supplier<java.lang.Long> leftExpr = $greater[1].expr;
            Supplier<java.lang.Long> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        when (% $greater[1].type.equals(java.lang.Float.class) && $greater[2].type.equals(java.lang.Float.class) %)
        greater: .{
            Supplier<java.lang.Float> leftExpr = $greater[1].expr;
            Supplier<java.lang.Float> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        when (% $greater[1].type.equals(java.lang.Double.class) && $greater[2].type.equals(java.lang.Double.class) %)
        greater: .{
            Supplier<java.lang.Double> leftExpr = $greater[1].expr;
            Supplier<java.lang.Double> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() > rightExpr.get();
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.

        greater: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, ">", $greater[1].type, $greater[2].type);
            $$ErrorReport.add(error);
            $greater.type = UndefinedExpressionType.class;
            $greater.expr = null;
        }.
    }
}
