module neverlang.commons.expressions.bitwise.and.BitwiseAndEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bitwise.and.BitwiseAndSyntax

    role (expression-initialization) {
        when (% $and[1].type.equals(java.lang.Character.class) && $and[2].type.equals(java.lang.Character.class) %)
        and: .{
            Supplier<java.lang.Character> leftExpr = $and[1].expr;
            Supplier<java.lang.Character> rightExpr = $and[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() & rightExpr.get();
            $and[0].type = java.lang.Integer.class;
            $and.expr = expr;
        }.

        when (% $and[1].type.equals(java.lang.Short.class) && $and[2].type.equals(java.lang.Short.class) %)
        and: .{
            Supplier<java.lang.Short> leftExpr = $and[1].expr;
            Supplier<java.lang.Short> rightExpr = $and[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() & rightExpr.get();
            $and[0].type = java.lang.Integer.class;
            $and.expr = expr;
        }.

        when (% $and[1].type.equals(java.lang.Integer.class) && $and[2].type.equals(java.lang.Integer.class) %)
        and: .{
            Supplier<java.lang.Integer> leftExpr = $and[1].expr;
            Supplier<java.lang.Integer> rightExpr = $and[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() & rightExpr.get();
            $and[0].type = java.lang.Integer.class;
            $and.expr = expr;
        }.

        when (% $and[1].type.equals(java.lang.Long.class) && $and[2].type.equals(java.lang.Long.class) %)
        and: .{
            Supplier<java.lang.Long> leftExpr = $and[1].expr;
            Supplier<java.lang.Long> rightExpr = $and[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() & rightExpr.get();
            $and[0].type = java.lang.Long.class;
            $and.expr = expr;
        }.

        and: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "&", $and[1].type, $and[2].type);
            $$ErrorReport.add(error);
            $and.type = UndefinedExpressionType.class;
            $and.expr = null;
        }.
    }
}
