import java.util.Date;

public class ReporteDesempeio {
    private Date fechaGeneracion;
    private int puntaje;
    private String observaciones;
    private Empleado empleado;
    private Departamento departamento;

    public ReporteDesempeio(Date fechaGeneracion, int puntaje, String observaciones, Empleado empleado, Departamento departamento) {
        this.fechaGeneracion = fechaGeneracion;
        this.puntaje = puntaje;
        this.observaciones = observaciones;
        this.empleado = empleado;
        this.departamento = departamento;
    }

    // Métodos para generar reportes
    public void generarReporteIndividual() {
        System.out.println("Reporte para el empleado: " + empleado.getNombre() + " - Puntaje: " + puntaje);
    }

    public void generarReportePorDepartamento() {
        System.out.println("Reporte para el departamento: " + departamento.getNombre() + " - Puntaje: " + puntaje);
    }

    // Getters y Setters
    public Date getFechaGeneracion() { return fechaGeneracion; }
    public int getPuntaje() { return puntaje; }
    public String getObservaciones() { return observaciones; }
    public Empleado getEmpleado() { return empleado; }
    public Departamento getDepartamento() { return departamento; }
}
