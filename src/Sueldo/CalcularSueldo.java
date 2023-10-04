
package Sueldo; 

import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.List;


public class CalcularSueldo {
    public List<Trabajador> trabajadores = new ArrayList<>();
    
    public void menu() {
        int opcion = 0;
        
        do {            
            opcion = Integer.parseInt(JOptionPane.showInputDialog("""
                                                                      1. Ingresar datos
                                                                      2. Consultar lista
                                                                      3. Salir"""));
            
            switch(opcion) {
                case 1 -> ingresarDatos();
                case 2 -> consultarLista();
                case 3 -> {
                }
                default -> JOptionPane.showMessageDialog(null, "Opción inválida");
            }
        } while (opcion != 3);
    }
    
    /* Método para ingresar datos de los trabajadores*/
    public void ingresarDatos() {
        String nombre = JOptionPane.showInputDialog("Ingresa tu nombre: ");
        String apellido = JOptionPane.showInputDialog("Ingresa tu apellido: ");
        String cedula = JOptionPane.showInputDialog("Ingresa tu cédula: ");

        // Cambiar la configuración del DecimalFormat para mostrar dos dígitos después del punto decimal
        DecimalFormat decimalFormat = new DecimalFormat("#.00");
        double salario = Double.parseDouble(JOptionPane.showInputDialog("Ingresa tu salario: "));

        trabajadores.add(new Trabajador(nombre, apellido, cedula, salario));
        
        retencionSalario();
    }
    
    /* Método para obtener el salario de los trabajadores y poder calcular su retención */
    public void retencionSalario() {
       for(Trabajador trabajador: trabajadores) {
           double salario = trabajador.getSueldo();
           
           double retencion = calcularRetencion(salario);
           
           trabajador.setRetencion(retencion);
       }
    }
    
    /* Método para calcular la retención */
    public double calcularRetencion(double salario) {
        String tipo = "";
        double retencion = 0;
        
        /* Le asignamos el tipo de salario al trabajador */
        if(salario >= 0.01 && salario <= 2.832) {
            tipo = "I";
        } else if(salario >= 2.833 && salario <= 5.371) {
            tipo = "II";
        } else if(salario >= 5.372 && salario <= 12.228) {
            tipo = "III";
        } else {
            tipo = "IV";
        }
        
        /* Calculamos la retención segun el tipo de salario */
        if ("II".equals(tipo)) {
            retencion = salario * 0.10;
        } else if("III".equals(tipo)) {
            retencion = salario * 0.20;
        } else if("IV".equals(tipo)) {
            retencion = salario * 0.30;
        }
        
        return retencion;
    }
    
    /* Método para consultar la lista de los trabajadores */
    public void consultarLista() {
        if(trabajadores.isEmpty()) {
            JOptionPane.showMessageDialog(null, "La lista está vacía");
        } else {
            for(Trabajador trabajador: trabajadores) {
                JOptionPane.showMessageDialog(null, trabajador.toString()+"\n");
            }
        }
    }
}
