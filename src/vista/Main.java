package vista;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {

//        GenerarInfoEjemplo();

        //Creating object of LoginFrame class and setting some of its properties
        LoginFrame frame=new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(10,10,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static void GenerarInfoEjemplo() {
        AdministrativoService test = new AdministrativoService();

        List<Administrativo> list = test.listar();

        for (Administrativo a: list) {
            System.out.println(a.getNombreCompleto());
        }

        List<Administrativo> newInfo = DummyData.generarAdministrativos();

        for (Administrativo a: newInfo) {
            test.guardar(a);
        }

        list = test.listar();

        for (Administrativo a: list) {
            System.out.println(a.getNombreCompleto());
        }
    }

    }
}
