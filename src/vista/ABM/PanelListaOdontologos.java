package vista.ABM;

import modelo.Odontologo;
import servicios.OdontologoService;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PanelListaOdontologos extends JPanel {

    private JButton btnAlta;
    private JButton btnBaja;
    private JButton btnModificar;
    private JPanel panelBotonera;  //Creo un panel para los botones

    private JTable tableOdontologos;
    private DefaultTableModel contenidoTable;  //Sirve para manejar el contenido de la tabla
    private JScrollPane scrollPane;   //Sirve para poder hacer el Scroll en la grilla.

    private PanelManagerABM panelManagerABM;

    public PanelListaOdontologos(PanelManagerABM panelManagerABM){
        this.panelManagerABM = panelManagerABM;
    }

    public void armarPanelListaOdontologos(){

        this.removeAll();
        this.setLayout(new BorderLayout());

        //Botonera
        btnAlta = new JButton("Crear Odontologo");
        btnBaja = new JButton("Eliminar Odontologo");
        btnModificar = new JButton("Modificar Odontologo");
        panelBotonera = new JPanel();
        panelBotonera.add(btnAlta);
        panelBotonera.add(btnBaja);
        panelBotonera.add(btnModificar);

        //Listado en Jtable

        scrollPane = new JScrollPane();
        contenidoTable = new DefaultTableModel();
        tableOdontologos = new JTable(contenidoTable);
        //Agrego la tabla de Odontologos al ScrollPane:
        scrollPane.setViewportView(tableOdontologos);

        OdontologoService service = new OdontologoService();
        List<Odontologo> lista = service.listar();

        contenidoTable.addColumn("Legajo");
        contenidoTable.addColumn("Nombre Completo");
        contenidoTable.addColumn("Nombre de Usuario");
        contenidoTable.addColumn("Hora Entrada");
        contenidoTable.addColumn("Hora Salida");
        contenidoTable.addColumn("Fecha de Alta");

        for(Odontologo odontologo : lista){
            Object[] row = new Object[6];
            row[0] = odontologo.getId();
            row[1] = odontologo.getNombreCompleto();
            row[2] = odontologo.getNombreUsuario();
            row[3] = odontologo.getHoraEntrada();
            row[4] = odontologo.getHoraSalida();
            row[5] = odontologo.getFechaAlta();

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
                panelManagerABM.mostrarPanelFormularioOdontologos();
            }
        });

        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtengo el valor del ID para poder saber que valor elimino del JSON

                String obtenerID = tableOdontologos.getValueAt(tableOdontologos.getSelectedRow(),0).toString();
                System.out.println(obtenerID);
                int id = Integer.valueOf(obtenerID);
                OdontologoService service = new OdontologoService();
                service.eliminar(id);
                JOptionPane.showMessageDialog(tableOdontologos,"El Odontologo fue Eliminado correctamente!","Baja de Odontologo",JOptionPane.INFORMATION_MESSAGE);
            }
        });


        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String obtenerID = tableOdontologos.getValueAt(tableOdontologos.getSelectedRow(),0).toString();
                int id = Integer.valueOf(obtenerID);
                OdontologoService service = new OdontologoService();
                panelManagerABM.mostrarPanelFormularioOdontologos(service.buscar(id));

            }
        });
    }


}
