module neverlang.commons.expressions.rel.universal.UniversalGreaterEqual{
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.gteq.GreaterEqualSyntax

    role(translate) {
        greater: <template> .{Boolean.valueOf( ({{$greater[1].Text}}).compareTo({{$greater[2].Text}}) >= 0 )}.
    }

    role (expression-initialization) {
        greater: .{
            Supplier<java.lang.Comparable> leftExpr = $greater[1].expr;
            Supplier<java.lang.Comparable> rightExpr = $greater[2].expr;

            Supplier<java.lang.Boolean> expr = () -> ((Comparable)leftExpr.get()).compareTo(rightExpr.get()) >= 0;
            $greater[0].type = java.lang.Boolean.class;
            $greater.expr = expr;
        }.
    }
}
