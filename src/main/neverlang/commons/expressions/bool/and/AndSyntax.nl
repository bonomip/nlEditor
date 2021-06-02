module neverlang.commons.expressions.bool.and.AndSyntax {
    reference syntax {
        provides {
            AndExpression: expressions, boolean, and, infix;
        }
        requires {
            AbstractAndOperand;
        }

        and:
            AndExpression <-- AndExpression "&&" AbstractAndOperand;

        categories :
            Operator = { "&&" };
    }

    role(terminal-evaluation) {
        and: .{
            $and.operator="&&";
        }.
    }
}
