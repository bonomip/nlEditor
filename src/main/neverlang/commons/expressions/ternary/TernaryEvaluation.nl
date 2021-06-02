module neverlang.commons.expressions.ternary.TernaryEvaluation {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.ternary.TernarySyntax

    role (expression-initialization) {
        when (% $ternary[1].type.equals(java.lang.Boolean.class) %)
        ternary: .{
            Supplier<java.lang.Boolean> condition = $ternary[1].expr;
            Supplier<java.lang.Boolean> exprOptionTrue = $ternary[2].exprOptionTrue;
            Supplier<java.lang.Object> exprOptionFalse = $ternary[2].exprOptionFalse;
            Supplier<java.lang.Object> expr = () -> {
                if(condition.get()) {
                    return exprOptionTrue.get();
                } else {
                    return exprOptionFalse.get();
                }
            };
            $ternary[0].type = $ternary[2].type;
            $ternary.expr = expr;
        }.

        ternary: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "?", $ternary[1].type);
            $$ErrorReport.add(error);
            $ternary.type = UndefinedExpressionType.class;
            $ternary.expr = null;
        }.
    }
}
