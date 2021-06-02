module neverlang.commons.expressions.bool.or.OrSyntax {
    reference syntax {
        provides {
            OrExpression: expressions, boolean, or, infix;
        }
        requires {
            AbstractOrOperand;
        }

        or:
            OrExpression <-- OrExpression "||" AbstractOrOperand;

        categories :
            Operator = { "||" };
    }

    role(terminal-evaluation) {
        or: .{
            $or.operator="||";
        }.
    }
}
