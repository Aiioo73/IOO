package vista;

import vista.ABM.PanelManagerABM;

import javax.swing.*;
import java.awt.*;

public class ABMPaciente {
    public static void main(String[] args) {

        //Agrego el panelManager de ABM
        PanelManagerABM panelManager = new PanelManagerABM();
        panelManager.armarManagerABM();
        panelManager.mostrarPanelLista();
        panelManager.showFrame();



    }
}
