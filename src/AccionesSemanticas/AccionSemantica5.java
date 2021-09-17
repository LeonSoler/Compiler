package AccionesSemanticas;

import AnalizadorLexico.Token;
import AnalizadorLexico.TablaSimbolos;
import AnalizadorLexico.TokenLexema;

import java.util.concurrent.atomic.AtomicInteger;

public class AccionSemantica5 extends AccionSemantica{

    public AccionSemantica5(TablaSimbolos ts, AtomicInteger indice){
        super(ts, indice);
    }

    @Override
    public TokenLexema accion(char c) {
        this.decrementarIndice();
        Double aux = Double.parseDouble(this.contenido.toString());
        if ((2.2250738585072014E-308 < aux && aux < 1.7976931348623157E+308) ||
                (-1.7976931348623157E+308 < aux && aux < -2.2250738585072014E-308)  || aux.equals(0.0)){
            Token t = new Token(this.contenido.toString());
            if (!this.tabla.contains(t))
                this.tabla.addSimbolo(t);
            this.tipo = "CTE";
            System.out.println("Se leyo el double: " + aux);
            return new TokenLexema(this.tabla.buscarIndice(this.contenido.toString()));
        } else
            System.out.println("El numero " + aux + " no esta dentro del rango de double");
            return null;
    }
}
