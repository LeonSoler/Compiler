package AnalizadorLexico;

import java.util.Objects;

public class Token {
    private String lexema;

    public Token(String lexema){
        this.lexema = lexema;
    }

    public String getLexema() {
        return this.lexema;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(lexema, token.lexema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lexema);
    }
}