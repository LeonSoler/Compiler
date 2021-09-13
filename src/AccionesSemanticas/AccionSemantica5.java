package AccionesSemanticas;

import AnalizadorLexico.Token;

public class AccionSemantica5 extends AccionSemantica{

    @Override
    public String accion(char c) {
        this.decrementarIndice();
        Double aux = Double.parseDouble(this.contenido.toString());
        if ((2.2250738585072014E-308 < aux && aux < 1.7976931348623157E+308) ||
                (-1.7976931348623157E+308 < aux && aux < -2.2250738585072014E-308)  || aux.equals(0.0)){
            Token t = new Token("DOUBLE", this.contenido.toString());
            this.tabla.contains(t);
            this.tabla.addSimbolo(t); //DOUBLE o CONST
            return "Se leyo el double: " + aux;
        } else
            return "El numero " + aux + " no esta dentro del rango de double";
    }
}
