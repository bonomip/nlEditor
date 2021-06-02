module neverlang.commons.expressions.unary.ParenthesizedExpression {
    imports {
        java.util.function.Supplier;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary, parenthesis;
        }
        requires {
            AbstractExpression;
        }
        unary:
            UnaryExpression <-- "(" AbstractExpression ")";

        categories :
            Brackets = { "(", ")" };
    }

    role(translate) {
        unary: <template> .{( {{$unary[1].Text}} )}.
    }

}
