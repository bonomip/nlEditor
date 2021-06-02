package neverlang.commons.errors;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;

public class ErrorReport extends ArrayList<CompilationError> {
    public boolean failed() {
        return !isEmpty();
    }

    @Override
    public String toString() {
        this.sort(Comparator.comparingInt(CompilationError::getRow).thenComparingInt(CompilationError::getColumn));
        String template = "%s\n\n%d Error";
        String errors = this.stream()
            .map(CompilationError::toString)
            .collect(Collectors.joining("\n"));
        String ret = String.format(template, errors, this.size());
        return this.size() > 1 ? ret + "s" : ret;
    }
}