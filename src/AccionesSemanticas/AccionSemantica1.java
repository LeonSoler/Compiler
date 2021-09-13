package AccionesSemanticas;

public class AccionSemantica1 extends AccionSemantica{

    @Override
    public String accion(char c) {
        this.contenido = new StringBuilder(c);
        this.incrementarIndice();
        return null;
    }
}
