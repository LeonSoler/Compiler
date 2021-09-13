package AccionesSemanticas;

public class AccionSemantica8 extends AccionSemantica{
    @Override
    public String accion(char c) {
        this.contenido.append(c);
        this.incrementarIndice();
        return "se leyo el token " + this.contenido;
    }
}
