module neverlang.commons.expressions.sub.SubtractionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, sub, infix;
        }
        requires {
            AbstractAddOperand;
        }

        subtraction:
            AddExpression <-- AddExpression "-" AbstractAddOperand;

        categories :
            Operator = { "-" };
    }

    role(terminal-evaluation) {
        subtraction: .{
            $subtraction.operator="-";
        }.
    }
}
