package AccionesSemanticas;

public class AccionSemantica2 extends AccionSemantica{

    @Override
    public String accion(char c) {
        this.contenido.append(c);
        incrementarIndice();
        return null;
    }
}
