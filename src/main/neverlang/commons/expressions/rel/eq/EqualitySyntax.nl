module neverlang.commons.expressions.rel.eq.EqualitySyntax {
    reference syntax {
        provides {
            RelExpression: expressions, relational, equals;
        }
        requires {
            AbstractRelOperand;
        }

        equals:
            EqExpression <-- EqExpression "==" AbstractEqOperand;

        categories :
            Operator = { "==" };
    }

    role(terminal-evaluation) {
        equals: .{
            $equals.operator="==";
        }.
    }
}
