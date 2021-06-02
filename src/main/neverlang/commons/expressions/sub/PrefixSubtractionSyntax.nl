module neverlang.commons.expressions.sub.PrefixSubtractionSyntax {
    reference syntax {
        provides {
            AddExpression: expressions, math, sub, prefix;
        }
        requires {
            AbstractAddOperand;
        }

        subtraction:
            AddExpression <-- "-" AddExpression AbstractAddOperand;
    }
}
