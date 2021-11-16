package vista.MenuPaciente;

import javax.swing.*;

import modelo.Odontologo;
import modelo.Paciente;
import modelo.Turno;
import servicios.PacienteService;
import servicios.TurnoService;
import servicios.UsuarioLogeadoService;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MostrarTurnosFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame(" ");
    JTextArea txtsub;
    Container container;
    JLabel titulo;
    JButton salir = new JButton("Salir");
    public TurnoService listaTurnos = new TurnoService();

    public MostrarTurnosFrame() {
        super("Mis turnos");
        txtsub = new JTextArea(100, 100);

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
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        titulo.setBounds(30, 50, 400, 40);
        txtsub.setBounds(50, 120, 500, 200);
        txtsub.setLineWrap(true);
        txtsub.setWrapStyleWord(true);
        txtsub.setFont(new Font("Arial", Font.PLAIN, 16));
        salir.setBounds(215, 350, 170, 40);
        salir.setFont(new Font("Arial", Font.PLAIN, 16));

        salir.addActionListener(this);

        // Obtenemos ID Paciente:
        UsuarioLogeadoService service = UsuarioLogeadoService.obtenerInstancia();
        int id = service.getIdUsuarioLogeado();

        // Obtenemos Paciente:
        PacienteService pacienteService = new PacienteService();
        Paciente paciente = pacienteService.buscar(id);

        // Obtener turnos:
        List<Turno> listado = this.listaTurnos.listar(paciente);




        for(Turno a : listaTurnos.listar(paciente)){ txtsub.append(a + "\n"); }

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            setVisible(false);
        }

    }
}
