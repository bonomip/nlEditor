module neverlang.commons.expressions.ternary.TernaryAlternatives {
    reference syntax {
        provides {
            TernaryAlternatives: expressions, ternary;
        }
        requires {
            AbstractTernaryOperand;
        }

        TernaryAlternatives <-- AbstractTernaryOperand ":" AbstractTernaryOperand;

        categories:
            Operator = { ":" };
    }

    role(terminal-evaluation) {
        0 .{
            $0.operator=":";
        }.
    }

    role (expression-initialization) {
        0 .{
            $0.exprOptionTrue = $1.expr;
            $0.exprOptionFalse = $2.expr;
            $0.type = $1.type;
        }.
    }
}
