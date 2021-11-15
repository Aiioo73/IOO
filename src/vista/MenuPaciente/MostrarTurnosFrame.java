package vista.MenuPaciente;

import javax.swing.*;

import modelo.Odontologo;
import modelo.Paciente;
import modelo.Turno;
import servicios.TurnoService;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MostrarTurnosFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame(" ");
    JTextArea txtsub;
    Container container;
    JLabel titulo;
    JButton salir = new JButton("Salir");
    TurnoService listaTurnos = new TurnoService();

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

        /*
         * for(Turno a : listaTurnos.listar(paciente)){ txtsub.append(a + "\n"); }
         */
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == salir) {
            setVisible(false);
        }

    }
}
