module neverlang.commons.expressions.test.ExpressionUnit {
    imports{
        neverlang.commons.unit.CompilationUnitDescriptor;
        java.util.function.Supplier;
        neverlang.commons.errors.ErrorReport;
    }
    reference syntax {
        ExpressionUnit <-- AbstractExpression;
    }

    role(expression-initialization) {
        0 .{
            if($$ErrorReport.failed()) {
                System.err.println($$ErrorReport);
                $0.skipEvaluation = true;
            } else {
                $0.skipEvaluation = false;
            }
            $$ErrorReport.removeAll($$ErrorReport);
        }.
    }

    role(translate) {
        0 .{
            if($0.skipEvaluation) {
                $0.unit = null;
                return;
            }
            String src = $1.Text;
            src = String.format("public class OutputExpression { public static void main(String[] args) { System.out.println(%s); } }", src);
            $0.unit = new CompilationUnitDescriptor(src, "./OutputExpression.java");
        }.
    }


    role(evaluation) {
        0 .{
            if($0.skipEvaluation) return;
            Supplier<java.lang.Object> expr = $1.expr;
            Class<?> resultType = $1.type;
            System.out.println("==> " + expr.get() + " (" + resultType + ")");
        }.
    }
}