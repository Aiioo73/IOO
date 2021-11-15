package vista.ABM;

import modelo.Administrativo;
import modelo.Domicilio;
import servicios.AdministrativoService;
import utils.SpringUtilities;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PanelFormularioAdministrativos extends JPanel {

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
    private JTextField txtNombreCompleto;
    private JTextField txtDNI;
    private JTextField txtLocalidad;
    private JTextField txtcalle;
    private JTextField txtAltura;
    private JTextField txtNombreDeUsuario;
    private JPanel panelComponentes;


    public PanelFormularioAdministrativos(PanelManagerABM panelManagerABM){
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

        txtNombreCompleto = new JTextField(8);
        txtDNI = new JTextField(8);
        txtLocalidad = new JTextField(8);
        txtcalle = new JTextField(8);
        txtAltura = new JTextField(8);
        txtNombreDeUsuario = new JTextField(8);

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

        SpringLayout springLayout = new SpringLayout();
        panelComponentes.setLayout(springLayout);
        SpringUtilities.makeCompactGrid(panelComponentes,6,2);

        this.setVisible(true);
        add(panelBotonera, BorderLayout.SOUTH);
        add(panelComponentes, BorderLayout.CENTER);



        btnGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Guardar en Base de datos
                Administrativo administrativo = new Administrativo();
                administrativo.setNombreCompleto(txtNombreCompleto.getText());
                administrativo.setDni(txtDNI.getText());

                Domicilio domicilio = new Domicilio();
                domicilio.setLocalidad(txtLocalidad.getText());
                domicilio.setCalle(txtcalle.getText());
                domicilio.setAltura(Integer.parseInt(txtAltura.getText()));
                administrativo.setDomicilio(domicilio);

                administrativo.setNombreUsuario(txtNombreDeUsuario.getText());


                AdministrativoService administrativoService = new AdministrativoService();
                administrativoService.guardar(administrativo);




                System.out.println("Se grabo en la base de datos");
                JOptionPane.showMessageDialog(panelComponentes,"Se guardaron los datos del Administrativo","Alta de Administrativo",JOptionPane.INFORMATION_MESSAGE);
                panelManagerABM.mostrarPanelListaAdministrativos();
            }
        });

        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panelManagerABM.mostrarPanelListaAdministrativos();
            }
        });

    }


    public void llenarFormulario(Administrativo administrativo) {
        txtNombreCompleto.setText(administrativo.getNombreCompleto());
        txtDNI.setText(administrativo.getDni());
        txtLocalidad.setText(administrativo.getDomicilio().getLocalidad());
        txtcalle.setText(administrativo.getDomicilio().getCalle());
        String Altura = Integer.valueOf(administrativo.getDomicilio().getAltura()).toString();
        txtAltura.setText(Altura);
        txtNombreDeUsuario.setText(administrativo.getNombreUsuario());
    }
}
