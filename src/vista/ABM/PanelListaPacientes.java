package vista.ABM;

import modelo.Paciente;
import servicios.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListaPacientes extends JPanel {

    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JPanel panelBotonera;  //Creo un panel para los botones

    private JTable tablePacientes;
    private DefaultTableModel contenidoTable;  //Sirve para manejar el contenido de la tabla
    private JScrollPane scrollPane;   //Sirve para poder hacer el Scroll en la grilla.

    private PanelManagerABM panelManagerABM;

    public PanelListaPacientes(PanelManagerABM panelManagerABM){
        this.panelManagerABM = panelManagerABM;
    }

    public void armarPanelListaPacientes(){

        this.removeAll();

        this.setLayout(new BorderLayout());

        //Botonera
        btnAlta = new JButton("Crear Usuario");
        btnBaja = new JButton("Eliminar Usuario");
        btnModificar = new JButton("Modificar Usuario");
        panelBotonera = new JPanel();
        panelBotonera.add(btnAlta);
        panelBotonera.add(btnBaja);
        panelBotonera.add(btnModificar);

        //Listado en Jtable

        scrollPane = new JScrollPane();
        contenidoTable = new DefaultTableModel();
        tablePacientes = new JTable(contenidoTable);
        //Agrego la tabla de pacientes al ScrollPane:
        scrollPane.setViewportView(tablePacientes);

        // ------------------------------------------------------------------------//
        PacienteService service = new PacienteService();
        List<Paciente> lista = service.listar();

        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre Completo");
        contenidoTable.addColumn("Nombre de Usuario");
        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("Fecha de Alta");

        for(Paciente paciente : lista){
            Object[] row = new Object[5];
            row[0] = paciente.getId();
            row[1] = paciente.getNombreCompleto();
            row[2] = paciente.getNombreUsuario();
            row[3] = paciente.getDni();
            row[4] = paciente.getFechaAlta();

            contenidoTable.addRow(row);
        }

        // ------------------------------------------------------------------------//


        //Muestro la tabla y el panel:
        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);





        //Eventos
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario:
                panelManagerABM.mostrarPanelFormularioPacientes();
            }
        });


        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtengo el valor del ID para poder saber que valor elimino del JSON

                String obtenerID = tablePacientes.getValueAt(tablePacientes.getSelectedRow(),0).toString();
                System.out.println(obtenerID);
                int id = Integer.valueOf(obtenerID);
                service.eliminar(id);
                JOptionPane.showMessageDialog(tablePacientes,"El Paciente fue Eliminado correctamente!","Baja de Paciente",JOptionPane.INFORMATION_MESSAGE);
                panelManagerABM.mostrarPanelListaPacientes();
           }
        });


        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String obtenerID = tablePacientes.getValueAt(tablePacientes.getSelectedRow(),0).toString();
                int id = Integer.valueOf(obtenerID);
                PacienteService pacienteService = new PacienteService();
                panelManagerABM.mostrarPanelFormularioPacientes(pacienteService.buscar(id));

                //No está funcionando, está creando un nuevo ID.
            }
        });

    }
}
