package AccionesSemanticas;

public class AccionSemantica7 extends AccionSemantica {

    @Override
    public String accion(char c) {
        this.decrementarIndice();
        return "se leyo el token " + this.contenido;
    }
}
