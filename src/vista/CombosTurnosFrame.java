package vista;

import java.awt.*;
import javax.swing.*;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class CombosTurnosFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame(" ");
    JComboBox<Date> comboDias;
    Container container;
    JLabel seleccionFecha;
    JButton continuar = new JButton("Continuar");

    public CombosTurnosFrame() throws ParseException {
        super("Registrar un turno");
        comboDias = new JComboBox<Date>();
        seleccionFecha = new JLabel("Seleccione una fecha:");
        seleccionFecha.setFont(new Font("Arial", Font.PLAIN, 16));
        container = getContentPane();
        container.setLayout(null);
        container.add(seleccionFecha);
        container.add(comboDias);
        container.add(continuar);

        setSize(600, 300);
        setLocation(0, 0);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        seleccionFecha.setBounds(50, 50, 250, 40);
        comboDias.setBounds(220, 50, 250, 35);
        continuar.setBounds(215, 180, 170, 40);
        continuar.setFont(new Font("Arial", Font.PLAIN, 16));

        for (Date fecha : obtenerFechas()) {
            // DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            // String ds = formatter.format(fecha);
            comboDias.addItem(fecha);
        }

        continuar.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continuar) {
            JOptionPane.showMessageDialog(this, "Falta terminar esto");

        }

    }

    private ArrayList<Date> obtenerFechas() throws ParseException {
        ArrayList<Date> dates = new ArrayList<Date>();

        String str_date = "14/11/2021";
        String end_date = "21/11/2021";

        DateFormat formatter;

        formatter = new SimpleDateFormat("dd/MM/yyyy");
        Date startDate = (Date) formatter.parse(str_date);
        Date endDate = (Date) formatter.parse(end_date);
        long interval = 24 * 1000 * 60 * 60; // 1 hour in millis
        long endTime = endDate.getTime(); // create your endtime here, possibly using Calendar or Date
        long curTime = startDate.getTime();
        while (curTime <= endTime) {
            dates.add(new Date(curTime));
            curTime += interval;
        }

        return dates;
    }
}
