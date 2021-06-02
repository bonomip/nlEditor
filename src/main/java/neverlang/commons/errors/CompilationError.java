package neverlang.commons.errors;

public class CompilationError extends RuntimeException {
    private final int row;
    private final int column;

    public CompilationError(int row, int column, String message) {
        super(message);
        this.row = row;
        this.column = column;
    }

    @Override
    public String toString() {
        return String.format("Compilation error at %d:%d - %s", row, column, getMessage());
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}