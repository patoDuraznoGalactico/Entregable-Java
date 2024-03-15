import java.util.ArrayList;

public class EmpleadoTemporal{
    private ArrayList<Empleado> empleadosTemporales;

    public EmpleadoTemporal() {
        this.empleadosTemporales = new ArrayList<>();
    }
    public void agregar(Empleado e) {
        this.empleadosTemporales.add(e);
    }

    public ArrayList<Empleado> getEmpleadosTemporales() {
        return empleadosTemporales;
    }

    public void setEmpleadosTemporales(ArrayList<Empleado> empleadosTemporales) {
        this.empleadosTemporales = empleadosTemporales;
    }
}
