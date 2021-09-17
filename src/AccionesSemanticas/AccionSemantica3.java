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
        if (contenido.length() > 23)
            contenido.delete(22, contenido.length());   //22 o 23 quien lo sabe
        //warning de alguna manera.
        if (this.tabla.containsPalabaReservada(contenido.toString())) {
            decrementarIndice();
            this.tipo = contenido.toString();
            System.out.println("palabra reservada: " + contenido);
            return new TokenLexema(-1);
        } else {
            Token t = new Token(contenido.toString());
            if (!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            decrementarIndice();
            this.tipo = "ID";
            System.out.println("ID: " + contenido);
            return new TokenLexema(this.tabla.buscarIndice(contenido.toString()));
        }
    }
}