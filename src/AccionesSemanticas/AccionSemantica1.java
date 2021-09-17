package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;
import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica1 extends AccionSemantica{

    public AccionSemantica1(TablaSimbolos ts, AtomicInteger indice){
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        contenido = new StringBuilder();
        contenido.append(c);
        this.incrementarIndice();
        return null;
    }
}
