import javax.swing.*;
import java.rmi.server.ExportException;
import java.util.ArrayList;

public class GestionEmpleados {
    private ArrayList<Empleado> empleados;
    EmpleadoPermanente empleadosPermanentes = new EmpleadoPermanente();
    EmpleadoTemporal empleadoTemporal = new EmpleadoTemporal();
    public GestionEmpleados() {
        this.empleados = new ArrayList<>();
    }
    private int id = 1;
    public void añadirEmpleado() {

        try {
            String nombre = JOptionPane.showInputDialog("Por favor ingrese el nombre: ");
            int edad = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese la edad: "));
            double salario = Double.parseDouble(JOptionPane.showInputDialog("Por favor ingrese el salario: "));
            Empleado empleado = new Empleado(nombre,edad,id,salario);
            id++;
            String tipo = JOptionPane.showInputDialog("""
                    Por favor introduzca el numero del tipo de empleado:
                    
                    (1). Empleado Permanente.
                    (2). Empleado Temporal.
                    """);
            if (tipo.equals("1")){
                this.empleadosPermanentes.agregar(empleado);
            } else if(tipo.equals("2")){
                this.empleadoTemporal.agregar(empleado);
            }
            this.empleados.add(empleado);

        }catch (Exception e){
            JOptionPane.showMessageDialog(null, "por favor ingrese bien los valores, gracias");
        }

    }
    public void eliminar(){
        try {
            int index = Integer.parseInt(JOptionPane.showInputDialog("Por favor ingrese el id del empleado a eliminar: "));
            for (Empleado i: this.empleados){
                if (i.getIdEmpleado() == index){
                    this.empleados.remove(i);
                    JOptionPane.showMessageDialog(null,"Eliminado correctamente");
                }
            }
        }catch (Exception e){

        }

    }
    public void mostrarEmpleados(){
        String text = "";
        for (Empleado e: this.empleados){
            text += e.toString();
        }
        if (text.equals("")){
            JOptionPane.showMessageDialog(null, "No hay empleados para listar");
        }else{
            JOptionPane.showMessageDialog(null,text);
        }
    }
}
