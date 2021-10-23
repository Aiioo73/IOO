package TPO;

public class Domicilio {
    private String localidad;
    private String calle;
    private int altura;
    private int piso;
    private String departamento;

    public Domicilio(String localidad, String calle, int altura) {
        this.localidad = localidad;
        this.calle = calle;
        this.altura = altura;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }
}
