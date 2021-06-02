module neverlang.commons.expressions.rel.gt.GreaterSyntax {
    reference syntax {
        provides {
            RelExpression: expressions, relational, greater;
        }
        requires {
            AbstractRelOperand;
        }

        greater:
            RelExpression <-- RelExpression ">" AbstractRelOperand;

        categories :
            Operator = { ">" };
    }

    role(terminal-evaluation) {
        greater: .{
            $greater.operator=">";
        }.
    }
}
