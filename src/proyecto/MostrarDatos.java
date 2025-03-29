package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.*;

//"librerias" personalizadas utilizadas
import elementos.PlaceholderTextField;
import elementos.RoundedButton;
import elementos.WindowError;
import elementos.WindowMessage;

//La clase Promedio heredada de un JPanel. Panel personalizado
public class MostrarDatos extends JPanel{
    public MostrarDatos() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);

        //Opciones del comboBox
        String[] semestre = {"1° Semestre", "2° Semestre", "3° Semestre", "4° Semestre", "5° Semestre", "6° Semestre", "7° Semestre",
            "8° Semestre", "9° Semestre", "10° Semestre", "11° Semestre", "12° Semestre"};
        
        //Creación de Labels y Textfields para ingresar datos
        JLabel labelNombre = new JLabel("Nombre: ");
        labelNombre.setBounds(20, 30, 200, 30);

        JTextField textNombre = new PlaceholderTextField("",20);
        textNombre.setBounds(90, 30, 200, 30);

        JLabel labelSemestre = new JLabel("Semestre: ");
        labelSemestre.setBounds(20, 70, 200, 30);

        JComboBox<String> comboBox = new JComboBox<>(semestre);
        comboBox.setMaximumRowCount(5);
        comboBox.setBounds(90, 70, 200, 30);
        comboBox.setBackground(Color.WHITE);

        JLabel labelCarrera = new JLabel("Carrera: ");
        labelCarrera.setBounds(20, 110, 200, 30);

        //Creación de los radioButtons        
        JRadioButton amb = new JRadioButton("Ing. Ambiental");
        amb.setBounds(20, 145, 250, 30);
        amb.setBackground(Color.WHITE);
        
        JRadioButton ige = new JRadioButton("Ing. Gestión Empresarial");
        ige.setBounds(20, 180, 250, 30);
        ige.setBackground(Color.WHITE);
        
        JRadioButton iem = new JRadioButton("Ing. Electromecánica");
        iem.setBounds(20, 215, 250, 30);
        iem.setBackground(Color.WHITE);
        
        JRadioButton ie = new JRadioButton("Ing. Electrica");
        ie.setBounds(20, 250, 250, 30);
        ie.setBackground(Color.WHITE);
        
        JRadioButton ind = new JRadioButton("Ing. Industrial");
        ind.setBounds(20, 285, 250, 30);
        ind.setBackground(Color.WHITE);
        
        JRadioButton im = new JRadioButton("Ing. Mecatronica");
        im.setBounds(20, 320, 250, 30);
        im.setBackground(Color.WHITE);
        
        JRadioButton isc = new JRadioButton("Ing. Sistemas Computacionales");
        isc.setBounds(20, 355, 250, 30);
        isc.setBackground(Color.WHITE);
        
        JRadioButton semi = new JRadioButton("Ing. Semiconductores");
        semi.setBounds(20, 390, 250, 30);
        semi.setBackground(Color.WHITE);

        //agrega todos los radio buttons a un grupo de selección
        ButtonGroup carreras = new ButtonGroup();
        carreras.add(amb);
        carreras.add(ige);
        carreras.add(iem);
        carreras.add(ie);
        carreras.add(ind);
        carreras.add(im);
        carreras.add(isc);
        carreras.add(semi);

        //Creación del boton para mostrar la elección
        JButton boton = new RoundedButton("Mostrar Selección");
        boton.setBounds(20, 435, 150, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);

        //Declaración del arreglo para hacer la comparación con el label de nombre
        String[] numeros = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
        
        //Creación de etiquetas para mostrar los elementos en el mismo panel
        JLabel datosN = new JLabel();
        JLabel datosS = new JLabel();
        JLabel datosC = new JLabel();

        datosN.setBounds(290, 110, 500, 100);
        datosS.setBounds(290, 145, 500, 100);
        datosC.setBounds(290, 180, 500, 100);

        //Evento de accion al dar click en el botón
        boton.addActionListener((ActionEvent e) -> {
            String carrera = "";

            //Verifica la opción del radioButton seleccionada
            if (amb.isSelected()) {
                carrera = "Ing. Ambiental ";
            } else if (ige.isSelected()) {
                carrera = "Ing. Gestión Empresarial";
            } else if (iem.isSelected()) {
                carrera = "Ing. Electromecánica";
            } else if (ie.isSelected()) {
                carrera = "Ing. Eléctrica";
            } else if (ind.isSelected()) {
                carrera = "Ing. Industrial";
            } else if (im.isSelected()) {
                carrera = "Ing. Mecatrónica";
            } else if (isc.isSelected()) {
                carrera = "Ing. Sistemas Computacionales";
            } else if (semi.isSelected()) {
                carrera = "Ing. SemiConductores";
            } else {
                carrera = "No seleccionada";
            }
            
            //Boolean para verificar si encontró un numero en el campo de nombre y apellido 
            boolean encontrado = false;
            //Se recorre el arreglo para compararlo con los campos
            for (int i = 0; i < numeros.length; i++) {
                if (textNombre.getText().contains(numeros[i])) {
                    //Si los campos contienen un numero cambiar el estado del booleano a verdadero
                    encontrado = true;
                }
            }
            //Si el nombre está vacio o se encontró un numero
            if(textNombre.getText().equals("" ) || encontrado){
                //Mensage de error
                new WindowError("Ingresa datos del tipo requerido");
            }else{
                //Muestra los datos
                datosN.setText("Nombre: " + textNombre.getText());
                datosS.setText("Semestre: " + (String) comboBox.getSelectedItem());
                datosC.setText("Carrera: " + carrera);
            }
            
        });

        add(labelNombre);
        add(textNombre);
        add(labelSemestre);
        add(comboBox);
        add(labelCarrera);
        add(amb);
        add(ige);
        add(iem);
        add(ie);
        add(ind);
        add(im);
        add(isc);
        add(semi);
        add(boton);
        add(datosN);
        add(datosS);
        add(datosC);
    }
}
