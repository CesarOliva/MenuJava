package proyecto;

//Se importan las librerias
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.PlaceholderTextField;
import elementos.WindowError;
import elementos.WindowMessage;

//Se importan las librerias a usar
public class Carreras extends JPanel{
    public Carreras(){
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);

        //Opciones a mostrar en el comboBox
        String opciones[] = {"Ing. Ambiental", "Ing. Gestión Empresarial", "Ing. Electromecánica", "Ing. Electrónica",
            "Ing. Mecatrónica", "Ing. Sistemas Computacionales", "Ing. Semiconductores"};

        //Creación de Labels y Textfields para ingresar datos
        JLabel labelNombre = new JLabel("Nombre Completo:");
        labelNombre.setBounds(20, 30, 150, 30);
        
        JTextField textNombre = new PlaceholderTextField("",15);
        textNombre.setBounds(130, 30, 250, 30);
        
        JLabel labelCarrera = new JLabel("Carrera:");
        labelCarrera.setBounds(20, 80, 150, 30);
        
        //Creción del componente comboBox
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(90, 80, 200, 30);
        comboBox.setBackground(Color.WHITE);

        //Creación del botón
        JButton boton = new RoundedButton("Mostrar Selección");
        boton.setBounds(20, 130, 150, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        
        //Declaración del arreglo para hacer la comparación con el label de nombre
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};

        //Evento de acción al dar click en el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtener el item seleccionado del comboBox
                String nombre = textNombre.getText();
                String carrera = (String) comboBox.getSelectedItem();

                //Boolean para verificar si encontró un numero en el campo de nombre y apellido 
                boolean encontrado = false;
                //Se recorre el arreglo para compararlo con los campos
                for (int i = 0; i < numeros.length; i++) {
                    if (nombre.contains(numeros[i])) {
                        //Si los campos contienen un numero cambiar el estado del booleano a verdadero
                        encontrado = true;
                    }
                }
                //Si el nommbre está vacio o se encontró un numero
                if(nombre.equals("" ) || encontrado){
                    //Mensage de error
                    new WindowError("Campos incompletos o de un tipo no requerido");
                }else{
                    //Muestra una ventana con la selección
                    String mensaje = "<b>Nombre: </b>"+nombre+"<br><b>Carrera: </b>" + carrera;
                    
                    new WindowMessage(mensaje, 220, 60);
                }
            }
        });
        
        //Se agregan los elementos creados
        add(labelNombre);
        add(textNombre);
        add(labelCarrera);
        add(comboBox);
        add(boton);
    }
}