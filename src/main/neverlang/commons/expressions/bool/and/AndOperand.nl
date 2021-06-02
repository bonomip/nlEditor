module neverlang.commons.expressions.bool.and.AndOperand {
    reference syntax {
        provides {
            AndExpression: expressions, boolean, and;
        }
        requires {
            AbstractAndOperand;
        }

        AndExpression <-- AbstractAndOperand;
    }

}
