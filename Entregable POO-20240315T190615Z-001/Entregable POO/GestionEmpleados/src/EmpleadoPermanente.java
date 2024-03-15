import java.util.ArrayList;

public class EmpleadoPermanente{
    private ArrayList<Empleado> empleadosPermanentes;

    public EmpleadoPermanente() {
        this.empleadosPermanentes = new ArrayList<>();
    }

    public void agregar(Empleado e) {
        this.empleadosPermanentes.add(e);
    }

    public ArrayList<Empleado> getEmpleadosPermanentes() {
        return empleadosPermanentes;
    }

    public void setEmpleadosPermanentes(ArrayList<Empleado> empleadosPermanentes) {
        this.empleadosPermanentes = empleadosPermanentes;
    }
}
