module neverlang.commons.expressions.div.PrefixDivisionSyntax {
    reference syntax {
        provides {
            MulExpression: expressions, math, div, prefix;
        }
        requires {
            AbstractMulOperand;
        }

        division:
            MulExpression <-- "/" MulExpression AbstractMulOperand;

        categories :
            Operator = { "/" };
    }
}
