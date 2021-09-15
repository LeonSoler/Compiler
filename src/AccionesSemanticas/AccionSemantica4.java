package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
public class AccionSemantica4 extends AccionSemantica {

    public AccionSemantica4(TablaSimbolos ts, int indice) {
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        this.contenido = new StringBuilder(c);
        this.incrementarIndice();
        return "Se leyo el caracter " + this.contenido.toString();
    }
}