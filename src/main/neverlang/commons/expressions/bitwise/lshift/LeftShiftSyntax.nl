module neverlang.commons.expressions.bitwise.lshift.LeftShiftSyntax {
    reference syntax {
        provides {
            ShiftExpression: expressions, bitwise, shift;
        }
        requires {
            AbstractShiftOperand;
        }

        shift:
            ShiftExpression <-- ShiftExpression "<<" AbstractShiftOperand;

        categories :
            Operator = { "<<" };
    }

    role(terminal-evaluation) {
        shift: .{
            $shift.operator="<<";
        }.
    }
}
