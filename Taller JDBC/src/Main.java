import controller.AutorController;
import database.ConfigDB;

import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        String option;
        do {
            option = JOptionPane.showInputDialog("""
                    LIBRERIA
                    
                    1. Ingresar nuevo autor.
                    2. Ingresar nuevo libro.
                    3. Consultar autor/libro.
                    4. Actualizar autor/libro.
                    5. Eliminar autor/libro.
                    
                    6. Salir.
                    """);

            switch (option){

                case "1":
                    AutorController.create();
                    break;
                case "2":
                    break;
                case "3":
                    String optio;
                    do {
                        optio = JOptionPane.showInputDialog("""
                    CONSULTAR AUTOR/LIBRO:
                    
                    1. Mostrar todos los autores.
                    2. Buscar autor por id.
                    3. Mostrar todos los libros.
                    4. Buscar libro por id.
                    5. Buscar libro por nombre.
                    6. Buscar libro por autor.
                    7. Volver al menu anterior.
                    
                    8. Salir.                    
                    """);

                        switch (optio){

                            case "1":
                                AutorController.getAll();
                                break;
                            case "2":
                                AutorController.searchById();
                                break;
                            case "3":

                                break;
                            case "4":

                                break;
                            case "5":

                                break;
                            case "6":

                                break;
                            case "7":

                                break;
                        }
                    }while (!optio.equals("8"));
                    break;
            }
        }while (!option.equals("6"));

    }
}