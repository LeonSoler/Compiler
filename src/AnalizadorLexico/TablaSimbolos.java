package AnalizadorLexico;

import java.util.ArrayList;
import java.util.Arrays;

public class TablaSimbolos {
    private ArrayList<String> palabrasReservadas = new ArrayList<>(
            Arrays.asList("IF","THEN","ELSE","ENDIF","PRINT","FUNK","RETURN","BEGIN","END","BREAK","WHILE","DO","ULONG","DOUBLE"));

    private ArrayList<Token> tabla = new ArrayList<>();

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

    public int buscarIndice(String str) {
        for(Token t : this.tabla){
            if(t.getLexema() == str)
                return this.tabla.indexOf(t);
        }
        return 0;
    }
}
