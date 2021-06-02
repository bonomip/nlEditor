package util;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Resource {

    public static FileReader getFile(String canonical_name) throws FileNotFoundException {
        String file_name = "src/main/"+canonical_name.replace(".","/")+".nl";
        return new FileReader(file_name);
    }

}
