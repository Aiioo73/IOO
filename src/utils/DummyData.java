package utils;

import modelo.Domicilio;
import modelo.Paciente;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DummyData {
    public static List<Paciente> generarPacientes() {
        List<Paciente> lista = new ArrayList<>();
        lista.add(new Paciente("Whitney", "Laurel", new Domicilio("Brooklyn", "Briercliff Road", 3984), 12312312, new Date()));
        lista.add(new Paciente("Brett", "Willard", new Domicilio("Malden", "Romano Street", 688), 12312312, new Date()));
        lista.add(new Paciente("Harry", "Davis", new Domicilio("Houston" , "Mulberry Street", 3047), 12312312, new Date()));
        lista.add(new Paciente("Katherine", "Haigh", new Domicilio("Rialto", "Roosevelt Wilson Lane", 317), 12312312, new Date()));
        return lista;
    }
}
