package AnalizadorLexico;


import java.util.Objects;

public class Token {
    private String tipo;
    private String lexema;

    public Token(String tipo, String lexema){
        this.tipo = tipo;
        this.lexema = lexema;
    }

    public String getTipo() {
        return this.tipo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Token token = (Token) o;
        return Objects.equals(tipo, token.tipo) && Objects.equals(lexema, token.lexema);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tipo, lexema);
    }
}
