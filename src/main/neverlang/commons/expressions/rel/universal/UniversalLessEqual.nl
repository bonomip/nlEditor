module neverlang.commons.expressions.rel.universal.UniversalLessEqual {
    imports {
        java.util.function.Supplier;
        neverlang.commons.expressions.errors.*;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax from neverlang.commons.expressions.rel.lteq.LessEqualSyntax

    role(translate) {
       less: <template> .{Boolean.valueOf( ({{$less[1].Text}}).compareTo({{$less[2].Text}}) <= 0 )}.
    }

    role (expression-initialization) {
       less: .{
            Supplier<java.lang.Comparable> leftExpr = $less[1].expr;
            Supplier<java.lang.Comparable> rightExpr = $less[2].expr;

            Supplier<java.lang.Boolean> expr = () -> ((Comparable)leftExpr.get()).compareTo(rightExpr.get()) <= 0;
            $less[0].type = java.lang.Boolean.class;
            $less.expr = expr;
        }.
    }
}
