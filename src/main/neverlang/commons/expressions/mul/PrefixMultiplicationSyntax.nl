module neverlang.commons.expressions.mul.PrefixMultiplicationSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, mul, prefix;
        }
        requires {
            AbstractMulOperand;
        }

        multiplication:
            MulExpression <--  "*" MulExpression AbstractMulOperand;

        categories :
            Operator = { "*" };
    }
}
