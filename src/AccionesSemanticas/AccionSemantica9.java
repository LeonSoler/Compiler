package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
public class AccionSemantica9 extends AccionSemantica{

    public AccionSemantica9(TablaSimbolos ts, int indice) {
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        this.decrementarIndice();
        return "No se puede ingresar el caracter " + c + " en la linea " + this.indice;
    }
}