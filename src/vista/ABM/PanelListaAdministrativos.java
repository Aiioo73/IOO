package vista.ABM;

import modelo.Administrativo;
import servicios.AdministrativoService;

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
    //Creo un panel para los botones
    private JPanel panelBotonera;
    //Creo una tabla para manejar los datos
    private JTable tableAdministrativos;
    //Manejar el contenido de la tabla
    private DefaultTableModel contenidoTable;
    private JScrollPane scrollPane;

    public PanelListaAdministrativos(PanelManagerABM panelManagerABM){
        this.panelManagerABM = panelManagerABM;
    }

    public void armarPanelListaAdministrativos() {

        this.removeAll();

        this.setLayout(new BorderLayout());

        //Botonera
        btnAlta = new JButton("Crear Usuario Administrativo");
        btnBaja = new JButton("Eliminar Usuario Administrativo");
        btnModificar = new JButton("Modificar Usuario Administrativo");
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

        //Instancio el Service
        AdministrativoService service = new AdministrativoService();
        List<Administrativo> lista = service.listar();

        //creo la Tabla
        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre Completo");
        contenidoTable.addColumn("Nombre de Usuario");
        contenidoTable.addColumn("DNI");
        contenidoTable.addColumn("Fecha de Alta");

        for (Administrativo administrativo : lista) {
            Object[] row = new Object[5];
            row[0] = administrativo.getId();
            row[1] = administrativo.getNombreCompleto();
            row[2] = administrativo.getNombreUsuario();
            row[3] = administrativo.getDni();
            row[4] = administrativo.getFechaAlta();

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
                //Llamar al formularioAdministrativos
                panelManagerABM.mostrarPanelFormularioAdministrativos();
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtengo el valor del ID para poder saber que valor elimino.

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
                String obtenerID = tableAdministrativos.getValueAt(tableAdministrativos.getSelectedRow(),0).toString();
                int id = Integer.valueOf(obtenerID);
                AdministrativoService administrativoService = new AdministrativoService();
                panelManagerABM.mostrarPanelFormularioAdministrativos(service.buscar(id));

            }
        });

    }


}
