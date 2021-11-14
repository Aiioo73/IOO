package vista.ABM;

import modelo.Odontologo;
import modelo.Paciente;

import javax.swing.*;

public class PanelManagerABM {

    private JFrame frame;
    private PanelListaPacientes panelListaPacientes;
    private PanelFormularioPacientes panelFormularioPacientes;
    private PanelListaOdontologos panelListaOdontologos;
    private PanelFormularioOdontologos panelFormularioOdontologos;

    public void armarManagerABM() {
        frame = new JFrame("PacientesABM");
        frame.setBounds(650,65,640,360);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelListaPacientes = new PanelListaPacientes(this);
        panelListaPacientes.armarPanelListaPacientes();

    }

    // ----------------- Paneles para Pacientes ----------------
    public void mostrarPanelListaPacientes() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelListaPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelFormularioPacientes() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }
    //Debo sobrecargarlo para poder recuperar un Paciente y mostrarlo al momento de "modificar".
    public void mostrarPanelFormularioPacientes(Paciente paciente){
        panelFormularioPacientes.llenarFormulario(paciente);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }


    // ----------------- Paneles para Odontologos ----------------

    public void mostrarPanelListaOdontologos() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelListaOdontologos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelFormularioOdontologos() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioOdontologos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }
    //Debo sobrecargarlo para poder recuperar un Paciente y mostrarlo al momento de "modificar".
    public void mostrarPanelFormularioOdontologos(Odontologo odontologo){
        panelFormularioOdontologos.llenarFormulario(odontologo);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioOdontologos);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    // ----------------- Paneles para  ----------------



    public void showFrame(){
        frame.setVisible(true);
    }

}
