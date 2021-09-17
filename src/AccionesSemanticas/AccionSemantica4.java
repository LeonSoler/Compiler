package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica4 extends AccionSemantica {

    public AccionSemantica4(TablaSimbolos ts, AtomicInteger indice) {
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        contenido = new StringBuilder();
        contenido.append(c);
        this.incrementarIndice();
        contenido.toString();
        tipo = String.valueOf(c);
        System.out.println("Se leyo el caracter " + contenido);
        return new TokenLexema(-1);
    }
}