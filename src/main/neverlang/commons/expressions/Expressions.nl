bundle neverlang.commons.expressions.Expressions {
    slices
        //Unary Expressions
        neverlang.commons.expressions.unary.UnaryNot
        neverlang.commons.expressions.unary.UnaryPlus
        neverlang.commons.expressions.unary.UnaryMinus
        neverlang.commons.expressions.unary.UnaryExpr
        neverlang.commons.expressions.unary.UnaryComplement
        neverlang.commons.expressions.unary.ParenthesizedExpression

        //Additive Expressions
        neverlang.commons.expressions.add.AdditionSlice
        neverlang.commons.expressions.sub.SubtractionSlice
        neverlang.commons.expressions.add.AdditionOperandSlice

        //Multiplicative Expressions
        neverlang.commons.expressions.mul.MultiplicationSlice
        neverlang.commons.expressions.div.DivisionSlice
        neverlang.commons.expressions.rem.RemainderSlice
        neverlang.commons.expressions.mul.MultiplicationOperandSlice

        //BitwiseExpressions
        neverlang.commons.expressions.bitwise.lshift.LeftShiftSlice
        neverlang.commons.expressions.bitwise.rshift.RightShiftSlice
        neverlang.commons.expressions.bitwise.ushift.UnsignedShiftSlice
        neverlang.commons.expressions.bitwise.ShiftOperandSlice
        neverlang.commons.expressions.bitwise.and.BitwiseAndSlice
        neverlang.commons.expressions.bitwise.and.BitwiseAndOperandSlice
        neverlang.commons.expressions.bitwise.xor.BitwiseXorSlice
        neverlang.commons.expressions.bitwise.xor.BitwiseXorOperandSlice
        neverlang.commons.expressions.bitwise.or.BitwiseOrSlice
        neverlang.commons.expressions.bitwise.or.BitwiseOrOperandSlice

        //Relational Expressions
        neverlang.commons.expressions.rel.gt.GreaterSlice
        neverlang.commons.expressions.rel.lt.LessSlice
        neverlang.commons.expressions.rel.gteq.GreaterEqualSlice
        neverlang.commons.expressions.rel.lteq.LessEqualSlice
        neverlang.commons.expressions.rel.RelationalOperandSlice
        neverlang.commons.expressions.rel.eq.EqualitySlice
        neverlang.commons.expressions.rel.neq.NotEqualitySlice
        neverlang.commons.expressions.rel.EqualityOperandSlice

        //Boolean Expressions
        neverlang.commons.expressions.bool.and.AndSlice
        neverlang.commons.expressions.bool.and.AndOperandSlice
        neverlang.commons.expressions.bool.or.OrSlice
        neverlang.commons.expressions.bool.or.OrOperandSlice

        //Ternary Expression
        neverlang.commons.expressions.ternary.TernarySlice
        neverlang.commons.expressions.ternary.TernaryAlternativesSlice
        neverlang.commons.expressions.ternary.TernaryOperandSlice
    rename {
        //Expressions Associativity and Priority
        TernaryCondition --> TernaryExpression;
        AbstractTernaryOperand --> OrExpression;
        AbstractOrOperand --> AndExpression;
        AbstractAndOperand --> BitwiseOrExpression;
        AbstractBitwiseOrOperand --> BitwiseXorExpression;
        AbstractBitwiseXorOperand --> BitwiseAndExpression;
        AbstractBitwiseAndOperand --> EqExpression;
        AbstractEqOperand --> RelExpression;
        AbstractRelOperand --> ShiftExpression;
        AbstractShiftOperand --> AddExpression;
        AbstractAddOperand --> MulExpression;
        AbstractMulOperand --> UnaryExpression;
    }
}
