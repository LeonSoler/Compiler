package AccionesSemanticas;
import AnalizadorLexico.*;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class AccionSemantica {

    protected static StringBuilder contenido;
    protected TablaSimbolos tabla;
    protected AtomicInteger indice = null;
    protected String tipo;

    public AccionSemantica(TablaSimbolos ts, AtomicInteger indice) {
        this.indice = indice;
        this.tabla = ts;
    }

    public abstract TokenLexema accion(char c);

    public void incrementarIndice(){
        this.indice.set(this.indice.intValue()+1);
    }

    public void decrementarIndice(){
        this.indice.set(this.indice.intValue()-1);
    }

    public String devolver(){
        return this.tipo;
    }
}
