module neverlang.commons.expressions.div.DivisionSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, div, infix;
        }
        requires {
            AbstractMulOperand;
        }

        division:
            MulExpression <-- MulExpression "/" AbstractMulOperand;

        categories :
            Operator = { "/" };
    }

    role(terminal-evaluation) {
        division: .{
            $division.operator="/";
        }.
    }
}
