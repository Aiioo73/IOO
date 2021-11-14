package vista.ABM;

import modelo.Paciente;

import javax.swing.*;

public class PanelManagerABM {

    private JFrame frame;
    private PanelListaPacientes panelListaPacientes;
    private PanelFormularioPacientes panelFormularioPacientes;

    public void armarManagerABM() {
        frame = new JFrame("PacientesABM");
        frame.setBounds(100, 100, 500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        panelListaPacientes = new PanelListaPacientes(this);
        panelListaPacientes.armarPanelListaPacientes();

    }

    public void mostrarPanelLista() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelListaPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();
    }

    public void mostrarPanelFormulario() {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void mostrarPanelFormulario(Paciente paciente){
        panelFormularioPacientes.llenarFormulario(paciente);
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panelFormularioPacientes);
        frame.getContentPane().validate();
        frame.getContentPane().repaint();

    }

    public void showFrame(){
        frame.setVisible(true);
    }

}
