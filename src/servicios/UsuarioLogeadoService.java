package servicios;

public class UsuarioLogeadoService {

    private static UsuarioLogeadoService instancia = null;
    private int IdUsuarioLogeado;

    public static UsuarioLogeadoService obtenerInstancia() {
        if (instancia == null) {
            instancia = new UsuarioLogeadoService();
        }
        return instancia;
    }

    public int getIdUsuarioLogeado() {
        return IdUsuarioLogeado;
    }

    public void setIdUsuarioLogeado(int idUsuarioLogeado) {
        IdUsuarioLogeado = idUsuarioLogeado;
    }
}
