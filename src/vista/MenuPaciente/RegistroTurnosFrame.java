package vista.MenuPaciente;

import servicios.OdontologoService;
import servicios.TurnoService;
import java.awt.*;
import javax.swing.*;
import modelo.Odontologo;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RegistroTurnosFrame extends JFrame implements ActionListener {
    JFrame frame = new JFrame(" ");
    JComboBox<String> comboOdontologos, comboDias, comboHorarios;
    JTextArea txtsub;
    Container container;
    JLabel seleccionOdontologo, seleccionDia, seleccionHorario;
    JButton continuar = new JButton("Continuar");
    OdontologoService listaOdontologos = new OdontologoService();
    TurnoService listaTurnos = new TurnoService();
    String turnoSeleccionado;

    public RegistroTurnosFrame() {
        super("Registrar un turno");
        txtsub = new JTextArea(20, 20);

        comboOdontologos = new JComboBox<String>();
        comboDias = new JComboBox<String>();
        comboHorarios = new JComboBox<String>();

        seleccionOdontologo = new JLabel("Seleccione su odontologo:");
        seleccionOdontologo.setFont(new Font("Arial", Font.PLAIN, 16));
        seleccionDia = new JLabel("Seleccione un dia de la semana:");
        seleccionDia.setFont(new Font("Arial", Font.PLAIN, 16));
        seleccionHorario = new JLabel("Seleccione el horario:");
        seleccionHorario.setFont(new Font("Arial", Font.PLAIN, 16));

        container = getContentPane();
        container.setLayout(null);
        container.add(seleccionOdontologo);
        container.add(seleccionHorario);
        container.add(seleccionDia);
        container.add(comboOdontologos);
        container.add(comboDias);
        container.add(comboHorarios);
        container.add(txtsub);
        container.add(continuar);

        setSize(600, 450);
        setLocation(0, 0);
        setResizable(false);
        setLayout(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        seleccionOdontologo.setBounds(30, 50, 250, 40);
        comboOdontologos.setBounds(290, 50, 250, 35);
        seleccionDia.setBounds(30, 120, 250, 40);
        comboDias.setBounds(290, 120, 250, 35);
        seleccionHorario.setBounds(30, 190, 250, 40);
        comboHorarios.setBounds(290, 190, 250, 35);
        txtsub.setBounds(50, 250, 500, 70);
        txtsub.setLineWrap(true);
        txtsub.setWrapStyleWord(true);
        txtsub.setFont(new Font("Arial", Font.PLAIN, 16));
        continuar.setBounds(215, 350, 170, 40);
        continuar.setFont(new Font("Arial", Font.PLAIN, 16));

        for (Odontologo odontologo : listaOdontologos.listar()) {
            comboOdontologos.addItem(odontologo.getNombreCompleto());
            List<Date> dias = listaTurnos.obtenerDisponibilidad(odontologo);

            for (Date dia : dias) {
                try {
                    SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
                    DateFormat date = new SimpleDateFormat("EEE MMM dd yyyy");
                    DateFormat time = new SimpleDateFormat("HH:mm:ss");
                    Date d = formatnow.parse(dia.toString());

                    // para no repetir los dias
                    boolean exists1 = false;
                    for (int index = 0; index < comboDias.getItemCount() && !exists1; index++) {
                        if ((date.format(d)).equals(comboDias.getItemAt(index))) {
                            exists1 = true;
                        }
                    }
                    if (!exists1) {
                        comboDias.addItem(date.format(d));
                    }

                    // para no repetir los horarios
                    boolean exists2 = false;
                    for (int index = 0; index < comboHorarios.getItemCount() && !exists2; index++) {
                        if ((time.format(d)).equals(comboHorarios.getItemAt(index))) {
                            exists2 = true;
                        }
                    }
                    if (!exists2) {
                        comboHorarios.addItem(time.format(d));
                    }

                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        }

        comboOdontologos.addActionListener(this);
        comboOdontologos.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = comboOdontologos.getSelectedItem().toString();
                    String str1 = comboDias.getSelectedItem().toString();
                    String str2 = comboHorarios.getSelectedItem().toString();
                    setLabelText(str, str1, str2);
                }
            }
        });

        comboDias.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = comboOdontologos.getSelectedItem().toString();
                    String str1 = comboDias.getSelectedItem().toString();
                    String str2 = comboHorarios.getSelectedItem().toString();
                    setLabelText(str, str1, str2);
                }
            }
        });

        comboHorarios.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    String str = comboOdontologos.getSelectedItem().toString();
                    String str1 = comboDias.getSelectedItem().toString();
                    String str2 = comboHorarios.getSelectedItem().toString();
                    setLabelText(str, str1, str2);
                }
            }
        });

        continuar.addActionListener(this);

        comboOdontologos.putClientProperty("JComboBox.isTableCellEditor", Boolean.TRUE);
        comboDias.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        comboHorarios.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4

    }

    private void setLabelText(String str1, String str2, String str3) {
        String textForLabel = "";
        String helpStringFirst = str1.trim();
        if (helpStringFirst != null && helpStringFirst.length() > 0) {
            if (!helpStringFirst.equals("-")) {
                textForLabel = "Para su turno, usted ha seleccionado el odontologo " + helpStringFirst;
            } else {
                textForLabel = "Odontologo desconocido :   ";
            }
        }
        String helpStringSecond = str2.trim();
        if (helpStringSecond != null && helpStringSecond.length() > 0) {
            if (!helpStringSecond.equals("-")) {
                textForLabel = textForLabel + " el dia " + helpStringSecond;
            } else {
                textForLabel += " un dia desconocido ";
            }
        }
        String helpStringThird = str3.trim();
        if (helpStringThird != null && helpStringThird.length() > 0) {
            if (!helpStringThird.equals("-")) {
                textForLabel = textForLabel + " en el horario " + helpStringThird;
            } else {
                textForLabel += " un horario desconocido ";
            }
        }
        txtsub.setText(textForLabel);
        turnoSeleccionado = helpStringFirst + "-" + helpStringSecond + "-" + helpStringThird;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continuar) {
            JOptionPane.showMessageDialog(this, "¿Registrar turno?");
            // GUARDAR EN BD turnoSeleccionado!!!!!!!!!
            setVisible(false);
        }

    }
}