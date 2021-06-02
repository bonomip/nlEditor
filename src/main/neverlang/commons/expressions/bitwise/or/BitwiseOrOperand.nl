module neverlang.commons.expressions.bitwise.or.BitwiseOrOperand {
    reference syntax {
        provides {
            BitwiseOrExpression: expressions, bitwise, or;
        }
        requires {
            AbstractBitwiseOrOperand;
        }
        BitwiseOrExpression <-- AbstractBitwiseOrOperand;
    }

}
