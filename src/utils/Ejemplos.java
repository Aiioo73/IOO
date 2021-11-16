package utils;

import modelo.Administrativo;
import modelo.Odontologo;
import modelo.Paciente;
import modelo.Turno;
import servicios.*;

import java.util.Date;
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

    public static void generarTurno() {
        TurnoService turnoService = new TurnoService();

        if (!turnoService.listar().isEmpty()) {
            return;
        }

        OdontologoService odontologoService = new OdontologoService();

        Odontologo odontologo = odontologoService.buscar(1);

        Paciente paciente = new PacienteService().buscar(1);


        List<Date> turnosDisponiblesOdontologo = turnoService.obtenerDisponibilidad(odontologo);

        for (int i = 0; i < 5; i++) {
            System.out.println("Turno: " + turnosDisponiblesOdontologo.get(i + 1));
            Turno turno = new Turno(odontologo, paciente, turnosDisponiblesOdontologo.get(i + 1));
            turnoService.guardar(turno);
        }
    }

    public static void guardarIdUsuarioLogeado(int id) {
        UsuarioLogeadoService service = UsuarioLogeadoService.obtenerInstancia();
        service.setIdUsuarioLogeado(id);
    }

    public static void leerIdUsuarioLogeado() {
        UsuarioLogeadoService service = UsuarioLogeadoService.obtenerInstancia();
        System.out.println("El id del usuario logeado es: " + service.getIdUsuarioLogeado());

    }
}
