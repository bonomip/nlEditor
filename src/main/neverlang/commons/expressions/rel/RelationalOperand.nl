module neverlang.commons.expressions.rel.RelationalOperand {
    reference syntax {
        provides {
            RelExpression: expressions, relational;
        }
        requires {
            AbstractRelOperand;
        }
        RelExpression <-- AbstractRelOperand;
    }

}
