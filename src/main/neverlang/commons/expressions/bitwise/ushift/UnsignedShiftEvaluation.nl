module neverlang.commons.expressions.bitwise.ushift.UnsignedShiftEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bitwise.ushift.UnsignedShiftSyntax

    role (expression-initialization) {
        when (% $shift[1].type.equals(java.lang.Character.class) && $shift[2].type.equals(java.lang.Character.class) %)
        shift: .{
            Supplier<java.lang.Character> leftExpr = $shift[1].expr;
            Supplier<java.lang.Character> rightExpr = $shift[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() >>> rightExpr.get();
            $shift[0].type = java.lang.Integer.class;
            $shift.expr = expr;
        }.

        when (% $shift[1].type.equals(java.lang.Short.class) && $shift[2].type.equals(java.lang.Short.class) %)
        shift: .{
            Supplier<java.lang.Short> leftExpr = $shift[1].expr;
            Supplier<java.lang.Short> rightExpr = $shift[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() >>> rightExpr.get();
            $shift[0].type = java.lang.Integer.class;
            $shift.expr = expr;
        }.

        when (% $shift[1].type.equals(java.lang.Integer.class) && $shift[2].type.equals(java.lang.Integer.class) %)
        shift: .{
            Supplier<java.lang.Integer> leftExpr = $shift[1].expr;
            Supplier<java.lang.Integer> rightExpr = $shift[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() >>> rightExpr.get();
            $shift[0].type = java.lang.Integer.class;
            $shift.expr = expr;
        }.

        when (% $shift[1].type.equals(java.lang.Long.class) && $shift[2].type.equals(java.lang.Long.class) %)
        shift: .{
            Supplier<java.lang.Long> leftExpr = $shift[1].expr;
            Supplier<java.lang.Long> rightExpr = $shift[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() >>> rightExpr.get();
            $shift[0].type = java.lang.Long.class;
            $shift.expr = expr;
        }.

        shift: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, ">>>", $shift[1].type, $shift[2].type);
            $$ErrorReport.add(error);
            $shift.type = UndefinedExpressionType.class;
            $shift.expr = null;
        }.
    }
}
