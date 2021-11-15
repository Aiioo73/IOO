package modelo.abstractions;

import modelo.Domicilio;
import utils.StringUtils;

import java.util.Date;

public abstract class Usuario extends Entidad {
    private String nombreUsuario;
    private String password;
    private String nombreCompleto;

    private String dni;
    private Date fechaAlta;

    private Domicilio domicilio;

    public Usuario(String nombreUsuario, String passwordHash, String nombreCompleto, String dni, Domicilio domicilio) {
        this.nombreUsuario = nombreUsuario;
        this.password = StringUtils.getMD5(passwordHash);
        this.nombreCompleto = nombreCompleto;
        this.dni = dni;
        this.domicilio = domicilio;
        this.fechaAlta = new Date();
    }

    public Usuario() {

    }

    public boolean checkPassword(String psswd){
        String md5 = StringUtils.getMD5(psswd);
        return password.equals(md5);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    public String getDni() {
        return dni;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
