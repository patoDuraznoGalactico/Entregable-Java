package model;

import database.CRUD;
import database.ConfigDB;
import entity.Autor;

import javax.swing.*;
import javax.xml.namespace.QName;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AutorModel implements CRUD {

    @Override
    public Object insert(Object obj) {
        //1. abrimos la conexion
        Connection objConnection = ConfigDB.openConnection();

        //2. convertir el obj que llega a Autor
        Autor objAutor = (Autor) obj;
        try {
            //3. Escribir el sql
            String sql = "INSERT INTO autores (nombre,nacionalidad) VALUES (?,?);";

            //4. Preparar el statement además agregamos la propiedad RETURN_GENERATED_KEYS que hace la sentencia SQL nos retorne los id generados por la base de datos.
            PreparedStatement objPrepare = objConnection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);

            //5. Asignar valor a los ??
            objPrepare.setString(1,objAutor.getNombre());
            objPrepare.setString(2,objAutor.getNacionalidad());

            //6. Ejecutar el Query
            objPrepare.execute();

            //7. Obtener el resultado con las id(Llaves generadas)
            ResultSet objRest = objPrepare.getGeneratedKeys();

            //8. Iterar mientras hay un registro
            while (objRest.next()){
                //Podemos obtener el valor tambien con indices
                objAutor.setId(objRest.getInt(1));
            }
            JOptionPane.showMessageDialog(null, "Coder insertion was successful.");
        }catch (SQLException e){
            System.out.println("ERROR"+ e.getMessage());
        }
        ConfigDB.closeConnection();
        return objAutor;
    }

    @Override
    public List<Object> findAll() {
        //1. crear una lista para guardar lo que nos devuelve la base de datos..
        List<Object> listAutor = new ArrayList<>();

        //2. Abrir la conexion..
        Connection objConnection = ConfigDB.openConnection();
        try {
            //3. Escribimos el query en sql
            String sql = "SELECT * FROM autores;";
            //4. Usar el prepareStatement...
            PreparedStatement objPrepare = objConnection.prepareStatement(sql);
            //5. Ejecutar el query y obtener el resultado (ResultSet)
            ResultSet objResult = objPrepare.executeQuery();

            //6. Mientras haya un resultado siguiente hacer:
            while (objResult.next()){
                //6.1 Crear un Autor...
                Autor objAutor = new Autor();
                //6.2 Llenar el obj con la información de la base de datos del obj iterado
                objAutor.setNombre(objResult.getString("nombre"));
                objAutor.setNacionalidad(objResult.getString("nacionalidad"));
                objAutor.setId(objResult.getInt("id"));

                //6.3 Agregamos el Autor a la lista
                listAutor.add(objAutor);
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        ConfigDB.closeConnection();
        return listAutor;
    }

    @Override
    public boolean update(Object obj) {
        return false;
    }

    @Override
    public boolean delete(Object obj) {
        return false;
    }
}
