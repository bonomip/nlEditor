module neverlang.commons.expressions.bitwise.or.BitwiseOrSyntax {
    reference syntax {
        provides {
            BitwiseOrExpression: expressions, bitwise, or;
        }
        requires {
            AbstractBitOrOperand;
        }

        or:
            BitwiseOrExpression <-- BitwiseOrExpression "|" AbstractBitwiseOrOperand;

        categories :
            Operator = { "|" };
    }

    role(terminal-evaluation) {
        or: .{
            $or.operator="|";
        }.
    }
}
