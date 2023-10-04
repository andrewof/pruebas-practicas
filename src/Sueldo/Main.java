
package Sueldo;


public class Main {
    public static void main(String[] args) {
        /* Creamos el objeto de la clase que se encarga de hacer todo el calculo
        de la retencion del salario... */
        CalcularSueldo trabajadores = new CalcularSueldo();
        
        /* Llamamos al método menu de la clase CalcularSalario para poder interactuar
        con las opciones del programa*/
        trabajadores.menu();
    }
}
