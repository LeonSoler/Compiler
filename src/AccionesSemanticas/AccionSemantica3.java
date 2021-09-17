package AccionesSemanticas;

import AnalizadorLexico.Token;
import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;
import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica3 extends AccionSemantica{

    public AccionSemantica3(TablaSimbolos ts, AtomicInteger indice){
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        if (this.contenido.length() > 23)
            this.contenido.delete(22, this.contenido.length());   //22 o 23 quien lo sabe
        //warning de alguna manera.
        if (this.tabla.containsPalabaReservada(this.contenido.toString())) {
            decrementarIndice();
            this.tipo = this.contenido.toString();
            System.out.println("palabra reservada: " + this.contenido);
            return new TokenLexema(-1);
        } else {
            Token t = new Token(this.contenido.toString());
            if (!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            decrementarIndice();
            this.tipo = "ID";
            System.out.println("ID: " + this.contenido);
            return new TokenLexema(this.tabla.buscarIndice(this.contenido.toString()));
        }
    }
}