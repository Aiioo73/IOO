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
    //JCheckBox showPassword = new JCheckBox("Show Password");



    MainAdminFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();
        setAdminTable();
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

    }

    public void addComponentsToContainer() {
        container.add(odontologosButton);
        container.add(pacienteButton);
        container.add(adminButton);
    }

    public void addActionEvent() {
        odontologosButton.addActionListener(this);
        pacienteButton.addActionListener(this);
        //showPassword.addActionListener(this);
    }





    public void actionPerformed(ActionEvent e) {
        //Coding Part of LOGIN button
        if (e.getSource() == odontologosButton) {
            String userText;
            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("usuario") && pwdText.equalsIgnoreCase("12345")) {
                JOptionPane.showMessageDialog(this, "Login Successful");
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }
        //Coding Part of RESET button
        if (e.getSource() == pacienteButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        /*if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }*/
    }


}
