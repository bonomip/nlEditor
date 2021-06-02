module neverlang.commons.expressions.unary.UnaryComplement {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary, bitwise, complement;
        }
        requires {
            AbstractUnaryOperand;
        }
        complement:
            UnaryExpression <-- "~" UnaryExpression;

        categories :
            Operator = { "~" };
    }

    role(terminal-evaluation) {
        complement: .{
            $complement.operator = "~";
        }.
    }

    role (expression-initialization) {
        when (% $complement[1].type.equals(java.lang.Character.class) %)
        complement: .{
            Supplier<java.lang.Character> oldExpr = $complement[1].expr;
            Supplier<java.lang.Integer> expr = () -> ~ oldExpr.get();
            $complement[0].type = java.lang.Integer.class;
            $complement.expr = expr;
        }.

        when (% $complement[1].type.equals(java.lang.Short.class) %)
        complement: .{
            Supplier<java.lang.Short> oldExpr = $complement[1].expr;
            Supplier<java.lang.Integer> expr = () -> ~ oldExpr.get();
            $complement[0].type = java.lang.Integer.class;
            $complement.expr = expr;
        }.

        when (% $complement[1].type.equals(java.lang.Integer.class) %)
        complement: .{
            Supplier<java.lang.Integer> oldExpr = $complement[1].expr;
            Supplier<java.lang.Integer> expr = () -> ~ oldExpr.get();
            $complement[0].type = java.lang.Integer.class;
            $complement.expr = expr;
        }.

        when (% $complement[1].type.equals(java.lang.Long.class) %)
        complement: .{
            Supplier<java.lang.Long> oldExpr = $complement[1].expr;
            Supplier<java.lang.Long> expr = () -> ~ oldExpr.get();
            $complement[0].type = java.lang.Long.class;
            $complement.expr = expr;
        }.

        complement: .{
            BadOperandTypesException error = new BadOperandTypesException(#0.row, #0.col, "~", $complement[1].type);
            $$ErrorReport.add(error);
            $complement.type = UndefinedExpressionType.class;
            $complement.expr = null;
        }.
    }
}
