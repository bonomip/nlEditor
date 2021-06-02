module neverlang.commons.expressions.mul.MultiplicationSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, mul, infix;
        }
        requires {
            AbstractMulOperand;
        }

        multiplication:
            MulExpression <-- MulExpression "*" AbstractMulOperand;

        categories :
            Operator = { "*" };
    }

    role(terminal-evaluation) {
        multiplication: .{
            $multiplication.operator="*";
        }.
    }
}
