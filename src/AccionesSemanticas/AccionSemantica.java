package AccionesSemanticas;
import AnalizadorLexico.*;

public abstract class AccionSemantica {

    protected static StringBuilder contenido;
    protected TablaSimbolos tabla;
    protected int indice;

    public AccionSemantica(TablaSimbolos ts, int indice) {
        this.indice = indice;
        this.tabla = ts;
    }

    public abstract String accion(char c);

    public void incrementarIndice(){
        this.indice++;
    }

    public void decrementarIndice(){
        this.indice--;
    }

    public String devolver(){
        return this.contenido.toString();
    }

}
