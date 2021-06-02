module neverlang.commons.expressions.rem.PostfixRemainderSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, rem, postfix;
        }
        requires {
            AbstractMulOperand;
        }

        remainder:
            MulExpression <-- MulExpression AbstractMulOperand "%";

        categories :
            Operator = { "%" };
    }
}
