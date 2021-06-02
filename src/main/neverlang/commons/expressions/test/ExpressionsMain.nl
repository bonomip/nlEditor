module neverlang.commons.expressions.test.ExpressionsMain {
    imports {
        java.util.function.Supplier;
    }
    reference syntax {
        Program <-- AbstractExpression;
    }
    role(evaluation) {
        0 .{
            Supplier<java.lang.Object> expr = $1.expr;
            Class<?> resultType = $1.type;
            System.out.println("==> " + expr.get() + " (" + resultType + ")");
        }.
    }
}
