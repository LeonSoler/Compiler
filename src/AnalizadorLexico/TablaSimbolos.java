package AnalizadorLexico;

import java.util.ArrayList;
import java.util.Arrays;

public class TablaSimbolos {
    private ArrayList<String> palabrasReservadas = new ArrayList<String>(
            Arrays.asList("IF","THEN","ELSE","ENDIF","PRINT","FUNK","RETURN","BEGIN","END","BREAK","WHILE","DO","ULONG","DOUBLE"));

    private ArrayList<Token> tabla;

    public TablaSimbolos(){

    }
    public boolean containsPalabaReservada(String lexema){
        return this.palabrasReservadas.contains(lexema);
    }

    public void addSimbolo(Token t){
        this.tabla.add(t);
    }

    public boolean contains(Token t) {
        return this.tabla.contains(t);
    }
}
