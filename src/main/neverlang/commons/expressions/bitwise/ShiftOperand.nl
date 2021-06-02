module neverlang.commons.expressions.bitwise.ShiftOperand {
    reference syntax {
        provides {
            ShiftExpression: expressions, bitwise, shift;
        }
        requires {
            AbstractShiftOperand;
        }
        ShiftExpression <-- AbstractShiftOperand;
    }
}
