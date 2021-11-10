package modelo;


import modelo.enums.Rol;

import java.util.Date;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private Date lastLogin;
    private Rol rol;



    public Usuario(String nombreUsuario, String password, Rol rol){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
        this.rol = rol;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public Rol getRol() {
        return rol;
    }
}
