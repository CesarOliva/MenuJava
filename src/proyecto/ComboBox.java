package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;
import java.awt.event.ActionListener;

//Librerias personalizadas a utilizar
import elementos.RoundedButton;
import elementos.WindowMessage;

//La clase heredada de un JPanel. Panel personalizado
public class ComboBox extends JPanel{
    public ComboBox() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Opciones a mostrar en el comboBox
        String opciones[] = {"Opcion 1", "Opcion 2", "Opcion 3", "Opcion 4", "Opcion 5", "Opcion 6", "Opcion 7", "Opcion 8",
        "Opcion 9", "Opcion 10", "Opcion 11", "Opcion 12", "Opcion 13", "Opcion 14", "Opcion 15", "Opcion 16",
        "Opcion 17", "Opcion 18", "Opcion 19", "Opcion 20"};
        
        //Creción del componente comboBox
        JComboBox<String> comboBox = new JComboBox<>(opciones);
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(20, 30, 150, 30);
        comboBox.setBackground(Color.WHITE);

        //Creación del botón
        JButton boton = new RoundedButton("Mostrar Selección");
        boton.setBounds(250, 30, 150, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        
        //Evento de acción al dar click en el botón
        boton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Obtener el item seleccionado del comboBox
                String seleccion = (String) comboBox.getSelectedItem();
                //Muestra una ventana con la selección
                new WindowMessage("<b>Opcion seleccionada: </b>"+seleccion, 200, 40);
            }
        });
        
        //Se agregan los elementos creados
        add(comboBox);
        add(boton);
    }
}