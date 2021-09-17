package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica11 extends AccionSemantica{

    public AccionSemantica11(TablaSimbolos ts, AtomicInteger indice){
        super(ts,indice);
    }
    @Override
    public TokenLexema accion(char c) {
        contenido = new StringBuilder();
        this.incrementarIndice();
        return null;
    }
}
