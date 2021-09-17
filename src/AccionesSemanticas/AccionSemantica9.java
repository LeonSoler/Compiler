package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica9 extends AccionSemantica{

    public AccionSemantica9(TablaSimbolos ts, AtomicInteger indice) {
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        this.decrementarIndice();
        System.out.println("No se puede ingresar el caracter " + c + " en la linea " + this.indice);
        return null;
    }
}