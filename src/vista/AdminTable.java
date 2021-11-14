package vista;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalTime;
import java.util.Date;

public class AdminTable extends JPanel {
    private boolean DEBUG = false;

    public AdminTable() {
        super(new GridLayout(1, 0));

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
        //table.setPreferredScrollableViewportSize(new Dimension(800, 70));
        //table.setFillsViewportHeight(true);


        if (DEBUG) {
            table.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    printDebugData(table);
                }
            });
        }

        //Create the scroll pane and add the table to it.
        JScrollPane scrollPane = new JScrollPane(table);

        //Add the scroll pane to this panel.
        add(scrollPane);
    }

    private void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();

        System.out.println("Value of data: ");
        for (int i = 0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j = 0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }

    public void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Turnos Semanales");
        //frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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