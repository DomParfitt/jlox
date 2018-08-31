package lox;

public abstract class Stmt {

    interface Visitor<R> {
        R visitExpressionStmt();
        R visitPrintStmt();
    }

    abstract <R> R accept(Visitor<R> visitor);

    static class Expression extends Stmt {

        public final Expr expression;

        public Expression(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitExpressionStmt();
        }
    }

    static class Print extends Stmt {

        public final Expr expression;

        public Print(Expr expression) {
            this.expression = expression;
        }

        @Override
        <R> R accept(Visitor<R> visitor) {
            return visitor.visitPrintStmt();
        }
    }
}
