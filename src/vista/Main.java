package vista;
import javax.swing.*;
import modelo.Administrativo;
import servicios.AdministrativoService;
import utils.DummyData;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        generarInfoEjemplo();

        //Creating object of LoginFrame class and setting some of its properties
        LoginFrame frame=new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(500,65,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }

    public static void generarInfoEjemplo() {
        AdministrativoService administrativoService = new AdministrativoService();

        List<Administrativo> list = administrativoService.listar();

        for (Administrativo a: list) {
            System.out.println(a.getNombreCompleto());
        }

        List<Administrativo> newInfo = DummyData.generarAdministrativos();

        for (Administrativo a: newInfo) {
            administrativoService.guardar(a);
        }

        list = administrativoService.listar();

        for (Administrativo a: list) {
            System.out.println(a.getNombreCompleto());
        }
    }

    }
