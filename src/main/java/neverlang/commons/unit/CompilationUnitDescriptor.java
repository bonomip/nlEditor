package neverlang.commons.unit;

import java.io.IOException;

//import com.google.googlejavaformat.java.FormatterException;

public class CompilationUnitDescriptor {
    private String src;
    private String path;

    public CompilationUnitDescriptor(String src, String path) {
        this.src = src;
        this.path = path;
    }

    public void dump() {
        System.out.println("Output src to file: " + path);
        /*PrettyPrinter printer = new PrettyPrinter();
        try {
            printer.toFile(src, path);
        } catch (IOException | FormatterException e) {
            new TranslationException(path).printStackTrace();
        }*/
    }
}

