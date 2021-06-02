language neverlang.commons.expressions.test.ExpressionsLang {
    slices
        bundle(neverlang.commons.expressions.Expressions)
        bundle(neverlang.commons.types.Literals)

        //Unit
        neverlang.commons.expressions.test.ExpressionUnit
        neverlang.commons.unit.CompilationUnitTranslator

    endemic slices
        neverlang.commons.errors.ErrorReportEndemic

    roles syntax < terminal-evaluation : type-promotion :expression-initialization <+ evaluation < translate
    rename {
        ExpressionUnit --> CompilationUnit;
        AbstractExpression --> TernaryExpression;
        AbstractLiteral --> Literal;
        AbstractUnaryOperand --> Literal;
    }
}
