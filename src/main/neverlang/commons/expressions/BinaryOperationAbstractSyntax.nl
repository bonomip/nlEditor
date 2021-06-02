module neverlang.commons.expressions.BinaryOperationAbstractSyntax {
    reference syntax {
        provides {
            AbstractBinaryOperation: expressions, binary, abstract;
        }
        requires {
            AbstractOperand: expressions, abstract;
        }
        operation:
            AbstractBinaryOperation <-- AbstractOperand AbstractOperand;
    }

    role(translate) {
        operation: .{
            String operator;
            try {
                operator = $operation.operator;
                $operation.operator = "";
            } catch(Exception e) {
                operator = "";
            }
            $operation.Text =  $operation[1].Text + operator + $operation[2].Text;
        }.
    }
}
