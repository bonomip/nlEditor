

import neverlang.runtime.*;
import neverlang.Nlg;
public class TestLang extends Language {
  public TestLang() {
    importSlices(
     "SumExpr", 
     "ProdExpr", 
     "Expr", 
     "Program", 
     "Int"
    );
    declare(
     role(Role.Flags.POSTORDER, "eval")
    );

  }

  public static void main (java.lang.String[] args) {
    try {
      Nlg.main(new java.lang.String[] { "TestLang" });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}