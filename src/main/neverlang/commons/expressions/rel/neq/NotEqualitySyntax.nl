module neverlang.commons.expressions.rel.neq.NotEqualitySyntax {
    reference syntax {
        provides {
            RelExpression: expressions, relational, equals;
        }
        requires {
            AbstractRelOperand;
        }

        equals:
            EqExpression <-- EqExpression "!=" AbstractEqOperand;

        categories :
            Operator = { "!=" };
    }

    role(terminal-evaluation) {
        equals: .{
            $equals.operator="!=";
        }.
    }
}
