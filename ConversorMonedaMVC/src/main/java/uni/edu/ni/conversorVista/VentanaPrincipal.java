/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uni.edu.ni.conversorVista;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.util.*;
import uni.edu.ni.conversorControlador.ControladorConversor;
/**
 *
 * @author Sirias Cano
 */
public class VentanaPrincipal extends JFrame {
    
    private static final long serialVersionUID = 1L;
    //Propiedades
    private JPanel contentPane;
    private JTextField txtImporte;
    private JComboBox<String> comboDIvD;
    private JComboBox<String> comboDIvO;
    private JLabel lblResultado;
    private JLabel lblImporte;
    private JLabel lblConvertir;
    private final JButton btnConvertir;
    private final JComboBox<String> comboDivO;
    private final JComboBox<String> comboDivD;
    
    //Constructor
    public VentanaPrincipal() {
          setTitle("Conversor de Moneda");
          setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
          setBounds(100, 100, 309, 237);
          contentPane = new JPanel();
          contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
          setContentPane(contentPane);
          contentPane.setLayout(null);
         
          lblImporte = new JLabel("Introduce la cantidad: ");
          lblImporte.setFont(new Font("Arial", Font.BOLD, 12));
          lblImporte.setBounds(10, 11, 131, 14);
          contentPane.add(lblImporte);
         
          lblConvertir = new JLabel("Convertir a:");
          lblConvertir.setFont(new Font("Arial", Font.BOLD, 12));
          lblConvertir.setBounds(10, 74, 91, 14);
          contentPane.add(lblConvertir);
         
          lblResultado = new JLabel("Resultado: ");
          lblResultado.setFont(new Font("Arial", Font.BOLD, 18));
          lblResultado.setBounds(10, 165, 267, 27);
          contentPane.add(lblResultado);
         
          txtImporte = new JTextField();
          txtImporte.setBounds(10, 36, 131, 20);
          contentPane.add(txtImporte);
          txtImporte.setColumns(10);
         
          btnConvertir = new JButton("Convertir");
          btnConvertir.setFont(new Font("Arial", Font.BOLD, 12));
          btnConvertir.setBounds(175, 104, 102, 23);
          contentPane.add(btnConvertir);
         
          comboDivO = new JComboBox<String>();
          comboDivO.setBounds(175, 36, 102, 20);
          contentPane.add(comboDivO);
         
          comboDivD = new JComboBox<String>();
          comboDivD.setBounds(10, 105, 102, 20);
          contentPane.add(comboDivD);
         
          //Linea trazada entre cantidades y resultado
          JSeparator separator = new JSeparator();
          separator.setBounds(10, 152, 273, 2);
          contentPane.add(separator);
     }
    
     // Metodos
     public void arrancar() {
          EventQueue.invokeLater(new Runnable() {
                public void run() {
                     try {
                          setVisible(true);
                          setLocationRelativeTo(null);
                     } catch (Exception e) {
                          e.printStackTrace();
                     }
                }
          });
     }
    
     public Double obtenerImporte(){
          try{
                // return Double.valueOf(txtImporte.getText());
                return Double.valueOf(txtImporte.getText());
          }
          catch(NumberFormatException e){
                return 0.0D;
          }
     }
    
     public String obtenerDivisaOrigen(){
          return comboDivO.getSelectedItem().toString();
     }
    
     public String obtenerDivisaDestino(){
          return comboDivD.getSelectedItem().toString();
     }
    
     public void actualizarResultado(String importe){
          lblResultado.setText("Resultado: " + importe + " " + obtenerDivisaDestino());
     }
    
     public void setComboDivisas(Enumeration<String> codigosDivisas){
         
          String elemento;
          while(codigosDivisas.hasMoreElements()){ // Mientras tenga más elementos
                elemento = codigosDivisas.nextElement(); // Almacenar elemento en variable
                // Añadimos elemento a ambos comboBox
                comboDivD.addItem(elemento);
                comboDivO.addItem(elemento);
          }
     }
    
     // El que escucha la acción no es la ventana, es el controlador
     public void conectarControlador(ControladorConversor controlador){
          btnConvertir.addActionListener(controlador);
     }

//    public void conectarControlador(ControladorConversor controlador) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
    
    
    
}
