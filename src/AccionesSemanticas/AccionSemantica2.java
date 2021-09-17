package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica2 extends AccionSemantica{

    public AccionSemantica2(TablaSimbolos ts, AtomicInteger indice){
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        this.contenido.append(c);
        incrementarIndice();
        return null;
    }
}
