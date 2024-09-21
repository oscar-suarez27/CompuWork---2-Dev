import javax.swing.JTextArea;

public class EmpleadoTemporal extends Empleado {
    private String fechaFinalContrato;
    private double tasaPorHora;

    public EmpleadoTemporal(int id, String nombre, int edad, String sexo, String fechaContratacion, String fechaFinalContrato, double tasaPorHora) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.fechaFinalContrato = fechaFinalContrato;
        this.tasaPorHora = tasaPorHora;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Temporal: " + getNombre());
        // Mostrar detalles específicos
    }

    @Override
    protected void mostrarDetalles(JTextArea displayArea) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'mostrarDetalles'");
    }

    @Override
    protected String getId() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getId'");
    }

    @Override
    protected void setNombre(String nuevoNombre) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'setNombre'");
    }

    // Getters y Setters
}
