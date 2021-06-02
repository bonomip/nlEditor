module neverlang.commons.expressions.ternary.TernarySyntax {
    reference syntax {
        provides {
            TernaryExpression: expressions, ternary;
        }
        requires {
            TernaryAlternatives;
        }

        ternary:
            TernaryExpression <-- TernaryCondition "?" TernaryAlternatives;

        categories :
            Operator = { "?" };
    }

    role(terminal-evaluation) {
        ternary: .{
            $ternary.operator="?";
        }.
    }
}
