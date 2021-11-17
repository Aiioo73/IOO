package vista.MenuPaciente;

import servicios.OdontologoService;
import servicios.PacienteService;
import servicios.TurnoService;
import servicios.UsuarioLogeadoService;

import java.awt.*;
import javax.swing.*;
import modelo.Odontologo;
import modelo.Paciente;
import modelo.Turno;

import java.awt.event.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class RegistroTurnosFrame extends JFrame implements ActionListener {
    private static final String NOT_SELECTABLE_OPTION = " - Seleccione una opcion - ";
    JComboBox<String> comboOdontologos, comboDias, comboHorarios;
    JTextArea txtsub;
    Container container;
    JLabel seleccionOdontologo, seleccionDia, seleccionHorario;
    JButton continuar = new JButton("Continuar");
    OdontologoService odontologoService = new OdontologoService();
    TurnoService turnoService = new TurnoService();
    String turnoSeleccionado = "";
    String str, str1, str2;

    public RegistroTurnosFrame() {
        super("Registrar un turno");
        txtsub = new JTextArea(20, 20);

        comboOdontologos = new JComboBox<String>();
        setDefault(comboOdontologos);
        comboDias = new JComboBox<String>();
        setDefault(comboDias);
        comboHorarios = new JComboBox<String>();
        setDefault(comboHorarios);

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

        for (Odontologo odontologo : odontologoService.listar()) {
            comboOdontologos.addItem(odontologo.getNombreCompleto());
        }

        comboOdontologos.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    llenarLosDiasDelOdontologo();
                }
            }
        });

        comboDias.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    llenarLosHorariosDelOdontologo(e.getItem().toString());
                }
            }
        });

        comboHorarios.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if ((e.getStateChange() == ItemEvent.SELECTED)) {
                    str = comboOdontologos.getSelectedItem().toString();
                    str1 = comboDias.getSelectedItem().toString();
                    str2 = comboHorarios.getSelectedItem().toString();
                    setLabelText(str, str1, str2);
                }
            }
        });

        continuar.addActionListener(this);

        comboDias.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4
        comboHorarios.setPrototypeDisplayValue("XXXXXXXXXX"); // JDK1.4

    }

    private void llenarLosHorariosDelOdontologo(String diaSeleccionadoString) {
        str = comboOdontologos.getSelectedItem().toString();
        Odontologo odontologo = odontologoService.buscar(str);

        List<Date> horarios = turnoService.obtenerDisponibilidad(odontologo);

        // Filtrar horarios por el día seleccionado

        SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
        DateFormat time = new SimpleDateFormat("HH:mm:ss");
        DateFormat date = new SimpleDateFormat("EEE MMM dd yyyy");
        Date d;

        for (Date horario : horarios) {
            try {
                d = formatnow.parse(horario.toString());
                String diaDelHorario = date.format(d);
                if (diaSeleccionadoString.equals(diaDelHorario)) {
                    comboHorarios.addItem(time.format(d));
                }
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }

        str = comboOdontologos.getSelectedItem().toString();
        str1 = comboDias.getSelectedItem().toString();
        str2 = comboHorarios.getSelectedItem().toString();
        setLabelText(str, str1, str2);
    }

    private void llenarLosDiasDelOdontologo() {
        str = comboOdontologos.getSelectedItem().toString();
        Odontologo odontologo = odontologoService.buscar(str);

        List<Date> dias = turnoService.obtenerDisponibilidad(odontologo);

        for (Date dia : dias) {
            SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.ENGLISH);
            DateFormat date = new SimpleDateFormat("EEE MMM dd yyyy");
            Date d;
            try {
                d = formatnow.parse(dia.toString());
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
            } catch (ParseException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        }
        str1 = comboDias.getSelectedItem().toString();

    }

    private void setDefault(JComboBox<String> comboBox) {
        comboBox.setModel(new DefaultComboBoxModel<String>() {
            private static final long serialVersionUID = 1L;
            boolean selectionAllowed = true;

            @Override
            public void setSelectedItem(Object anObject) {
                if (!NOT_SELECTABLE_OPTION.equals(anObject)) {
                    super.setSelectedItem(anObject);
                } else if (selectionAllowed) {
                    // Allow this just once
                    selectionAllowed = false;
                    super.setSelectedItem(anObject);
                }
            }
        });

        comboBox.addItem(NOT_SELECTABLE_OPTION);

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

    public void guardarTurno() {
        // Obtenemos ID Paciente:
        UsuarioLogeadoService service = UsuarioLogeadoService.obtenerInstancia();
        int id = service.getIdUsuarioLogeado();

        // Obtenemos Paciente:
        PacienteService pacienteService = new PacienteService();
        Paciente paciente = pacienteService.buscar(id);

        String[] parametrosParaTurno = turnoSeleccionado.split("-");
        String stringOdontologo = parametrosParaTurno[0];
        String stringDia = parametrosParaTurno[1];
        String stringHora = parametrosParaTurno[2];
        Odontologo odontologo = odontologoService.buscar(stringOdontologo);

        String fechaUnida = stringDia + " " + stringHora;
        SimpleDateFormat formatnow = new SimpleDateFormat("EEE MMM dd yyyy HH:mm:ss");
        Date fecha;
        try {
            fecha = formatnow.parse(fechaUnida);
            Turno turno = new Turno(odontologo, paciente, fecha);
            turnoService.guardar(turno);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == continuar) {
            JOptionPane.showMessageDialog(this, "¿Registrar turno?");
            guardarTurno();
            setVisible(false);
        }

    }
}