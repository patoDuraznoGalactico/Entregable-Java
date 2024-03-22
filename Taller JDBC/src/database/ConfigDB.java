package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

//Esta clase se encarga de establecer y cerrar la base de datos
public class ConfigDB {

    //este atributo contiene el estado de la conexion
    public static Connection objConnection = null;

    //Metodo para conectar la DB
    public static Connection openConnection(){
        try {
            //llamamos al driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //Creamos las varibles de conexion
            String url = "jdbc:mysql://bmum8kwcr5tznr5tkstf-mysql.services.clever-cloud.com:3306/bmum8kwcr5tznr5tkstf";
            String user = "u8kbsukrnpsqrrkq";
            String password = "v4nFk6SOgtD56Id3ctEj";

            //Establecer conexion
            objConnection = (Connection) DriverManager.getConnection(url,user,password);
            System.out.println("Me conecte, satisfactoriamente ;)");
        }catch (ClassNotFoundException e){
            System.out.println("ERROR >> DRIVER NO INSTALADO"+e.getMessage());
        }catch (SQLException e){
            System.out.println("ERROR >> Error al conectarse a la base de datos"+e.getMessage());
        }
        return objConnection;
    }

    public static void closeConnection(){
        try {
            if (objConnection != null){
                objConnection.close();
                System.out.println("Conexion cerrada correctamente");
            }
        }catch (SQLException e){
            System.out.println("ERROR: "+e.getMessage());
        }
    }
}
