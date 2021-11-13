package vista;

import servicios.OdontologoService;
import java.awt.*;
import javax.swing.*;

import modelo.Odontologo;

import java.awt.event.*;
import java.text.ParseException;

public class ComboOdontologosFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame(" ");
    JComboBox<String> comboOdontologos, cb2;
    JTextField txtsub;
    Container container;
    JLabel seleccionOdontologo, sub;
    JButton continuar = new JButton("Continuar");
    OdontologoService listaOdontologos = new OdontologoService();

    public ComboOdontologosFrame() {
        super("Registrar un turno");
        txtsub = new JTextField(20);
        comboOdontologos = new JComboBox<String>();
        seleccionOdontologo = new JLabel("Seleccione su odontologo preferido:");
        seleccionOdontologo.setFont(new Font("Arial", Font.PLAIN, 15));
        sub = new JLabel("Usted ha seleccionado:");
        sub.setFont(new Font("Arial", Font.PLAIN, 16));
        container = getContentPane();
        container.setLayout(null);
        container.add(seleccionOdontologo);
        container.add(comboOdontologos);
        container.add(txtsub);
        container.add(sub);
        container.add(continuar);

        setSize(600, 300);
        setLocation(0, 0);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seleccionOdontologo.setBounds(30, 50, 250, 40);
        comboOdontologos.setBounds(290, 50, 250, 35);
        sub.setBounds(115, 100, 250, 40);
        txtsub.setBounds(290, 100, 250, 35);
        continuar.setBounds(215, 180, 170, 40);
        continuar.setFont(new Font("Arial", Font.PLAIN, 16));

        for (Odontologo odontologo : listaOdontologos.listar()) {
            comboOdontologos.addItem(odontologo.getNombreCompleto());

        }

        continuar.addActionListener(this);

        comboOdontologos.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent event) {
                if (event.getStateChange() == ItemEvent.SELECTED) {
                    try {
                        String no = comboOdontologos.getSelectedItem().toString();
                        txtsub.setText(no);
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continuar) {
            JOptionPane.showMessageDialog(this, "Continuar hacia selección de fecha para su turno");
            try {
                new CombosTurnosFrame();
                setVisible(false);
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }

        }

    }
}