package AccionesSemanticas;
import AnalizadorLexico.TablaSimbolos;
public class AccionSemantica8 extends AccionSemantica{


    public AccionSemantica8(TablaSimbolos ts, int indice) {
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        this.contenido.append(c);
        this.incrementarIndice();
        return "se leyo el token " + this.contenido;
    }
}
