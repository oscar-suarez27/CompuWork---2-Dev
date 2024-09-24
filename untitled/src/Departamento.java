import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextArea;

public class Departamento {
    private int id;
    private String nombre;
    private String jefe;
    private String descripcion;
    private List<Empleado> empleados;

    public Departamento(int id, String nombre, String jefe, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.jefe = jefe;
        this.descripcion = descripcion;
        this.empleados = new ArrayList<>();
    }

    public void agregarEmpleado(Empleado empleado) {
        empleados.add(empleado);
    }

    public void mostrarEmpleados() {
        System.out.println("Empleados en el departamento " + nombre + ":");
        for (Empleado empleado : empleados) {
            empleado.mostrarDetalles();
        }
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    public void mostrarEmpleados(JTextArea displayArea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarEmpleados'");
    }

    public void setNombre(String nuevoNombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }
}
