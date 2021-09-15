package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;

public class AccionSemantica2 extends AccionSemantica{

    public AccionSemantica2(TablaSimbolos ts, int indice){
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        this.contenido.append(c);
        incrementarIndice();
        return null;
    }
}
