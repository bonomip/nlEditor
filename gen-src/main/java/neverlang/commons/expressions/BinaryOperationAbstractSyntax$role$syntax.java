package neverlang.commons.expressions;
import neverlang.runtime.Syntax;

public class BinaryOperationAbstractSyntax$role$syntax extends Syntax {
 public BinaryOperationAbstractSyntax$role$syntax() {
  provides(
    tag(nt("AbstractBinaryOperation"), "expressions", "binary", "abstract")
  );
  requires(
    tag(nt("AbstractOperand"), "expressions", "abstract")
  );
   declareProductions(
    p(nt("AbstractBinaryOperation"), nt("AbstractOperand"), nt("AbstractOperand")).setLabel("operation").setScore(0)
   );
   

 }
}