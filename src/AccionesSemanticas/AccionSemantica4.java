package AccionesSemanticas;

public class AccionSemantica4 extends AccionSemantica {
    @Override
    public String accion(char c) {
        this.contenido = new StringBuilder(c);
        this.incrementarIndice();
        return "Se leyo el caracter " + this.contenido.toString();
    }
}