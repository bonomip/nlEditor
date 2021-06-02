package util;

import java.io.FileNotFoundException;
import java.io.FileReader;

public class Resource {

    public static String NL_PATH;

    public static String concat(String s1, String s2) {
        String s = s1;
        int L = s2.length();
        while (L > 0) {
            String common = s2.substring(0, L);
            if (s1.endsWith(common)) {
                s = s1+s2.substring(L);
                break;
            }
            L--;
        }
        return s;
    }

    public static FileReader getFile(String canonical_name) throws FileNotFoundException {
        String module_path = canonical_name.replace(".","/")+".nl";
        String file_name = concat(NL_PATH, module_path);
        return new FileReader(file_name);
    }

}
