package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;

public class AccionSemantica6 extends AccionSemantica {

    public AccionSemantica6(TablaSimbolos ts, int indice){
        super(ts, indice);
    }

    @Override
    public String accion(char c) {
        return "se leyo el comentario" + this.contenido;
    }
}
