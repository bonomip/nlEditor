import neverlang.runtime.Syntax;

public class Int$role$syntax extends Syntax {
 public Int$role$syntax() {
   declareProductions(
    p(nt("Integer"), regex("[0-9]+", "[0-9]+")).setScore(0)
   );
   

 }
}