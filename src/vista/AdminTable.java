package vista;
import modelo.Turno;
import servicios.TurnoService;
import utils.DateUtils;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.GridLayout;
import java.util.Date;
import java.util.List;


public class AdminTable extends JPanel {

    public AdminTable() {
        super(new GridLayout(1, 0));

        Date hoy = DateUtils.cleanTime(new Date());
        TurnoService ts = new TurnoService();
        List<Turno> listaTurnos = ts.listar(hoy);
        System.out.println(listaTurnos);

        String[] columnNames = {"Odontologo",
                "Paciente",
                "Dia",
                "Hora"};

        Object[][] data = {
                {"Arturo Garraham", "Leandro Silva",
                        "16-11-2021", "14:00"},
                {"Arturo Garraham", "Hernan Caire",
                        "16-11-2021", "15:00"}
        };

        final JTable table = new JTable(data, columnNames);
        table.setBounds(500,55,1280,720);

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Turnos Semanales");
        frame.setBounds(600,180,1280,720);
        //Create and set up the content pane.
        AdminTable newContentPane = new AdminTable();
        newContentPane.setOpaque(true); //content panes must be opaque
        frame.setContentPane(newContentPane);

        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }
}