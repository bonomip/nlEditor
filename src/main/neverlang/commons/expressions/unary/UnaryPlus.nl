module neverlang.commons.expressions.unary.UnaryPlus {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary, math, plus;
        }
        requires {
            AbstractUnaryOperand;
        }
        plus:
            UnaryExpression <-- "+" UnaryExpression;

        categories :
            Operator = { "+" };
    }

    role(terminal-evaluation) {
        plus: .{
            $plus.operator = "+";
        }.
    }

    role (expression-initialization) {
        when (% $plus[1].type.equals(java.lang.Character.class) %)
        plus: .{
            Supplier<java.lang.Character> oldExpr = $plus[1].expr;
            Supplier<java.lang.Integer> expr = () -> + oldExpr.get();
            $plus[0].type = java.lang.Integer.class;
            $plus.expr = expr;
        }.

        when (% $plus[1].type.equals(java.lang.Short.class) %)
        plus: .{
            Supplier<java.lang.Short> oldExpr = $plus[1].expr;
            Supplier<java.lang.Integer> expr = () -> + oldExpr.get();
            $plus[0].type = java.lang.Integer.class;
            $plus.expr = expr;
        }.

        when (% $plus[1].type.equals(java.lang.Integer.class) %)
        plus: .{
            Supplier<java.lang.Integer> oldExpr = $plus[1].expr;
            $plus[0].type = java.lang.Integer.class;
            $plus.expr = oldExpr;
        }.

        when (% $plus[1].type.equals(java.lang.Long.class) %)
        plus: .{
            Supplier<java.lang.Long> oldExpr = $plus[1].expr;
            $plus[0].type = java.lang.Long.class;
            $plus.expr = oldExpr;
        }.

        when (% $plus[1].type.equals(java.lang.Float.class) %)
        plus: .{
            Supplier<java.lang.Float> oldExpr = $plus[1].expr;
            $plus[0].type = java.lang.Float.class;
            $plus.expr = oldExpr;
        }.

        when (% $plus[1].type.equals(java.lang.Double.class) %)
        plus: .{
            Supplier<java.lang.Double> oldExpr = $plus[1].expr;
            $plus[0].type = java.lang.Double.class;
            $plus.expr = oldExpr;
        }.

        plus: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "+", $plus[1].type);
            $$ErrorReport.add(error);
            $plus.type = UndefinedExpressionType.class;
            $plus.expr = null;
        }.
    }
}
