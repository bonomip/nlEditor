module neverlang.commons.expressions.bitwise.and.BitwiseAndOperand {
    reference syntax {
        provides {
            BitwiseAndExpression: expressions, bitwise, and;
        }
        requires {
            AbstractBitwiseAndOperand;
        }
        BitwiseAndExpression <-- AbstractBitwiseAndOperand;
    }

}
