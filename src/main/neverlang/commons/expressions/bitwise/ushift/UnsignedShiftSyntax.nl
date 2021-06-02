module neverlang.commons.expressions.bitwise.ushift.UnsignedShiftSyntax {
    reference syntax {
        provides {
            ShiftExpression: expressions, bitwise, shift;
        }
        requires {
            AbstractShiftOperand;
        }

        shift:
            ShiftExpression <-- ShiftExpression ">>>" AbstractShiftOperand;

        categories :
            Operator = { ">>>" };
    }

    role(terminal-evaluation) {
        shift: .{
            $shift.operator=">>>";
        }.
    }
}
