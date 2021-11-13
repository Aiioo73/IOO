package utils;

import modelo.Administrativo;
import modelo.Domicilio;
import modelo.Odontologo;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.List;

public class DummyData {
    public static List<Paciente> generarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        lista.add(new Paciente(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        ));
        lista.add(new Paciente(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        ));
        return lista;
    }

    public static List<Odontologo> generarOdontologos() {
        List<Odontologo> lista = new ArrayList<>();
        lista.add(new Odontologo(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        ));
        lista.add(new Odontologo(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        ));
        return lista;
    }

    public static List<Administrativo> generarAdministrativos() {
        List<Administrativo> lista = new ArrayList<>();
        lista.add(new Administrativo(
                "admin",
                "admin",
                "Admin Guy",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        ));
        return lista;
    }
}
