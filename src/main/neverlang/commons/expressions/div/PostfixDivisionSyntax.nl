module neverlang.commons.expressions.div.PostfixDivisionSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, div, postfix;
        }
        requires {
            AbstractMulOperand;
        }

        division:
            MulExpression <-- MulExpression AbstractMulOperand "/";

        categories :
            Operator = { "/" };
    }
}
