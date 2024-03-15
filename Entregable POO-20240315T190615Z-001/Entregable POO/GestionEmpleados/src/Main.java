import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        GestionEmpleados gestionEmpleados = new GestionEmpleados();
        String option = "";
        do {
            option = JOptionPane.showInputDialog("""
                    GESTION DE EMPLEADOS
                                        
                    1. Añadir empleados.
                    2. Eliminar empleados.
                    3. Mostrar empleados.
                    4. Salir.
                    """);

            switch (option) {

                case "1":
                    gestionEmpleados.añadirEmpleado();
                    break;
                case "2":
                    gestionEmpleados.eliminar();
                    break;
                case "3":
                    gestionEmpleados.mostrarEmpleados();
                    break;
            }
        } while (!option.equals("4"));
    }
}