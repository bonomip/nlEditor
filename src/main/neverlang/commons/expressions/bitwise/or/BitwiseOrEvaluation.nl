module neverlang.commons.expressions.bitwise.or.BitwiseOrEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bitwise.or.BitwiseOrSyntax

    role (expression-initialization) {
        when (% $or[1].type.equals(java.lang.Character.class) && $or[2].type.equals(java.lang.Character.class) %)
        or: .{
            Supplier<java.lang.Character> leftExpr = $or[1].expr;
            Supplier<java.lang.Character> rightExpr = $or[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() | rightExpr.get();
            $or[0].type = java.lang.Integer.class;
            $or.expr = expr;
        }.

        when (% $or[1].type.equals(java.lang.Short.class) && $or[2].type.equals(java.lang.Short.class) %)
        or: .{
            Supplier<java.lang.Short> leftExpr = $or[1].expr;
            Supplier<java.lang.Short> rightExpr = $or[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() | rightExpr.get();
            $or[0].type = java.lang.Integer.class;
            $or.expr = expr;
        }.

        when (% $or[1].type.equals(java.lang.Integer.class) && $or[2].type.equals(java.lang.Integer.class) %)
        or: .{
            Supplier<java.lang.Integer> leftExpr = $or[1].expr;
            Supplier<java.lang.Integer> rightExpr = $or[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() | rightExpr.get();
            $or[0].type = java.lang.Integer.class;
            $or.expr = expr;
        }.

        when (% $or[1].type.equals(java.lang.Long.class) && $or[2].type.equals(java.lang.Long.class) %)
        or: .{
            Supplier<java.lang.Long> leftExpr = $or[1].expr;
            Supplier<java.lang.Long> rightExpr = $or[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() | rightExpr.get();
            $or[0].type = java.lang.Long.class;
            $or.expr = expr;
        }.

        or: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "|", $or[1].type, $or[2].type);
            $$ErrorReport.add(error);
            $or.type = UndefinedExpressionType.class;
            $or.expr = null;
        }.
    }
}
