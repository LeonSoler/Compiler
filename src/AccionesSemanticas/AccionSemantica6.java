package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica6 extends AccionSemantica {

    public AccionSemantica6(TablaSimbolos ts, AtomicInteger indice){
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        System.out.println("se leyo el comentario" + this.contenido);
        return null;
    }
}
