package neverlang.commons.expressions.test;

import neverlang.runtime.*;
import neverlang.Nlg;
public class ExpressionsLang extends Language {
  public ExpressionsLang() {
    importSlices(
     "neverlang.commons.expressions.test.ExpressionUnit", 
     "neverlang.commons.unit.CompilationUnitTranslator"
    );
    importBundles(
     "neverlang.commons.expressions.Expressions", 
     "neverlang.commons.types.Literals"
    );
    importEndemicSlices(
     "neverlang.commons.errors.ErrorReportEndemic"
    );
    declare(
     role(Role.Flags.POSTORDER, "terminal_evaluation", "type_promotion", "expression_initialization"), 
     role(Role.Flags.MANUAL, "evaluation"), 
     role(Role.Flags.POSTORDER, "translate")
    );
    declare(
     rename("CompilationUnit", /* <-- */ "ExpressionUnit"), 
     rename("TernaryExpression", /* <-- */ "AbstractExpression"), 
     rename("Literal", /* <-- */ "AbstractLiteral"), 
     rename("Literal", /* <-- */ "AbstractUnaryOperand")
    );

  }

  public static void main (java.lang.String[] args) {
    try {
      Nlg.main(new java.lang.String[] { "neverlang.commons.expressions.test.ExpressionsLang" });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}