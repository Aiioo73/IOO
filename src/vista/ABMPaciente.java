package vista;

import vista.ABM.PanelManagerABM;

import javax.swing.*;
import java.awt.*;

public class ABMPaciente {
    public static void main(String[] args) {

        JFrame vntABM = new JFrame("ABM Paciente");

        vntABM.setMinimumSize(new Dimension(700, 700));
        vntABM.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        vntABM.setVisible(true);
        vntABM.setLayout(new FlowLayout());

        JPanel pnlABM = new JPanel();
        pnlABM.setVisible(true);
        vntABM.add(pnlABM);
        pnlABM.setLayout(new FlowLayout());



        //Mensajes:
        //Usuario Creado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue creado correctamente!","Alta de Paciente",JOptionPane.INFORMATION_MESSAGE);
        //Usuario Eliminado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue eliminado correctamente!","Baja de Paciente",JOptionPane.INFORMATION_MESSAGE);
        //Usuario Modificado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue modificado correctamente!","Modificación de Paciente",JOptionPane.INFORMATION_MESSAGE);



        //Agrego el panelManager de ABM
        PanelManagerABM panelManager = new PanelManagerABM();
        panelManager.armarManagerABM();
        panelManager.mostrarPanelLista();
        panelManager.showFrame();
    }
}
