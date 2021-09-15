package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;

public class AccionSemantica1 extends AccionSemantica{

    public AccionSemantica1(TablaSimbolos ts, int indice){
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        this.contenido = new StringBuilder(c);
        this.incrementarIndice();
        return null;
    }
}
