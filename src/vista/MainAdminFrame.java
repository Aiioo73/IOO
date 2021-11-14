package vista;

import vista.ABM.PanelFormularioPacientes;
import vista.ABM.PanelListaPacientes;
import vista.ABM.PanelManagerABM;
import vista.ABMPaciente;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainAdminFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton odontologosButton = new JButton("Odontologos");
    JButton pacienteButton = new JButton("Pacientes");
    JButton adminButton = new JButton("Administradores");
    JButton turnosButton = new JButton("Turnos Semanales");
    JButton registroTurnoButton = new JButton("Registrar Turno");



    MainAdminFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
    }

    public void setAdminTable(){
        AdminTable at = new AdminTable();
        at.createAndShowGUI();
    }

    public void setPacienteTable(){
        PanelManagerABM panelManager = new PanelManagerABM();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        registroTurnoButton.setBounds(50, 25, 140, 30);
        pacienteButton.setBounds(180, 25, 130, 30);
        adminButton.setBounds(310, 25, 130, 30);
        odontologosButton.setBounds(440, 25, 130, 30);
        turnosButton.setBounds(570, 25, 140, 30);

    }

    public void addComponentsToContainer() {
        container.add(odontologosButton);
        container.add(pacienteButton);
        container.add(adminButton);
        container.add(turnosButton);
        container.add(registroTurnoButton);
    }

    public void addActionEvent() {
        odontologosButton.addActionListener(this);
        pacienteButton.addActionListener(this);
        turnosButton.addActionListener(this);
        //showPassword.addActionListener(this);
    }





    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == pacienteButton) {
            setPacienteTable();
        }
        if (e.getSource() == turnosButton) {
            setAdminTable();
        }
    }


}
