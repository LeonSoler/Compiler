package AccionesSemanticas;

import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.Token;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica10 extends AccionSemantica {
    public AccionSemantica10(TablaSimbolos ts, AtomicInteger indice) {
        super(ts,indice);
    }

    @Override
    public TokenLexema accion(char c) {
        Long aux = Long.parseLong(this.contenido.toString());
        if(aux < Math.pow(2,32)-1) {
            this.decrementarIndice();
            Token t = new Token(this.contenido.toString());
            if(!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            this.tipo = "CTE";
            System.out.println("Se leyo el caracter " + aux);
            return new TokenLexema(this.tabla.buscarIndice(this.contenido.toString()));
        } else
            //error de rango
            return null;
    }
}