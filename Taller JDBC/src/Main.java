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
                    3. Consultar Autor/libro.
                    4. Actualizar Autor/libro.
                    5. Eliminar Autor/libro.
                    6. Salir.
                    
                    """);

            switch (option){

                case "1":
                    AutorController.create();
                    break;
            }
        }while (!option.equals("6"));

    }
}