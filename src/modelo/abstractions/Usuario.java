package modelo.abstractions;

import modelo.Domicilio;
import utils.StringUtils;

import java.util.Date;

public abstract class Usuario {
    private int id;
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

    public boolean checkPassword(String psswd){
        String md5 = StringUtils.getMD5(psswd);
        return password == md5;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public String getDni() {
        return dni;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }
}
