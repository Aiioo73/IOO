package vista.ABM;

import modelo.Administrativo;
import modelo.Paciente;
import servicios.AdministrativoService;
import servicios.PacienteService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListaAdministrativos extends JPanel {

    private PanelManagerABM panelManagerABM;

    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JPanel panelBotonera;  //Creo un panel para los botones

    private JTable tableAdministrativos;
    private DefaultTableModel contenidoTable;  //Sirve para manejar el contenido de la tabla
    private JScrollPane scrollPane;   //Sirve para poder hacer el Scroll en la grilla.

    public PanelListaAdministrativos(PanelManagerABM panelManagerABM){
        this.panelManagerABM = panelManagerABM;
    }

    public void armarPanelListaAdministrativos() {

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
        tableAdministrativos = new JTable(contenidoTable);
        //Agrego la tabla de pacientes al ScrollPane:
        scrollPane.setViewportView(tableAdministrativos);

        AdministrativoService service = new AdministrativoService();
        List<Administrativo> lista = service.listar();
        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre Completo");
        contenidoTable.addColumn("Fecha de Alta");
        for (Administrativo administrativo : lista) {
            Object[] row = new Object[3];
            row[0] = administrativo.getId();
            row[1] = administrativo.getNombreCompleto();
            row[2] = administrativo.getFechaAlta();

            contenidoTable.addRow(row);
        }

        //Muestro la tabla y el panel:
        add(panelBotonera, BorderLayout.SOUTH);
        add(scrollPane, BorderLayout.CENTER);
        this.setVisible(true);


        //Eventos
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario:
                panelManagerABM.mostrarPanelFormularioAdministrativos();
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtengo el valor del ID para poder saber que valor elimino del JSON

                String obtenerID = tableAdministrativos.getValueAt(tableAdministrativos.getSelectedRow(),0).toString();
                System.out.println(obtenerID);
                int id = Integer.valueOf(obtenerID);
                service.eliminar(id);
                JOptionPane.showMessageDialog(tableAdministrativos,"El usuario Administrativo fue Eliminado correctamente!","Baja de usuario",JOptionPane.INFORMATION_MESSAGE);
                panelManagerABM.mostrarPanelListaAdministrativos();
            }
        });


        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al formulario de Modificaciones.
                //Necesito obtener datos del paciente para poder rellenar el formulario, como los consulto?

                //panelManagerABM.mostrarPanelFormulario(paciente);
            }
        });

    }


}
