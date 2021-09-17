package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica8 extends AccionSemantica{


    public AccionSemantica8(TablaSimbolos ts, AtomicInteger indice) {
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        contenido.append(c);
        this.incrementarIndice();
        System.out.println("se leyo el token " + contenido);
        return new TokenLexema(-1);
    }
}
