package neverlang.commons.expressions.errors;

import neverlang.commons.errors.CompilationError;

public class BadOperandTypesException extends CompilationError {
    public BadOperandTypesException(int row, int column, String operator, Class<?> leftType, Class<?> rightType) {
        super(
            row,
            column,
            String.format("Bad operand types for binary operator '%s':\n\tfirst type: %s\n\tsecond type: %s\n",
            operator,
            leftType.getName(),
            rightType.getName()));
    }

    public BadOperandTypesException(int row, int column, String operator, Class<?> operandType) {
        super(
            row,
            column,
            String.format("Bad operand type for unary operator '%s':%s\n", operator, operandType.getName()));
    }
}
