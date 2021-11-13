package vista;

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


        //Etiquetas:
        JLabel lblNombre = new JLabel();
        lblNombre.setText("Nombre");
        pnlABM.add(lblNombre);


        JLabel lblApellido = new JLabel();
        lblNombre.setText("Apellido");
        pnlABM.add(lblApellido);

        JLabel lbldni = new JLabel();
        lblNombre.setText("DNI");
        pnlABM.add(lbldni);

        JLabel lblusuario = new JLabel();
        lblNombre.setText("Nombre de Usuario");
        pnlABM.add(lblusuario);


        //Mensajes:
        //Usuario Creado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue creado correctamente!","Alta de Paciente",JOptionPane.INFORMATION_MESSAGE);
        //Usuario Eliminado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue eliminado correctamente!","Baja de Paciente",JOptionPane.INFORMATION_MESSAGE);
        //Usuario Modificado Correctamente
        JOptionPane.showMessageDialog(pnlABM,"El Paciente fue modificado correctamente!","Modificación de Paciente",JOptionPane.INFORMATION_MESSAGE);

    }
}
