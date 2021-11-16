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

        //Date hoy = DateUtils.cleanTime(new Date());
        Date semana = DateUtils.addDays(DateUtils.cleanTime(new Date()), 7);
        TurnoService ts = new TurnoService();
        List<Turno> listaTurnos = ts.listar(semana);
        System.out.println(listaTurnos.get(0).getDocAsignado().getNombreCompleto());

        String[] columnNames = {"Odontologo",
                "Paciente",
                "Dia y Hora"};
        String[][] data = new String[listaTurnos.size()][4];
        int f = 0;
        int c = 0;
        while (f < listaTurnos.size()){
            for (int i = 0; i < listaTurnos.size(); i++) {
                data[f][c] = listaTurnos.get(i).getDocAsignado().getNombreCompleto();
                data[f][c + 1] = listaTurnos.get(i).getPaciente().getNombreCompleto();
                data[f][c + 2] = listaTurnos.get(i).getFechaTurno().toString().substring(0, listaTurnos.get(i).getFechaTurno().toString().length() - 9);
                f++;
            }
        }

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