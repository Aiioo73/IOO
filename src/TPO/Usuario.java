package TPO;


import java.util.Date;

public class Usuario {
    private String nombreUsuario;
    private String password;
    private Date lastLogin;



    public Usuario(String nombreUsuario, String password){
        this.nombreUsuario = nombreUsuario;
        this.password = password;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getPassword() {
        return password;
    }
    

   }
