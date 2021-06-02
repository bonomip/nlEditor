module neverlang.commons.expressions.add.AdditionOperand {
    reference syntax {
        provides {
            AddExpression: expressions, math, add, operand;
        }
        requires {
            AbstractAdditionOperand;
        }
        AddExpression <-- AbstractAddOperand;
    }
}
