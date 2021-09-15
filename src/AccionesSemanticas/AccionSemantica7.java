package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
public class AccionSemantica7 extends AccionSemantica {

    public AccionSemantica7(TablaSimbolos ts, int indice){
        super(ts,indice);
    }

    @Override
    public String accion(char c) {
        this.decrementarIndice();
        return "se leyo el token " + this.contenido;
    }
}
