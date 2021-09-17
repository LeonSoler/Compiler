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
        this.contenido = new StringBuilder(c);
        this.incrementarIndice();
        this.contenido.toString();
        System.out.println("Se leyo el caracter " + this.contenido);
        return new TokenLexema(this.tabla.buscarIndice(this.contenido.toString()));
    }
}