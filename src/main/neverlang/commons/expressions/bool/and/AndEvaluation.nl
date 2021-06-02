module neverlang.commons.expressions.bool.and.AndEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.bool.and.AndSyntax

    role (expression-initialization) {
        when (% $and[1].type.equals(java.lang.Boolean.class) && $and[2].type.equals(java.lang.Boolean.class) %)
        and: .{
            Supplier<java.lang.Boolean> leftExpr = $and[1].expr;
            Supplier<java.lang.Boolean> rightExpr = $and[2].expr;

            Supplier<java.lang.Boolean> expr = () -> leftExpr.get() && rightExpr.get();
            $and[0].type = java.lang.Boolean.class;
            $and.expr = expr;
        }.

        and: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "&&", $and[1].type, $and[2].type);
            $$ErrorReport.add(error);
            $and.type = UndefinedExpressionType.class;
            $and.expr = null;
        }.
    }
}
