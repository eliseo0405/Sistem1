/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.ni.conversorModelo;
import java.util.*;
/**
 *
 * @author Sirias Cano
 */
public class ConversorDivisas {
     // Propiedades
    // Codigo de divisa e importe en euros
     private Hashtable<String, Double> tablaConversion = new Hashtable<String, Double>();
     
     // Constructor
     public ConversorDivisas(){
          insertarDivisa("C. Dólar", 1.00); // conversión a córdoba
          insertarDivisa("C. Córdoba", 35.2713); // conversión a dolar
     }
     
     private void insertarDivisa(String codigo, Double tipoCambio) {
          tablaConversion.put(codigo, tipoCambio);
     }
    
     private double obtenerDivisa(String codigoDivisa){
          return tablaConversion.get(codigoDivisa);
     }
     
     public Double convertir(String codDivOrigen, String codDivDestino, Double importe){
          Double euros = importe / obtenerDivisa(codDivOrigen); // Primero convierto a euros
          return euros * obtenerDivisa(codDivDestino); // Luego a la unidad de destino
     }
     public Enumeration<String> obtenerCodigosDivisa(){
          return tablaConversion.keys();
     }
}
