package vista.ABM;

import javax.swing.*;

public class PanelManagerABM {

    private JFrame frame;
    private PanelListaPacientes panelListaPacientes;
    private PanelFormularioPacientes panelFormularioPacientes;

    public void armarManagerABM(){
        frame = new JFrame("PacientesABM");
        frame.setBounds(100,100,500,500);

        panelListaPacientes = new PanelListaPacientes(this);
        panelListaPacientes.armarPanelListaPacientes();

    }
}
