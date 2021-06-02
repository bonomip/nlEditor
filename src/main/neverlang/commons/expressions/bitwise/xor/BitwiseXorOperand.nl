module neverlang.commons.expressions.bitwise.xor.BitwiseXorOperand {
    reference syntax {
        provides {
            BitwiseXorExpression: expressions, bitwise, xor;
        }
        requires {
            AbstractBitwiseXorOperand;
        }
        BitwiseXorExpression <-- AbstractBitwiseXorOperand;
    }

}
