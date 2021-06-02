import neverlang.runtime.Syntax;

public class Program$role$syntax extends Syntax {
 public Program$role$syntax() {
   declareProductions(
    p(nt("Program"), nt("Expression")).setScore(0)
   );
   

 }
}