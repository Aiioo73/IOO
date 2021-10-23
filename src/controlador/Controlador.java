package controlador;

import vista.MainForm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    MainForm mainForm = new MainForm();

    public Controlador(MainForm mf) {
        this.mainForm = mf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
