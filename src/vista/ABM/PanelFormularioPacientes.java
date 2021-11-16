package vista.ABM;

import modelo.Domicilio;
import modelo.Paciente;
import servicios.PacienteService;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioPacientes extends JPanel {

    private PanelManagerABM panelManagerABM;

    private JButton btnGuardar;
    private JButton btnCancelar;

    private JPanel panelBotonera;

    private JLabel lblNombreCompleto;
    private JLabel lblDNI;
    private JLabel lblLocalidad;
    private JLabel lblcalle;
    private JLabel lblAltura;
    private JLabel lblNombreDeUsuario;
    private JLabel lblContraseña;

    private JTextField txtNombreCompleto;
    private JTextField txtDNI;
    private JTextField txtLocalidad;
    private JTextField txtcalle;
    private JTextField txtAltura;
    private JTextField txtNombreDeUsuario;
    private JTextField txtContraseña;

    private JPanel panelComponentes;

    private Paciente paciente = null;


    public PanelFormularioPacientes (PanelManagerABM panelManagerABM){
        this.panelManagerABM = panelManagerABM;
    }


    public void ArmarPanelFormulario(){


        setLayout(new BorderLayout());

        btnGuardar = new JButton("Guardar");
        btnCancelar = new JButton("Cancelar");
        panelBotonera = new JPanel();
        panelComponentes = new JPanel();

        panelBotonera.add(btnGuardar);
        panelBotonera.add(btnCancelar);

        lblNombreCompleto = new JLabel("Nombre Completo: ");
        lblDNI = new JLabel("DNI: ");
        lblLocalidad = new JLabel("Localidad: ");
        lblcalle = new JLabel("Calle: ");
        lblAltura = new JLabel("Altura: ");
        lblNombreDeUsuario = new JLabel("Nombre de usuario: ");
        lblContraseña = new JLabel("Contraseña: ");

        txtNombreCompleto = new JTextField(8);
        txtDNI = new JTextField(8);
        txtLocalidad = new JTextField(8);
        txtcalle = new JTextField(8);
        txtAltura = new JTextField(8);
        txtNombreDeUsuario = new JTextField(8);
        txtContraseña = new JTextField(8);


        panelComponentes.add(lblNombreCompleto);
        panelComponentes.add(txtNombreCompleto);
        panelComponentes.add(lblDNI);
        panelComponentes.add(txtDNI);
        panelComponentes.add(lblLocalidad);
        panelComponentes.add(txtLocalidad);
        panelComponentes.add(lblcalle);
        panelComponentes.add(txtcalle);
        panelComponentes.add(lblAltura);
        panelComponentes.add(txtAltura);
        panelComponentes.add(lblNombreDeUsuario);
        panelComponentes.add(txtNombreDeUsuario);
        panelComponentes.add(lblContraseña);
        panelComponentes.add(txtContraseña);


        SpringLayout springLayout = new SpringLayout();
        panelComponentes.setLayout(springLayout);
        SpringUtilities.makeCompactGrid(panelComponentes,7,2);

        this.setVisible(true);
        add(panelBotonera, BorderLayout.SOUTH);
        add(panelComponentes, BorderLayout.CENTER);

        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Checkear que los campos esten bien

                // Si el paciente ya existía
                if (paciente != null) {
                    paciente.setNombreCompleto(txtNombreCompleto.getText());
                    paciente.setDni(txtDNI.getText());
                    Domicilio domicilio = new Domicilio();
                    domicilio.setLocalidad(txtLocalidad.getText());
                    domicilio.setCalle(txtcalle.getText());
                    domicilio.setAltura(Integer.parseInt(txtAltura.getText()));
                    paciente.setDomicilio(domicilio);
                    paciente.setNombreUsuario(txtNombreDeUsuario.getText());
                }
                // Si no existia creo uno nuevo
                else {
                    paciente = new Paciente(
                            txtNombreDeUsuario.getText(),txtContraseña.getText(),
                            txtNombreCompleto.getText(),
                            txtDNI.getText(),
                            new Domicilio(
                                    txtLocalidad.getText(),
                                    txtcalle.getText(),
                                    Integer.parseInt(txtAltura.getText())
                            )
                    );

                }

                //Guardar en Base de datos
                PacienteService pacienteService = new PacienteService();
                pacienteService.guardar(paciente);
                limpiarFormulario();
                System.out.println("Se grabo en la base de datos");
                JOptionPane.showMessageDialog(panelComponentes,"Se guardaron los datos del Paciente","Alta de Paciente",JOptionPane.INFORMATION_MESSAGE);
                panelManagerABM.mostrarPanelListaPacientes();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManagerABM.mostrarPanelListaPacientes();
            }
        });

    }



    //Necesito llenar el formulario para cuando quieran modificar algo:
    public void llenarFormulario(Paciente paciente){

        this.paciente = paciente;

        txtNombreCompleto.setText(paciente.getNombreCompleto());
        txtDNI.setText(paciente.getDni());
        txtLocalidad.setText(paciente.getDomicilio().getLocalidad());
        txtcalle.setText(paciente.getDomicilio().getCalle());
        String Altura = Integer.valueOf(paciente.getDomicilio().getAltura()).toString();
        txtAltura.setText(Altura);
        txtNombreDeUsuario.setText(paciente.getNombreUsuario());

    }

    public void limpiarFormulario() {
        txtNombreCompleto.removeAll();
        txtAltura.removeAll();
        txtcalle.removeAll();
        txtDNI.removeAll();
        txtLocalidad.removeAll();
        txtNombreDeUsuario.removeAll();
    }





}
