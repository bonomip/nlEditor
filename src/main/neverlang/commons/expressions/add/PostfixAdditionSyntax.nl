module neverlang.commons.expressions.add.PostfixAdditionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, add, postfix;
        }
        requires {
            AbstractAddOperand;
        }

        addition:
            AddExpression <-- AddExpression AbstractAddOperand "+";

        categories :
            Operator = { "+" };
    }
}
