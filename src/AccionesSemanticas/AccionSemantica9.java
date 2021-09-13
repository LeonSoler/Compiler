package AccionesSemanticas;

public class AccionSemantica9 extends AccionSemantica{
    @Override
    public String accion(char c) {
       return "No se puede ingresar el caracter " + c + " en esta linea";
    }
}