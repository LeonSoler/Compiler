package AccionesSemanticas;

import AnalizadorLexico.Token;

public class AccionSemantica10 extends AccionSemantica {
    @Override
    public String accion(char c) {
        Long aux = Long.parseLong(this.contenido.toString());
        if(aux < Math.pow(2,32)-1) {
            this.decrementarIndice();
            Token t = new Token("DOUBLE", this.contenido.toString());
            if(!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            return "Se leyo el caracter " + aux;
        } else
            //error de rango
            return null;
    }
}