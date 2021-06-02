module neverlang.commons.expressions.add.PrefixAdditionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, add, prefix;
        }
        requires {
            AbstractAddOperand;
        }

        addition:
            AddExpression <-- "+" AddExpression AbstractAddOperand;

        categories :
            Operator = { "+" };
    }
}
