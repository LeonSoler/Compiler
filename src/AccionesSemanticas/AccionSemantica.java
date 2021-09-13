package AccionesSemanticas;
import AnalizadorLexico.*;

public abstract class AccionSemantica {

    protected static StringBuilder contenido;
    protected TablaSimbolos tabla;
    static private int indice = 0;

    public abstract String accion(char c);

    public void incrementarIndice(){
        this.indice++;
    }

    public void decrementarIndice(){
        this.indice--;
    }

}
