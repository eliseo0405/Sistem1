/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.ni.conversorControlador;
import java.awt.event.*;
import java.text.DecimalFormat;
import uni.edu.ni.conversorVista.VentanaPrincipal;
import uni.edu.ni.conversorModelo.ConversorDivisas;

/**
 *
 * @author Sirias Cano
 */
public class ControladorConversor implements ActionListener{
   // Propiedades
     private VentanaPrincipal ventana;
     private ConversorDivisas modelo;
    
     // Constructor
     public ControladorConversor(VentanaPrincipal v, ConversorDivisas m){
          this.ventana = v;
          this.modelo = m;
         
          ventana.setComboDivisas(modelo.obtenerCodigosDivisa());
     }

     public void actionPerformed(ActionEvent e) {
         
          // Obtengo los valores para operar
          Double importe = ventana.obtenerImporte();
          String codDivisaOrigen = ventana.obtenerDivisaOrigen();
          String codDivisaDestino = ventana.obtenerDivisaDestino();
         
          // Realizo la conversion
          Double resultado = modelo.convertir(codDivisaOrigen, codDivisaDestino, importe);
         
          // Muestro el resultado en la etiqueta Resultado
          DecimalFormat df = new DecimalFormat("#,###.##"); // Formateo salida a dos decimales
          ventana.actualizarResultado(df.format(resultado).toString());
     } 
}
