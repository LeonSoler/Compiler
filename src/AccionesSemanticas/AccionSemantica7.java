package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica7 extends AccionSemantica {

    public AccionSemantica7(TablaSimbolos ts, AtomicInteger indice){
        super(ts,indice);
    }

    @Override
    public TokenLexema accion(char c) {
        this.decrementarIndice();
        this.tipo = contenido.toString();
        System.out.println("se leyo el token " + contenido.toString());
        return new TokenLexema(-1);
    }
}
