module neverlang.commons.expressions.rel.EqualityOperand {
    reference syntax {
        provides {
            EqExpression: expressions, relational;
        }
        requires {
            AbstractEqOperand;
        }
        EqExpression <-- AbstractEqOperand;
    }

}
