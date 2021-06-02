module neverlang.commons.expressions.unary.UnaryExpr {
    imports {
        java.util.function.Supplier;
    }
    reference syntax {
        provides {
            UnaryExpression: expressions, unary;
        }
        requires {
            AbstractUnaryOperand;
        }
        unary:
            UnaryExpression <-- AbstractUnaryOperand;

        in-buckets:
            $0 <-- { Variables };
    }

    role (expression-initialization) {
        unary: .{
            $unary[0].type = $unary[1].type;
            $unary[0].expr = $unary[1].expr;
        }.
    }

    role(translate) {
        unary: .{
          String operator;
          try {
            operator = $unary.operator;
            $unary.operator = "";
          } catch(Exception e) {
            operator = "";
          }
          $unary.Text = operator + $unary[0].Text;
        }.

    }
}
