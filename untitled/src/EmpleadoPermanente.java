import javax.swing.JTextArea;

public class EmpleadoPermanente extends Empleado {
    private String beneficios;
    private double salarioBase;

    public EmpleadoPermanente(int id, String nombre, int edad, String sexo, String fechaContratacion, String beneficios, double salarioBase) {
        super(id, nombre, edad, sexo, fechaContratacion);
        this.beneficios = beneficios;
        this.salarioBase = salarioBase;
    }

    @Override
    public void mostrarDetalles() {
        System.out.println("Empleado Permanente: " + getNombre());
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
