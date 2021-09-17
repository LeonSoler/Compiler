import AnalizadorLexico.Analizador;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        Analizador analizador = Analizador.GetInstancia();
        analizador.leer("programa");
        analizador.leerToken();
    }
}
