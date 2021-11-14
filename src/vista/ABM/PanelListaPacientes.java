package vista.ABM;

import modelo.Domicilio;
import modelo.Paciente;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

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
        //Listado de Pacientes (se debe recuperar del JSON)
        ArrayList<Paciente> lista = new ArrayList();
        Domicilio domicilio1 = new Domicilio("Wilde","Las Flores",221);
        lista.add(new Paciente("Jorge","PEDRITO20","Jorge Sanchez","243221343",domicilio1));

        contenidoTable.addColumn("ID");
        contenidoTable.addColumn("Nombre Completo");
        contenidoTable.addColumn("Fecha de Alta");

        for(Paciente paciente : lista){
            Object[] row = new Object[3];
            row[0] = paciente.getId();
            row[1] = paciente.getNombreCompleto();
            row[2] = paciente.getFechaAlta();

            contenidoTable.addRow(row);
        }

        // ------------------------------------------------------------------------//


        //Muestro la tabla y el panel:
        add(panelBotonera, BorderLayout.SOUTH);
        this.setVisible(true);




        //Eventos
        btnAlta.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //llamar al formulario
            }
        });


        btnBaja.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar a borrar Paciente
            }
        });


        btnModificar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Llamar al formulario de Modificaciones.
            }
        });

    }
}