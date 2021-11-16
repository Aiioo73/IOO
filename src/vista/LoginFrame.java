package vista;
import modelo.Administrativo;
import modelo.Paciente;
import modelo.abstractions.Usuario;
import servicios.AdministrativoService;
import servicios.PacienteService;
import vista.MenuPaciente.MenuPrincipalPacienteFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Creating LoginFrame class
public class LoginFrame extends JFrame implements ActionListener {


    Container container = getContentPane();
    JLabel userLabel = new JLabel("USERNAME");
    JLabel passwordLabel = new JLabel("PASSWORD");
    JTextField userTextField = new JTextField();
    JPasswordField passwordField = new JPasswordField();
    JButton loginButton = new JButton("LOGIN");
    JButton resetButton = new JButton("RESET");
    JCheckBox showPassword = new JCheckBox("Show Password");


    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();

    }

    public void setLayoutManager() {
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        userLabel.setBounds(50, 150, 100, 30);
        passwordLabel.setBounds(50, 220, 100, 30);
        userTextField.setBounds(150, 150, 150, 30);
        passwordField.setBounds(150, 220, 150, 30);
        showPassword.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 300, 100, 30);
        resetButton.setBounds(200, 300, 100, 30);


    }

    public void addComponentsToContainer() {
        container.add(userLabel);
        container.add(passwordLabel);
        container.add(userTextField);
        container.add(passwordField);
        container.add(showPassword);
        container.add(loginButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPassword.addActionListener(this);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        String userText;
        String pwdText;
        //userText = userTextField.getText();
        //pwdText = passwordField.getText();


        if (e.getSource() == loginButton) {
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            AdministrativoService administrativoService = new AdministrativoService();
            Administrativo administrativo = administrativoService.buscar(userText);
            // Busco si es un admin
            if (administrativo != null) {
                System.out.println("administ");
                if (administrativo.checkPassword(pwdText)) {
                    // PUM Login a la vista de ADMIN
                    MainAdminFrame mf = new MainAdminFrame();
                    mf.setTitle("Admin Main");
                    mf.setVisible(true);
                    mf.setBounds(500, 65, 1280, 720);
                    mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    mf.setResizable(false);
                    return;
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }
            // Busco si es un paciente
            PacienteService pacienteService = new PacienteService();
            Paciente paciente = pacienteService.buscar(userText);

            if (paciente != null) {
                if (paciente.checkPassword(pwdText)) {
                    // PUM Login a la vista de PACIENTE
                    new MenuPrincipalPacienteFrame();
                    return;
                }else{
                    JOptionPane.showMessageDialog(this, "Invalid Username or Password");
                }
            }else{
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }
        }



        // PUMBA ERROR LOGIN

        //Coding Part of LOGIN button
        /*if (e.getSource() == loginButton) {
//            String userText;
//            String pwdText;
            userText = userTextField.getText();
            pwdText = passwordField.getText();
            if (userText.equalsIgnoreCase("usuario") && pwdText.equalsIgnoreCase("12345")) {
                MainAdminFrame mf = new MainAdminFrame();
                mf.setTitle("Admin Main");
                mf.setVisible(true);
                mf.setBounds(500,65,1280,720);
                mf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                mf.setResizable(false);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Username or Password");
            }

        }*/
        //Coding Part of RESET button
        if (e.getSource() == resetButton) {
            userTextField.setText("");
            passwordField.setText("");
        }
        //Coding Part of showPassword JCheckBox
        if (e.getSource() == showPassword) {
            if (showPassword.isSelected()) {
                passwordField.setEchoChar((char) 0);
            } else {
                passwordField.setEchoChar('*');
            }

        }
    }
}


