package dao.abstractions;

import dao.Archivo;
import modelo.abstractions.Entidad;

import java.util.ArrayList;
import java.util.List;

public class BaseDAOArchivo<T extends Entidad> implements IDAO<T>{
    private String path;

    public BaseDAOArchivo() {
        this.path = this.getClass().getSimpleName() + ".txt";
    }

    @Override
    public void guardar(T entity) {
        //1 Recuperar de un archivo
        List<T> lista = listar();

        if(lista == null)
            lista = new ArrayList<>();

        int idMax = 0;
        //2 preguntar si id de la entidad es igual a cero
        if(entity.getId() == 0)
        {
            for(T p:lista) {
                if (p.getId() > idMax)
                    idMax = p.getId();
            }
            //3 agregar a persona dentro de la lista de personas
            entity.setId(idMax + 1);
            lista.add(entity);
        }else
        {
            //4 si el id es difernte de cero tengo que modificar los atributos de la persona con ese id
            for(T p:lista) {
                if(p.getId() == entity.getId())
                {
//                    p.setApellido(persona.getApellido());
//                    p.setEdad(persona.getEdad());
//                    p.setNombre(persona.getNombre());
                }
            }
        }
        //5 guardar el listado en el archivo
        Archivo archivo = new Archivo(path);
        archivo.guardar(lista);
    }

    @Override
    public void eliminar(int id) {
        //1 recuperar de un archivo
        List<T> listado = listar();
        //2 buscar en el listado de personas una persona con el id que viene por parametro

        int i = 0;
        boolean encontro = false;
        while(i < listado.size() && !encontro)
        {
            //3 si lo encontre lo elimino de la lista
            T p = listado.get(i);
            if(p.getId() == id)
            {
                listado.remove(p);
                encontro = true;
            }
            i++;
        }

        //4 guardar el listado en el archivo
        Archivo archivo = new Archivo(path);
        archivo.guardar(listado);
    }

    @Override
    public List<T> listar() {
        //1 recuperar de un archivo
        Archivo archivo = new Archivo(path);
        List lista = archivo.recuperar();

        if(lista == null)
            lista = new ArrayList<>();
        //2 retornar ese listado*/
        return lista;
    }

    @Override
    public T buscar(int id) {
        //1 recuperar de un archivo
        List<T> listado = listar();
        //2 buscar dentro de ese listado una persona con el id que viene por parametro en este metodo
        for(T p : listado) {
            //3 si lo encuentro retornar ese objeto persona.
            if (p.getId() == id)
                return p;
        }
        return null;
    }
}
