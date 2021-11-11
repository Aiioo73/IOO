package utils;

import modelo.Domicilio;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DummyData {
    public static List<Paciente> pacientesDeEjemplo() {
        List<Paciente> lista = new ArrayList<Paciente>();
        lista.add(new Paciente("John", "Doe", new Domicilio(" ", " ", 123), 12312312, new Date()));
        lista.add(new Paciente("John", "Doe", new Domicilio(" ", " ", 123), 12312312, new Date()));
        lista.add(new Paciente("John", "Doe", new Domicilio(" ", " ", 123), 12312312, new Date()));
        lista.add(new Paciente("John", "Doe", new Domicilio(" ", " ", 123), 12312312, new Date()));
        return lista;
    }
}
