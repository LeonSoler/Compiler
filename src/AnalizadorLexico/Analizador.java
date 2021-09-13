package AnalizadorLexico;

import java.io.*;
import java.util.ArrayList;

public class Analizador {

    private static Analizador instancia;

    private int linea = 1;
    private ArrayList<Integer> archivo;
    private int[][] matrizEstados = new int[17][23];
    private int[][] matrizAcciones = new int[17][23];
    private Analizador(){

    }

    public static Analizador GetInstancia(){
        if (instancia == null)
            instancia = new Analizador();
        return instancia;
    }

    public void leer(String direccion) throws IOException {
        FileReader fr = new FileReader(direccion);
        int ascii;
        while((ascii = fr.read()) != -1)
            archivo.add(ascii);
    }
    private InputStream getFileFromResourceAsStream(String fileName) {

        // The class loader that loaded the class
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream(fileName);

        // the stream holding the file content
        if (inputStream == null) {
            throw new IllegalArgumentException("file not found! " + fileName);
        } else {
            return inputStream;
        }

    }
    public void cargarMatrizEstados(String direccion) throws IOException {
//        ClassLoader classLoader = getClass().getClassLoader();
//        InputStream inputStream = classLoader.getResourceAsStream(direccion);
        //Scanner input = new Scanner(this.getFileFromResourceAsStream(direccion));
        BufferedReader br = new BufferedReader(new InputStreamReader(getFileFromResourceAsStream(direccion)));
        String st;
        while ((st = br.readLine()) != null) {
            for (int i = 0; i < 17; i++) {
                for (int j = 0; j < 23; j++) {
                    try {
                        matrizEstados[i][j] = Integer.parseInt(st);
                    } catch (java.util.NoSuchElementException e) {
                    }
                }
            }

        }
    }

}
