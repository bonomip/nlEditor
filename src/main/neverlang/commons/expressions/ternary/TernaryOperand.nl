module neverlang.commons.expressions.ternary.TernaryOperand {
    reference syntax {
        provides {
            TernaryExpression: expressions, ternary;
        }
        requires {
            AbstractTernaryOperand;
        }

        TernaryExpression <-- AbstractTernaryOperand;
    }

}
