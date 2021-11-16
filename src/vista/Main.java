package vista;
import javax.swing.*;

import utils.Ejemplos;

public class Main {

    public static void main(String[] args) {

        Ejemplos.generarInfoEjemplo();
        Ejemplos.generarTurno();

        //Creating object of LoginFrame class and setting some of its properties
        LoginFrame frame=new LoginFrame();
        frame.setTitle("Login Form");
        frame.setVisible(true);
        frame.setBounds(500,65,370,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
    }



    }
