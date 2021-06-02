module neverlang.commons.expressions.rem.RemainderSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, infix;
        }
        requires {
            AbstractMulOperand;
        }

        remainder:
            MulExpression <-- MulExpression "%" AbstractMulOperand;

        categories :
            Operator = { "%" };
    }

    role(terminal-evaluation) {
        remainder: .{
            $remainder.operator="%";
        }.
    }
}
