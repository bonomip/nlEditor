module neverlang.commons.expressions.unary.UnaryMinus {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary, math, minus;
        }
        requires {
            AbstractUnaryOperand;
        }
        minus:
            UnaryExpression <-- "-" UnaryExpression;

        categories :
            Operator = { "-" };
    }

    role(terminal-evaluation) {
        minus: .{
            $minus.operator = "-";
        }.
    }

    role (expression-initialization) {
        when (% $minus[1].type.equals(java.lang.Character.class) %)
        minus: .{
            Supplier<java.lang.Character> oldExpr = $minus[1].expr;
            Supplier<java.lang.Integer> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Integer.class;
            $minus.expr = expr;
        }.

        when (% $minus[1].type.equals(java.lang.Short.class) %)
        minus: .{
            Supplier<java.lang.Short> oldExpr = $minus[1].expr;
            Supplier<java.lang.Integer> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Integer.class;
            $minus.expr = expr;
        }.

        when (% $minus[1].type.equals(java.lang.Integer.class) %)
        minus: .{
            Supplier<java.lang.Integer> oldExpr = $minus[1].expr;
            Supplier<java.lang.Integer> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Integer.class;
            $minus.expr = expr;
        }.

        when (% $minus[1].type.equals(java.lang.Long.class) %)
        minus: .{
            Supplier<java.lang.Long> oldExpr = $minus[1].expr;
            Supplier<java.lang.Long> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Long.class;
            $minus.expr = expr;
        }.

        when (% $minus[1].type.equals(java.lang.Float.class) %)
        minus: .{
            Supplier<java.lang.Float> oldExpr = $minus[1].expr;
            Supplier<java.lang.Float> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Float.class;
            $minus.expr = expr;
        }.

        when (% $minus[1].type.equals(java.lang.Double.class) %)
        minus: .{
            Supplier<java.lang.Double> oldExpr = $minus[1].expr;
            Supplier<java.lang.Double> expr = () -> - oldExpr.get();
            $minus[0].type = java.lang.Double.class;
            $minus.expr = expr;
        }.

        minus: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "+", $minus[1].type);
            $$ErrorReport.add(error);
            $minus.type = UndefinedExpressionType.class;
            $minus.expr = null;
        }.
    }
}
