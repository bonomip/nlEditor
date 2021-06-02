module neverlang.commons.expressions.bitwise.xor.BitwiseXorEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bitwise.xor.BitwiseXorSyntax

    role (expression-initialization) {
        when (% $xor[1].type.equals(java.lang.Character.class) && $xor[2].type.equals(java.lang.Character.class) %)
        xor: .{
            Supplier<java.lang.Character> leftExpr = $xor[1].expr;
            Supplier<java.lang.Character> rightExpr = $xor[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() ^ rightExpr.get();
            $xor[0].type = java.lang.Integer.class;
            $xor.expr = expr;
        }.

        when (% $xor[1].type.equals(java.lang.Short.class) && $xor[2].type.equals(java.lang.Short.class) %)
        xor: .{
            Supplier<java.lang.Short> leftExpr = $xor[1].expr;
            Supplier<java.lang.Short> rightExpr = $xor[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() ^ rightExpr.get();
            $xor[0].type = java.lang.Integer.class;
            $xor.expr = expr;
        }.

        when (% $xor[1].type.equals(java.lang.Integer.class) && $xor[2].type.equals(java.lang.Integer.class) %)
        xor: .{
            Supplier<java.lang.Integer> leftExpr = $xor[1].expr;
            Supplier<java.lang.Integer> rightExpr = $xor[2].expr;

            Supplier<java.lang.Integer> expr = () -> leftExpr.get() ^ rightExpr.get();
            $xor[0].type = java.lang.Integer.class;
            $xor.expr = expr;
        }.

        when (% $xor[1].type.equals(java.lang.Long.class) && $xor[2].type.equals(java.lang.Long.class) %)
        xor: .{
            Supplier<java.lang.Long> leftExpr = $xor[1].expr;
            Supplier<java.lang.Long> rightExpr = $xor[2].expr;

            Supplier<java.lang.Long> expr = () -> leftExpr.get() ^ rightExpr.get();
            $xor[0].type = java.lang.Long.class;
            $xor.expr = expr;
        }.

        xor: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "^", $xor[1].type, $xor[2].type);
            $$ErrorReport.add(error);
            $xor.type = UndefinedExpressionType.class;
            $xor.expr = null;
        }.
    }
}
