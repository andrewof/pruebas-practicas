
package Sueldo;

import java.text.DecimalFormat;


public class Trabajador {
    String nombre;
    String apellido;
    String cedula;
    double sueldo;
    double retencion;

    public Trabajador(String nombre, String apellido, String cedula, double sueldo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.cedula = cedula;
        this.sueldo = sueldo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
    
    public void setRetencion(double retencion) {
        this.retencion = retencion;
    }

    @Override
    public String toString() {
        // Cambiar el formato de salida para mostrar dos dígitos después del punto decimal
        DecimalFormat decimalFormat = new DecimalFormat("#.000");
        return """
               Trabajador
               [NOMBRE]:  """ +nombre+"\n[APELLIDO]: " +apellido+"\n[CÉDULA]: "+cedula+
               "\n[SUELDO]: "+decimalFormat.format(sueldo)+"\n[RETENCIÓN]: "+decimalFormat.format(retencion);
    } 
}
