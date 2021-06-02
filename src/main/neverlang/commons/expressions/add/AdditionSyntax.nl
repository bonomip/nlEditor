module neverlang.commons.expressions.add.AdditionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, add, infix;
        }
        requires {
            AbstractAddOperand;
        }

        addition:
            AddExpression <-- AddExpression "+" AbstractAddOperand;
            AddExpression <-- AddExpression "+" AbstractAddOperand;
            AddExpression <-- AddExpression "+" AbstractAddOperand "+" AbstractAddOperand;

        categories :
            Operator = { "+" };
    }

    role(terminal-evaluation) {
        addition: .{
            $addition.operator="+";
        }.
    }
}
