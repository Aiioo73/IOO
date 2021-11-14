package vista.ABM;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
        tableOdontologos = new JTable(contenidoTable);
        //Agrego la tabla de Odontologos al ScrollPane:
        scrollPane.setViewportView(tableOdontologos);


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

    }


}
