package neverlang.commons.expressions;

import neverlang.runtime.*;
import neverlang.Nlg;
public class Expressions extends Bundle {
  public Expressions() {
    importSlices(
     "neverlang.commons.expressions.unary.UnaryNot", 
     "neverlang.commons.expressions.unary.UnaryPlus", 
     "neverlang.commons.expressions.unary.UnaryMinus", 
     "neverlang.commons.expressions.unary.UnaryExpr", 
     "neverlang.commons.expressions.unary.UnaryComplement", 
     "neverlang.commons.expressions.unary.ParenthesizedExpression", 
     "neverlang.commons.expressions.add.AdditionSlice", 
     "neverlang.commons.expressions.sub.SubtractionSlice", 
     "neverlang.commons.expressions.add.AdditionOperandSlice", 
     "neverlang.commons.expressions.mul.MultiplicationSlice", 
     "neverlang.commons.expressions.div.DivisionSlice", 
     "neverlang.commons.expressions.rem.RemainderSlice", 
     "neverlang.commons.expressions.mul.MultiplicationOperandSlice", 
     "neverlang.commons.expressions.bitwise.lshift.LeftShiftSlice", 
     "neverlang.commons.expressions.bitwise.rshift.RightShiftSlice", 
     "neverlang.commons.expressions.bitwise.ushift.UnsignedShiftSlice", 
     "neverlang.commons.expressions.bitwise.ShiftOperandSlice", 
     "neverlang.commons.expressions.bitwise.and.BitwiseAndSlice", 
     "neverlang.commons.expressions.bitwise.and.BitwiseAndOperandSlice", 
     "neverlang.commons.expressions.bitwise.xor.BitwiseXorSlice", 
     "neverlang.commons.expressions.bitwise.xor.BitwiseXorOperandSlice", 
     "neverlang.commons.expressions.bitwise.or.BitwiseOrSlice", 
     "neverlang.commons.expressions.bitwise.or.BitwiseOrOperandSlice", 
     "neverlang.commons.expressions.rel.gt.GreaterSlice", 
     "neverlang.commons.expressions.rel.lt.LessSlice", 
     "neverlang.commons.expressions.rel.gteq.GreaterEqualSlice", 
     "neverlang.commons.expressions.rel.lteq.LessEqualSlice", 
     "neverlang.commons.expressions.rel.RelationalOperandSlice", 
     "neverlang.commons.expressions.rel.eq.EqualitySlice", 
     "neverlang.commons.expressions.rel.neq.NotEqualitySlice", 
     "neverlang.commons.expressions.rel.EqualityOperandSlice", 
     "neverlang.commons.expressions.bool.and.AndSlice", 
     "neverlang.commons.expressions.bool.and.AndOperandSlice", 
     "neverlang.commons.expressions.bool.or.OrSlice", 
     "neverlang.commons.expressions.bool.or.OrOperandSlice", 
     "neverlang.commons.expressions.ternary.TernarySlice", 
     "neverlang.commons.expressions.ternary.TernaryAlternativesSlice", 
     "neverlang.commons.expressions.ternary.TernaryOperandSlice"
    );
    declare(
     rename("TernaryExpression", /* <-- */ "TernaryCondition"), 
     rename("OrExpression", /* <-- */ "AbstractTernaryOperand"), 
     rename("AndExpression", /* <-- */ "AbstractOrOperand"), 
     rename("BitwiseOrExpression", /* <-- */ "AbstractAndOperand"), 
     rename("BitwiseXorExpression", /* <-- */ "AbstractBitwiseOrOperand"), 
     rename("BitwiseAndExpression", /* <-- */ "AbstractBitwiseXorOperand"), 
     rename("EqExpression", /* <-- */ "AbstractBitwiseAndOperand"), 
     rename("RelExpression", /* <-- */ "AbstractEqOperand"), 
     rename("ShiftExpression", /* <-- */ "AbstractRelOperand"), 
     rename("AddExpression", /* <-- */ "AbstractShiftOperand"), 
     rename("MulExpression", /* <-- */ "AbstractAddOperand"), 
     rename("UnaryExpression", /* <-- */ "AbstractMulOperand")
    );

  }

  public static void main (java.lang.String[] args) {
    try {
      Nlg.main(new java.lang.String[] { "neverlang.commons.expressions.Expressions" });
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}