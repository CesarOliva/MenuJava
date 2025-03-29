package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.PlaceholderTextField;
import elementos.WindowError;
import elementos.WindowMessage;

//La clase Promedio heredada de un JPanel. Panel personalizado
public class Promedio extends JPanel{
    public Promedio() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);

        //Creación de Labels y Textfields para ingresar datos
        JLabel labelCal1 = new JLabel("Calificación 1:");
        labelCal1.setBounds(20, 30, 150, 30);
        
        JTextField textCal1 = new PlaceholderTextField("",20);
        textCal1.setBounds(110, 30, 150, 30);
        
        JLabel labelCal2 = new JLabel("Calificación 2:");
        labelCal2.setBounds(20, 80, 150, 30);
        
        JTextField textCal2 = new PlaceholderTextField("",20);
        textCal2.setBounds(110, 80, 150, 30);
        
        JLabel labelCal3 = new JLabel("Calificación 3:");
        labelCal3.setBounds(20, 130, 150, 30);
        
        JTextField textCal3 = new PlaceholderTextField("",20);
        textCal3.setBounds(110, 130, 150, 30);
        
        JLabel labelCal4 = new JLabel("Calificación 4:");
        labelCal4.setBounds(20, 180, 150, 30);

        JTextField textCal4 = new PlaceholderTextField("",20);
        textCal4.setBounds(110, 180, 150, 30);
        
        JLabel labelCal5 = new JLabel("Calificación 5:");
        labelCal5.setBounds(20, 230, 150, 30);
        
        JTextField textCal5 = new PlaceholderTextField("",20);
        textCal5.setBounds(110, 230, 150, 30);

        //Creación del boton para hacer la función del promedio
        JButton boton = new RoundedButton("Promedio");
        boton.setBounds(20, 280, 100, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);

        //Evento de acción al dar click en el botón
        boton.addActionListener((ActionEvent e) -> {
            //Intente calcular el promedio o evitar el error
            try {
                //Convertir el valor de los textFields en double
                double cal1 = Double.parseDouble(textCal1.getText());
                double cal2 = Double.parseDouble(textCal2.getText());
                double cal3 = Double.parseDouble(textCal3.getText());
                double cal4 = Double.parseDouble(textCal4.getText());
                double cal5 = Double.parseDouble(textCal5.getText());
                double promedio = (cal1+cal2+cal3+cal4+cal5)/5;
                //Mostrar el resultado mediante una ventana de dialogo
                new WindowMessage("Promedio: "+promedio, 200, 40);
                // Captura el error si la conversión de String a número falla
            } catch (NumberFormatException ex) {
                //Muestra mensaje de error
                    new WindowError("Ingresa datos del tipo requerido");
            }
        });

        //Se agregan los elementos creados
        add(labelCal1);
        add(textCal1);
        add(labelCal2);
        add(textCal2);
        add(labelCal3);
        add(textCal3);
        add(labelCal4);
        add(textCal4);
        add(labelCal5);
        add(textCal5);
        add(boton);
    }
}