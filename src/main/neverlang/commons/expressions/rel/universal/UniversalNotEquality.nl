module neverlang.commons.expressions.rel.universal.UniversalNotEquality {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.neq.NotEqualitySyntax

    role(translate) {
        equals: <template> .{Boolean.valueOf( ({{$equals[1].Text}}).compareTo({{$equals[2].Text}}) != 0 )}.
    }

    role (expression-initialization) {
        equals: .{
            Supplier<java.lang.Comparable> leftExpr = $equals[1].expr;
            Supplier<java.lang.Comparable> rightExpr = $equals[2].expr;

            Supplier<java.lang.Boolean> expr = () -> ((Comparable)leftExpr.get()).compareTo(rightExpr.get()) != 0;
            $equals[0].type = java.lang.Boolean.class;
            $equals.expr = expr;
        }.
    }
}
