module neverlang.commons.expressions.rel.lteq.LessEqualSyntax {
    reference syntax {
        provides {
            RelExpression: expressions, relational, less;
        }
        requires {
            AbstractRelOperand;
        }

        less:
            RelExpression <-- RelExpression "<=" AbstractRelOperand;

        categories :
            Operator = { "<=" };
    }

    role(terminal-evaluation) {
        less: .{
            $less.operator="<=";
        }.
    }
}
