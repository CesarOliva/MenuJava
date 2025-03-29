package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.PlaceholderTextField;
import elementos.WindowError;
import elementos.WindowMessage;

//La clase DatosPersona heredada de un JPanel. Panel personalizado
public class DatosPersona extends JPanel{
    public DatosPersona() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Creación de Labels y Textfields para ingresar datos        
        JLabel labelNombre = new JLabel("Nombre: ");
        labelNombre.setBounds(20, 30, 150, 30);
                
        JTextField textNombre = new PlaceholderTextField("",20);
        textNombre.setBounds(110, 30, 150, 30);
        
        JLabel labelApellido = new JLabel("Apellido:");
        labelApellido.setBounds(20, 80, 150, 30);
        
        JTextField textApellido = new PlaceholderTextField("",20);
        textApellido.setBounds(110, 80, 150, 30);
        
        JLabel labelEdad = new JLabel("Edad:");
        labelEdad.setBounds(20, 130, 150, 30);
        
        JTextField textEdad = new PlaceholderTextField("",20);
        textEdad.setBounds(110, 130, 150, 30);

        JLabel labelMateria = new JLabel("Materia:");
        labelMateria.setBounds(20, 180, 150, 30);

        JTextField textMateria = new PlaceholderTextField("",20);
        textMateria.setBounds(110, 180, 150, 30);

        JLabel labelCali = new JLabel("Calificación:");
        labelCali.setBounds(20, 230, 150, 30);

        JTextField textCali = new PlaceholderTextField("",20);
        textCali.setBounds(110, 230, 150, 30);

        //Creación del boton para mostrar los datos ingresados
        JButton boton = new RoundedButton("Mostrar Datos");
        boton.setBounds(20, 280, 150, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        
        //Declaración del arreglo para hacer la comparación con el label de nombre
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        
        //Evento de acción al dar click en el botón
        boton.addActionListener((ActionEvent e) -> {
            //Obtener el texto en los campos correspondientes
            String nombre = textNombre.getText();
            String apellido = textApellido.getText();
            String materia = textMateria.getText();
            
            //Intente convertir en numeros enteros o evitar el error
            try {
                int edad = Integer.parseInt(textEdad.getText());
                int cali = Integer.parseInt(textCali.getText());
                
                //Boolean para verificar si encontró un numero en el campo de nombre y apellido 
                boolean encontrado = false;
                //Se recorre el arreglo para compararlo con los campos
                for (int i = 0; i < numeros.length; i++) {
                    if (nombre.contains(numeros[i]) || apellido.contains(numeros[i]) || materia.contains(numeros[i])) {
                        //Si los campos contienen un numero cambiar el estado del booleano a verdadero
                        encontrado = true;
                    }
                }
                //Si no encontró numeros en campos de String
                if (!encontrado) {
                    //Muestra los datos en una ventana de dialogo
                    new WindowMessage("<b>Nombre: </b>" + nombre + "<br>" + "\n<b>Apellido:</b> " + apellido + "<br>"+ "\n<b>Edad: </b>" + edad
                            +"<br>" + "\n<b>Materia: </b>" + materia + "<br>" +"\n<b>Calificación: </b>" + cali, 270, 120);
                } else {
                    //Muestra error
                    new WindowError("Datos incompletos o de un tipo no requerido");
                }
            // Captura el error si la conversión de String a número falla en campos de edad y calificación
            } catch (NumberFormatException ex) {
                new WindowError("Datos incompletos o de un tipo no requerido");

            }
        });

        //Se agregan los elementos creados
        add(labelNombre);
        add(textNombre);
        add(labelApellido);
        add(textApellido);
        add(labelEdad);
        add(textEdad);
        add(labelMateria);
        add(textMateria);
        add(labelCali);
        add(textCali);
        add(boton);
    }
}