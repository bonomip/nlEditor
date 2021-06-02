module neverlang.commons.expressions.bitwise.xor.BitwiseXorSyntax {
    reference syntax {
        provides {
            BitwiseXorExpression: expressions, bitwise, xor;
        }
        requires {
            AbstractBitwiseXorOperand;
        }

        xor:
            BitwiseXorExpression <-- BitwiseXorExpression "^" AbstractBitwiseXorOperand;

        categories :
            Operator = { "^" };
    }

    role(terminal-evaluation) {
        xor: .{
            $xor.operator="^";
        }.
    }
}
