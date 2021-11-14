package vista;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;

public class MainAdminFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    //JLabel userLabel = new JLabel("LALA");
    //JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton odontologosButton = new JButton("Odontologos");
    JButton pacienteButton = new JButton("Pacientes");
    JButton adminButton = new JButton("Administradores");
    JButton turnosButton = new JButton("Turnos Semanales");
    //JCheckBox showPassword = new JCheckBox("Show Password");



    MainAdminFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        //setAdminTable();
    }

    public void setAdminTable(){
        AdminTable at = new AdminTable();
        at.createAndShowGUI();
    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        odontologosButton.setBounds(50, 25, 130, 30);
        pacienteButton.setBounds(180, 25, 130, 30);
        adminButton.setBounds(310, 25, 130, 30);
        turnosButton.setBounds(440, 25, 130, 30);
    }

    public void addComponentsToContainer() {
        container.add(odontologosButton);
        container.add(pacienteButton);
        container.add(adminButton);
        container.add(turnosButton);
    }

    public void addActionEvent() {
        odontologosButton.addActionListener(this);
        pacienteButton.addActionListener(this);
        turnosButton.addActionListener(this);
        //showPassword.addActionListener(this);
    }





    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == turnosButton) {
            setAdminTable();
        }

    }


}
