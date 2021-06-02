module neverlang.commons.expressions.bool.or.OrOperand {
    reference syntax {
        provides {
            OrExpression: expressions, boolean, or;
        }
        requires {
            AbstractOrOperand;
        }

        OrExpression <-- AbstractOrOperand;
    }

}
