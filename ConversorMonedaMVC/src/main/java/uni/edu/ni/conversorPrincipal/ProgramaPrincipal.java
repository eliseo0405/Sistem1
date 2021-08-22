/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.ni.conversorPrincipal;
import uni.edu.ni.conversorControlador.ControladorConversor;
import uni.edu.ni.conversorModelo.ConversorDivisas;
import uni.edu.ni.conversorVista.VentanaPrincipal;

/**
 *
 * @author Sirias Cano
 */
public class ProgramaPrincipal {
    public static void main(String[] args) {
        
        // Propiedades
          ConversorDivisas modelo = new ConversorDivisas();
          VentanaPrincipal vista = new VentanaPrincipal();
          ControladorConversor controlador = new ControladorConversor(vista, modelo);
          
         // Métodos
          vista.conectarControlador(controlador); // Conecto la vista al controlador
          vista.arrancar(); // Muestro la interfaz gráfica 
    }
}
