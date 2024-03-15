import javax.swing.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int option;
        Inventario inventario = new Inventario();
        do {
            option = Integer.parseInt(JOptionPane.showInputDialog("""
                GESTIONAR INVENTARIO
                
                1. Añadir productos.
                2. Eliminar productos.
                3. Listar productos.    
                4. Buscar productos.
                5. Salir.
                """));

            switch (option){
                case 1:
                    inventario.añadirProductos();
                    break;
                case 2:
                    inventario.eliminar();
                    break;
                case 3:
                    inventario.listarProductos();
                    break;
                case 4:
                    inventario.buscar();
                    break;
            }
        }while (option != 5);
    }
}