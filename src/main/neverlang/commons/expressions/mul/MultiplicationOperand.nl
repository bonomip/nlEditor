module neverlang.commons.expressions.mul.MultiplicationOperand {
    reference syntax {
        provides {
            MulExpression: expressions, math, mul, operand;
        }
        requires {
            AbstractMulOperand;
        }
        MulExpression <-- AbstractMulOperand;
    }

}
