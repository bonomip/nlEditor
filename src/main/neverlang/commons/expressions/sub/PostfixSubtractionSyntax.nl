module neverlang.commons.expressions.sub.PostfixSubtractionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, sub, postfix;
        }
        requires {
            AbstractAddOperand;
        }

        subtraction:
            AddExpression <-- AddExpression AbstractAddOperand "-";
    }
}
