package AnalizadorLexico;

import AccionesSemanticas.*;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Analizador {

    private static Analizador instancia;

    private int linea = 1;
    AtomicInteger indice = new AtomicInteger(0);
    private ArrayList<Integer> archivo;
    private ArrayList<TokenLexema> tokens;
    private int[][] matrizEstados = new int[17][23];
    private ArrayList<String> erroresLexicos = new ArrayList<>();

    private TablaSimbolos tabla = new TablaSimbolos();
    private AccionSemantica1 as1 = new AccionSemantica1(tabla, indice);
    private AccionSemantica2 as2 = new AccionSemantica2(tabla, indice);
    private AccionSemantica3 as3 = new AccionSemantica3(tabla, indice);
    private AccionSemantica4 as4 = new AccionSemantica4(tabla, indice);
    private AccionSemantica5 as5 = new AccionSemantica5(tabla, indice);
    private AccionSemantica6 as6 = new AccionSemantica6(tabla, indice);
    private AccionSemantica7 as7 = new AccionSemantica7(tabla, indice);
    private AccionSemantica8 as8 = new AccionSemantica8(tabla, indice);
    private AccionSemantica9 as9 = new AccionSemantica9(tabla, indice);
    private AccionSemantica10 as10 = new AccionSemantica10(tabla, indice);

    private HashMap<String, Integer> tokenIdentificacion = new HashMap<>();
    private HashMap<Character, Integer> columnaMatriz = new HashMap<>();

    private AccionSemantica[][] matrizAcciones = {
            {as1, as1, as1, as4, as1, as4, as4, as4, as4, as4, as4, as1, as1, as1, as1, as1, as1, as1, null, null, null, as9, as1},
            {as2, as2, as3, as3, as3, as3, as3, as3, as3, as3, as3, as2, as3, as3, as3, as3, as3, as3, as3, as3, as3, as3, as2},
            {as7, as7, as2, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7},
            {as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2},
            {as2, as2, as6, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2},
            {as2, as2, as6, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2},
            {as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as8, as7, as7, as7, as7, as7, as7, as7},
            {as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as7, as8, as7, as7, as7, as7, as7, as7, as7},
            {as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as8, as9, as9, as9, as9, as9, as9, as9},
            {as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as8, as9, as9, as9, as9},
            {as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as8, as9, as9, as9, as9},
            {as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as2, as8, as2, as2, as2, as2, as2},
            {as2, as5, as5, as5, as2, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as2},
            {as9, as2, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9},
            {as5, as2, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as2},
            {as9, as9, as9, as9, as9, as9, as9, as9, as9, as2, as2, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9, as9},
            {as5, as2, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5, as5}
    };

    private Analizador(){
        this.cargarMatEstados("matriz",17,23);
        this.cargarTokens();
        this.cargarMapa();
        this.archivo = new ArrayList<>();
        this.tokens = new ArrayList<>();
    }

    private void cargarMapa() {
        this.columnaMatriz.put('l',0);
        this.columnaMatriz.put('d',1);
        this.columnaMatriz.put('/',2);
        this.columnaMatriz.put('*',3);
        this.columnaMatriz.put('.',4);
        this.columnaMatriz.put('(',5);
        this.columnaMatriz.put(')',6);
        this.columnaMatriz.put(',',7);
        this.columnaMatriz.put(';',8);
        this.columnaMatriz.put('+',9);
        this.columnaMatriz.put('-',10);
        this.columnaMatriz.put('_',11);
        this.columnaMatriz.put('<',12);
        this.columnaMatriz.put('>',13);
        this.columnaMatriz.put('|',14);
        this.columnaMatriz.put('=',15);
        this.columnaMatriz.put(':',16);
        this.columnaMatriz.put('%',17);
        this.columnaMatriz.put('&',18);
        this.columnaMatriz.put('\t',19);
        this.columnaMatriz.put('\n',20);
        this.columnaMatriz.put('c',21); //resto
        this.columnaMatriz.put('e',22);
    }

    private void cargarTokens() {
        this.tokenIdentificacion.put("/",256);
        this.tokenIdentificacion.put("*",257);
        this.tokenIdentificacion.put(".",258);
        this.tokenIdentificacion.put("(",259);
        this.tokenIdentificacion.put(")",260);
        this.tokenIdentificacion.put(",",261);
        this.tokenIdentificacion.put(";",262);
        this.tokenIdentificacion.put("+",263);
        this.tokenIdentificacion.put("-",264);
        this.tokenIdentificacion.put("_",265);
        this.tokenIdentificacion.put("<",266);
        this.tokenIdentificacion.put(">",267);
        this.tokenIdentificacion.put("<>",268);
        this.tokenIdentificacion.put(">=",269);
        this.tokenIdentificacion.put("<=",270);
        this.tokenIdentificacion.put("||",271);
        this.tokenIdentificacion.put("=",272);
        this.tokenIdentificacion.put(":=",273);
        this.tokenIdentificacion.put("%",274);
        this.tokenIdentificacion.put("&&",275);
        this.tokenIdentificacion.put("ID",276);
        this.tokenIdentificacion.put("CTE",277);
        this.tokenIdentificacion.put("IF",278);
        this.tokenIdentificacion.put("THEN",279);
        this.tokenIdentificacion.put("ELSE",280);
        this.tokenIdentificacion.put("ENDIF",281);
        this.tokenIdentificacion.put("PRINT",282);
        this.tokenIdentificacion.put("FUNC",283);
        this.tokenIdentificacion.put("RETURN",284);
        this.tokenIdentificacion.put("BEGIN",285);
        this.tokenIdentificacion.put("END",286);
        this.tokenIdentificacion.put("BREAK",287);
        this.tokenIdentificacion.put("ULONG",288);
        this.tokenIdentificacion.put("DOUBLE",289);
    }

    public static Analizador GetInstancia(){
        if (instancia == null)
            instancia = new Analizador();
        return instancia;
    }
    public void leer(String direccion) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(getFileFromResourceAsStream(direccion)));
        int ascii;
        while((ascii = br.read()) != -1) {
            archivo.add(ascii);
        }
    }

    private InputStream getFileFromResourceAsStream(String fileName) {
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }
    }

    private int [][] cargarMatEstados(String direccion, int rows, int columns) {
        Scanner sc = new Scanner(new BufferedReader(new InputStreamReader(getFileFromResourceAsStream(direccion))));

        int [][] myArray = new int[rows][columns];
        while(sc.hasNextLine()) {
            for (int i=0; i<myArray.length; i++) {
                String[] line = sc.nextLine().trim().split(" ");
                for (int j=0; j<line.length; j++) {
                    myArray[i][j] = Integer.parseInt(line[j]);
                }
            }
        }
        return myArray;
    }

    public ArrayList<TokenLexema> leerToken() {
        int estado = 0;
        int estadoAnt = -1;
        char caracter = ' ';
        int ascii = this.archivo.get(indice.intValue());
        caracter = detectarCaracter(ascii);
        while(indice.intValue() < this.archivo.size()){
            if (ascii == 10){
                this.linea++;
            }
            if (estado == 17){
                TokenLexema tokenLexema = this.matrizAcciones[estadoAnt][estado].accion(caracter);
                String tipoToken = this.matrizAcciones[estadoAnt][estado].devolver();
                tokenLexema.setID(this.tokenIdentificacion.get(tipoToken));
                this.tokens.add(tokenLexema);
                estado = 0;
            }

            else if(estado == 18) {
                estado = 0;
                this.erroresLexicos.add("No se puede agregar " + caracter + " en " + this.linea);
            }
            this.matrizAcciones[estado][this.columnaMatriz.get(caracter)].accion(caracter);
            ascii = this.archivo.get(indice.intValue());
            caracter = detectarCaracter(caracter);
            estadoAnt = estado;
            estado = this.matrizEstados[estado][this.columnaMatriz.get(caracter)];
        }
        return tokens;
    }

    private char detectarCaracter(int ascii) {
        if ((ascii >= 65 && ascii <= 90) || (ascii >= 97) && (ascii <= 122))
            return 'l';
        else if (ascii >= 48 && ascii <= 57)
            return 'd';
        else
            return (char) ascii;
    }
}

