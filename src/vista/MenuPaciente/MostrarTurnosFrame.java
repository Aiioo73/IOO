package vista.MenuPaciente;

import javax.swing.*;

import modelo.Paciente;
import modelo.Turno;
import servicios.PacienteService;
import servicios.TurnoService;
import servicios.UsuarioLogeadoService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class MostrarTurnosFrame extends JFrame implements ActionListener {
    // JFrame frame = new JFrame(" ");
    JTextArea txtsub;
    Container container;
    JLabel titulo;
    JButton salir = new JButton("Salir");
    public TurnoService listaTurnos = new TurnoService();

    public MostrarTurnosFrame() throws ParseException {
        super("Mis turnos");
        txtsub = new JTextArea(10, 20);
        titulo = new JLabel("Usted tiene asignados los siguientes turnos:");
        titulo.setFont(new Font("Arial", Font.PLAIN, 16));

        container = getContentPane();
        container.setLayout(null);
        container.add(titulo);
        container.add(txtsub);
        container.add(salir);

        setSize(600, 450);
        setLocation(0, 0);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo.setBounds(30, 50, 400, 40);
        txtsub.setBounds(50, 120, 500, 200);
        txtsub.setLineWrap(true);
        txtsub.setWrapStyleWord(true);
        txtsub.setFont(new Font("Arial", Font.PLAIN, 16));
        txtsub.setEditable(false);
        salir.setBounds(215, 350, 170, 40);
        salir.setFont(new Font("Arial", Font.PLAIN, 16));

        setVisible(true);

        salir.addActionListener(this);

        // Obtenemos ID Paciente:
        UsuarioLogeadoService service = UsuarioLogeadoService.obtenerInstancia();
        int id = service.getIdUsuarioLogeado();

        // Obtenemos Paciente:
        PacienteService pacienteService = new PacienteService();
        Paciente paciente = pacienteService.buscar(id);

        // Obtener turnos:
        SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        DateFormat date = new SimpleDateFormat("EEE MMM dd yyyy");
        DateFormat time = new SimpleDateFormat("HH:mm:ss");

        if (listaTurnos.listar(paciente) != null) {
            for (Turno a : listaTurnos.listar(paciente)) {
                Date d = formatnow.parse((a.getFechaTurno()).toString());
                txtsub.append("• Con el doctor " + a.getDocAsignado().getNombreCompleto() + " el dia " + date.format(d)
                        + " a las " + time.format(d) + "\n");
            }
        } else {
            JOptionPane.showMessageDialog(this, "No tiene turnos asignados");
        }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            setVisible(false);
        }

    }
}
