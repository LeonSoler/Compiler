package AccionesSemanticas;

import AnalizadorLexico.Token;

public class AccionSemantica3 extends AccionSemantica{

    @Override
    public String accion(char c) {
        if (this.contenido.length() > 23)
            this.contenido.delete(22, this.contenido.length());   //22 o 23 quien lo sabe
            //warning de alguna manera.
        if (this.tabla.containsPalabaReservada(this.contenido.toString())){
            decrementarIndice();
            return "palabra reservada " + this.contenido.toString();
        }
        else {
            Token t = new Token("ID", this.contenido.toString());
            if (!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            decrementarIndice();
            return "ID " + this.contenido.toString();
        }
    }
}
