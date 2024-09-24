import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class Main extends JFrame {
    private List<Empleado> empleados;
    private List<Departamento> departamentos;
    private JTextArea displayArea;

    public Main() {
        empleados = new ArrayList<>();
        departamentos = new ArrayList<>();
        displayArea = new JTextArea(10, 40);
        displayArea.setEditable(false);

        setTitle("Gestión de Empleados y Departamentos");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Botones
        JButton btnEmpleado = new JButton("Gestionar Empleados");
        JButton btnDepartamento = new JButton("Gestionar Departamentos");

        btnEmpleado.addActionListener(e -> manejarEmpleados());
        btnDepartamento.addActionListener(e -> manejarDepartamentos());

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(btnEmpleado);
        buttonPanel.add(btnDepartamento);

        panel.add(buttonPanel, BorderLayout.NORTH);
        panel.add(new JScrollPane(displayArea), BorderLayout.CENTER);

        add(panel);
        setVisible(true);
    }

    private void manejarEmpleados() {
        String[] options = {"Crear", "Modificar", "Eliminar", "Mostrar", "Asignar a Departamento"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Seleccione una opción:",
                "Gestionar Empleados", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (seleccion) {
            case "Crear":
                crearEmpleado();
                break;
            case "Modificar":
                modificarEmpleado();
                break;
            case "Eliminar":
                eliminarEmpleado();
                break;
            case "Mostrar":
                mostrarEmpleados();
                break;
            case "Asignar a Departamento":
                asignarEmpleadoADepartamento();
                break;
        }
    }

    private void crearEmpleado() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre:");
        int edad = Integer.parseInt(JOptionPane.showInputDialog(this, "Edad:"));
        String sexo = JOptionPane.showInputDialog(this, "Sexo:");
        String fechaContratacion = JOptionPane.showInputDialog(this, "Fecha de Contratación:");
        String tipo = JOptionPane.showInputDialog(this, "Tipo (Permanente/Temporal):");

        if (tipo.equalsIgnoreCase("Permanente")) {
            String beneficios = JOptionPane.showInputDialog(this, "Beneficios:");
            double salarioBase = Double.parseDouble(JOptionPane.showInputDialog(this, "Salario Base:"));
            empleados.add(new EmpleadoPermanente(empleados.size() + 1, nombre, edad, sexo, fechaContratacion, beneficios, salarioBase));
        } else {
            String fechaFinalContrato = JOptionPane.showInputDialog(this, "Fecha Final de Contrato:");
            double tasaPorHora = Double.parseDouble(JOptionPane.showInputDialog(this, "Tasa por Hora:"));
            empleados.add(new EmpleadoTemporal(empleados.size() + 1, nombre, edad, sexo, fechaContratacion, fechaFinalContrato, tasaPorHora));
        }

        displayArea.append("Empleado creado: " + nombre + "\n");
    }

    private void modificarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a modificar:"));
        if (id > 0 && id <= empleados.size()) {
            Empleado empleado = empleados.get(id - 1);
            String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre:", empleado.getNombre());
            empleado.setNombre(nuevoNombre);
            displayArea.append("Empleado modificado: " + nuevoNombre + "\n");
        } else {
            displayArea.append("ID de empleado inválido.\n");
        }
    }

    private void eliminarEmpleado() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a eliminar:"));
        if (id > 0 && id <= empleados.size()) {
            empleados.remove(id - 1);
            displayArea.append("Empleado con ID " + id + " eliminado.\n");
        } else {
            displayArea.append("ID de empleado inválido.\n");
        }
    }

    private void mostrarEmpleados() {
        displayArea.append("Lista de Empleados:\n");
        for (Empleado empleado : empleados) {
            displayArea.append("ID: " + empleado.getId() + ", Nombre: " + empleado.getNombre() + "\n");
        }
    }

    private void asignarEmpleadoADepartamento() {
        int empId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del empleado a asignar:"));
        if (empId > 0 && empId <= empleados.size()) {
            int deptId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento:"));
            if (deptId > 0 && deptId <= departamentos.size()) {
                Empleado empleado = empleados.get(empId - 1);
                Departamento departamento = departamentos.get(deptId - 1);
                empleado.asignarDepartamento(departamento);
                displayArea.append("Empleado " + empleado.getNombre() + " asignado al departamento " + departamento.getNombre() + ".\n");
            } else {
                displayArea.append("ID de departamento inválido.\n");
            }
        } else {
            displayArea.append("ID de empleado inválido.\n");
        }
    }

    private void manejarDepartamentos() {
        String[] options = {"Crear", "Modificar", "Eliminar", "Mostrar", "Mostrar Empleados"};
        String seleccion = (String) JOptionPane.showInputDialog(this, "Seleccione una opción:",
                "Gestionar Departamentos", JOptionPane.PLAIN_MESSAGE, null, options, options[0]);

        switch (seleccion) {
            case "Crear":
                crearDepartamento();
                break;
            case "Modificar":
                modificarDepartamento();
                break;
            case "Eliminar":
                eliminarDepartamento();
                break;
            case "Mostrar":
                mostrarDepartamentos();
                break;
            case "Mostrar Empleados":
                mostrarEmpleadosPorDepartamento();
                break;
        }
    }

    private void crearDepartamento() {
        String nombre = JOptionPane.showInputDialog(this, "Nombre del Departamento:");
        String jefe = JOptionPane.showInputDialog(this, "Jefe de Departamento:");
        String descripcion = JOptionPane.showInputDialog(this, "Descripción:");
        departamentos.add(new Departamento(departamentos.size() + 1, nombre, jefe, descripcion));
        displayArea.append("Departamento creado: " + nombre + "\n");
    }

    private void modificarDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento a modificar:"));
        if (id > 0 && id <= departamentos.size()) {
            Departamento departamento = departamentos.get(id - 1);
            String nuevoNombre = JOptionPane.showInputDialog(this, "Nuevo Nombre:", departamento.getNombre());
            departamento.setNombre(nuevoNombre);
            displayArea.append("Departamento modificado: " + nuevoNombre + "\n");
        } else {
            displayArea.append("ID de departamento inválido.\n");
        }
    }

    private void eliminarDepartamento() {
        int id = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento a eliminar:"));
        if (id > 0 && id <= departamentos.size()) {
            departamentos.remove(id - 1);
            displayArea.append("Departamento con ID " + id + " eliminado.\n");
        } else {
            displayArea.append("ID de departamento inválido.\n");
        }
    }

    private void mostrarDepartamentos() {
        displayArea.append("Lista de Departamentos:\n");
        for (Departamento departamento : departamentos) {
            displayArea.append("ID: " + departamento.getId() + ", Nombre: " + departamento.getNombre() + "\n");
        }
    }

    private void mostrarEmpleadosPorDepartamento() {
        int deptId = Integer.parseInt(JOptionPane.showInputDialog(this, "Ingrese el ID del departamento:"));
        if (deptId > 0 && deptId <= departamentos.size()) {
            Departamento departamento = departamentos.get(deptId - 1);
            displayArea.append("Empleados en el departamento " + departamento.getNombre() + ":\n");
            departamento.mostrarEmpleados(displayArea);
        } else {
            displayArea.append("ID de departamento inválido.\n");
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
