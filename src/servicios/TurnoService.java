package servicios;

import dao.TurnoDAOArchivo;
import modelo.Odontologo;
import modelo.Paciente;
import modelo.Turno;
import servicios.abstractions.IService;
import utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class TurnoService implements IService<Turno> {
    private TurnoDAOArchivo dao;

    public TurnoService() {
        this.dao = new TurnoDAOArchivo();
    }

    @Override
    public void guardar(Turno entity) {
        dao.guardar(entity);
    }

    @Override
    public Turno buscar(int id) {
        return dao.buscar(id);
    }

    @Override
    public void eliminar(int id) {
        dao.eliminar(id);
    }

    @Override
    public List<Turno> listar() {
        return dao.listar();
    }

    public List<Turno> listar(Date fechaHasta) {
        Date hoy = DateUtils.cleanTime(new Date());
        List<Turno> lista = listar();
        lista.removeIf(turno -> !turno.getFechaTurno().after(hoy) || !turno.getFechaTurno().before(fechaHasta));
        return lista;
    }

    public List<Turno> listar(Odontologo odontologo) {
        List<Turno> lista = listar();
        lista.removeIf(turno -> turno.getDocAsignado().getId() != odontologo.getId());
        return lista;
    }

    public List<Turno> listar(Paciente paciente) {
        List<Turno> lista = listar();
        lista.removeIf(turno -> turno.getPaciente().getId() != paciente.getId());
        return lista;
    }

    public List<Date> obtenerDisponibilidad(Odontologo odontologo) {
        List<Date> turnosSemana = obtenerTurnosSemana(odontologo.getHoraEntrada(), odontologo.getHoraSalida());
        List<Date> resultado = new ArrayList<>(turnosSemana);

        List<Turno> turnosOcupados = listar(odontologo);

        List<Date> fechasOcupadas = turnosOcupados.stream().map(Turno::getFechaTurno).collect(Collectors.toList());

        for (Date fechaTurno : fechasOcupadas) {
            if (resultado.contains(fechaTurno)) {
                resultado.remove(fechaTurno);
            }
        }

        return resultado;
    }

    public List<Date> obtenerTurnosSemana(int primeraHora, int ultimaHora) {
        List<Date> lista = new ArrayList<>();
        for (int i = 0; i < 7; i++) {
            Date hoy = DateUtils.cleanTime(new Date());
            Date dia = DateUtils.addDays(hoy, i);

            for (int horaTurno = primeraHora; horaTurno < ultimaHora; horaTurno++) {
                Date turno = DateUtils.addHours(dia, horaTurno);
                lista.add(turno);
            }

        }
        return lista;
    }

    public void crearTurno(Odontologo odontologo, Paciente paciente, Date fecha) {
        Turno turno = new Turno(odontologo, paciente, fecha);
        this.guardar(turno);
    }
}
