module neverlang.commons.expressions.rem.PrefixRemainderSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, rem, prefix;
        }
        requires {
            AbstractMulOperand;
        }

        remainder:
            MulExpression <-- "%" MulExpression AbstractMulOperand;

        categories :
            Operator = { "%" };
    }
}
