module neverlang.commons.expressions.bool.or.OrEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bool.or.OrSyntax

    role (expression-initialization) {
        when (% $or[1].type.equals(java.lang.Boolean.class) && $or[2].type.equals(java.lang.Boolean.class) %)
        or: .{
            Supplier<java.lang.Boolean> leftExpr = $or[1].expr;
            Supplier<java.lang.Boolean> rightExpr = $or[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() || rightExpr.get();
            $or[0].type = java.lang.Boolean.class;
            $or.expr = expr;
        }.

        or: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "||", $or[1].type, $or[2].type);
            $$ErrorReport.add(error);
            $or.type = UndefinedExpressionType.class;
            $or.expr = null;
        }.
    }
}
