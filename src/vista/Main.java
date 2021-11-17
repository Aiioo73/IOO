package vista;

import utils.Ejemplos;

public class Main {

    public static void main(String[] args) {

        Ejemplos.generarInfoEjemplo();
        Ejemplos.generarTurno();

        // Creating object of LoginFrame class and setting some of its properties
        new LoginFrame();
    }

}
