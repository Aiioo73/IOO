package dao;


import com.google.gson.Gson;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Archivo<T> {

    private String path;

    public Archivo(String path)
    {
        this.path = path;
    }

    public void guardar(List listado)
    {
        File myObj = new File(path);

        if (myObj.exists()) {
            myObj.delete();
        }

        try {
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String json = new Gson().toJson(listado);

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(json);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List recuperar(Class<T[]> cls)
    {
        checkearExistencia(path);

        File myObj = new File(path);
        Scanner myReader = null;
        String data = null;
        try {
            myReader = new Scanner(myObj);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        while (myReader.hasNextLine()) {
            data = myReader.nextLine();
        }
        myReader.close();

        return new ArrayList<T>(Arrays.asList(new Gson().fromJson(data, cls)));
    }

    private void checkearExistencia(String path) {
        File myObj = new File(path);

        if (myObj.exists()) {
            return;
        }

        try {
            myObj.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        List list = new ArrayList();
        String json = new Gson().toJson(list);

        try {
            FileWriter myWriter = new FileWriter(path);
            myWriter.write(json);
            myWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
