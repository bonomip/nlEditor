module neverlang.commons.expressions.unary.UnaryNot {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary, boolean, not;
        }
        requires {
            AbstractUnaryOperand;
        }
        not:
            UnaryExpression <-- "!" UnaryExpression;

        categories :
            Operator = { "!" };
    }

    role(terminal-evaluation) {
        not: .{
            $not.operator = "!";
        }.
    }

    role (expression-initialization) {
        when (% $not[1].type.equals(java.lang.Boolean.class) %)
        not: .{
            Supplier<java.lang.Boolean> oldExpr = $not[1].expr;
            Supplier<java.lang.Boolean> expr = () -> ! oldExpr.get();
            $not.type = java.lang.Boolean.class;
            $not.expr = expr;
        }.

        not: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "+", $not[1].type);
            $$ErrorReport.add(error);
            $not.type = UndefinedExpressionType.class;
            $not.expr = null;
        }.
    }
}
