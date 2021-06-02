module neverlang.commons.expressions.mul.PostfixMultiplicationSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, mul, postfix;
        }
        requires {
            AbstractMulOperand;
        }

        multiplication:
            MulExpression <-- MulExpression AbstractMulOperand "*";

        categories :
            Operator = { "*" };
    }
}
