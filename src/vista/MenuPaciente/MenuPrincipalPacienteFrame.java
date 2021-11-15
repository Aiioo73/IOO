package vista.MenuPaciente;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPrincipalPacienteFrame extends JFrame implements ActionListener {
    JFrame frame;
    JButton registrarUnTurnoButton = new JButton("Registrar un turno");
    JButton mostrarMisTurnosButton = new JButton("Ver mis turnos");
    JLabel bienvenida = new JLabel("BIENVENIDO");

    public MenuPrincipalPacienteFrame() {
        setTitle("Menu Principal Paciente");

        bienvenida.setFont(new Font("Arial", Font.PLAIN, 26));
        bienvenida.setBounds(90, 60, 170, 150);
        registrarUnTurnoButton.setFont(new Font("Arial", Font.PLAIN, 16));
        registrarUnTurnoButton.setBounds(90, 195, 170, 75);
        mostrarMisTurnosButton.setBounds(90, 295, 170, 75);
        mostrarMisTurnosButton.setFont(new Font("Arial", Font.PLAIN, 16));

        registrarUnTurnoButton.addActionListener(this);
        mostrarMisTurnosButton.addActionListener(this);

        add(bienvenida);
        add(registrarUnTurnoButton);
        add(mostrarMisTurnosButton);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setSize(370, 600);
        setLayout(null);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == registrarUnTurnoButton) {
            new RegistroTurnosFrame();
        }
        if (e.getSource() == mostrarMisTurnosButton) {
            /*
             * if(TENGO TURNOS ASIGNADOS){ new MostrarTurnosFrame(); }else{
             * JOptionPane.showMessageDialog(this, "No tiene turnos asignados"); }
             */
            JOptionPane.showMessageDialog(this, "No tiene turnos asignados");
            new MostrarTurnosFrame();

        }

    }

    public static void main(String[] args) {
        new MenuPrincipalPacienteFrame();
    }
}
