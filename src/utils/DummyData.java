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

        Paciente paciente1 = new Paciente(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        );

        Paciente paciente2 = new Paciente(
                "paciente",
                "paciente",
                "Paciente Fulanito",
                "99999999",
                new Domicilio("Brooklyngo", "Wallaby", 1234)
        );

        lista.add(paciente2);
        lista.add(paciente1);
        return lista;
    }

    public static List<Odontologo> generarOdontologos() {
        List<Odontologo> lista = new ArrayList<>();

        Odontologo odontologo1 = new Odontologo(
                "lwhitney",
                "password",
                "Whitney Laurel",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984),
                9,
                18
        );


        lista.add(odontologo1);
        return lista;
    }

    public static List<Administrativo> generarAdministrativos() {
        List<Administrativo> lista = new ArrayList<>();

        Administrativo administrativo1 = new Administrativo(
                "admin",
                "admin",
                "Admin Guy",
                "12312312",
                new Domicilio("Brooklyn", "Briercliff Road", 3984)
        );


        lista.add(administrativo1);
        return lista;
    }
}
