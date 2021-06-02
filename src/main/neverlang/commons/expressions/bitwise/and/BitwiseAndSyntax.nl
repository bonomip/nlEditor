module neverlang.commons.expressions.bitwise.and.BitwiseAndSyntax {
    reference syntax {
        provides {
            BitwiseAndExpression: expressions, bitwise, and;
        }
        requires {
            AbstractBitAndOperand;
        }

        and:
            BitwiseAndExpression <-- BitwiseAndExpression "&" AbstractBitwiseAndOperand;
            BitwiseAndExpression <-- BitwiseAndExpression "&" AbstractBitwiseAndOperand;
            BitwiseAndExpression <-- BitwiseAndExpression "&" AbstractBitwiseAndOperand "&" AbstractBitwiseAndOperand;

        categories :
            Operator = { "&" };
    }

    role(terminal-evaluation) {
        and: .{
            $and.operator="&";
        }.
    }
}
