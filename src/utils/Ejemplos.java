package utils;

import modelo.Administrativo;
import modelo.Odontologo;
import modelo.Paciente;
import servicios.AdministrativoService;
import servicios.OdontologoService;
import servicios.PacienteService;

import java.util.List;

public class Ejemplos {
    public static void generarInfoEjemplo() {
        AdministrativoService administrativoService = new AdministrativoService();
        OdontologoService odontologoService = new OdontologoService();
        PacienteService pacienteService = new PacienteService();

        if (administrativoService.listar().isEmpty()) {
            for (Administrativo admin: DummyData.generarAdministrativos()) {
                administrativoService.guardar(admin);
            }
        }

        if (pacienteService.listar().isEmpty()) {
            for (Paciente pac : DummyData.generarPacientes()) {
                pacienteService.guardar(pac);
            }
        }

        if (odontologoService.listar().isEmpty()) {
            for (Odontologo odo : DummyData.generarOdontologos()) {
                odontologoService.guardar(odo);
            }
        }
    }

    public static void obtenerDisponibilidadOdontologo() {
        OdontologoService odontologoService = new OdontologoService();

        for (Odontologo odo: odontologoService.listar()) {
            System.out.println(odo.getNombreCompleto());
        }

    }
}
