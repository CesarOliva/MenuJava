package proyecto;

//Se importan las librerias a usar
import java.awt.event.ActionEvent;
import javax.swing.*;
import java.awt.*;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.WindowError;
import elementos.WindowMessage;

//La clase heredada de un JPanel. Panel personalizado
public class RadioButton extends JPanel{
    public RadioButton() {
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Creación y posición de componentes
        JLabel carreras = new JLabel("Carreras ITNL:");
        carreras.setBounds(20, 30, 150, 30);
        
        JRadioButton amb = new JRadioButton("Ing. Ambiental");
        amb.setBounds(20, 65, 250, 30);
        amb.setBackground(Color.WHITE);
        
        JRadioButton ige = new JRadioButton("Ing. Gestión Empresarial");
        ige.setBounds(20, 100, 250, 30);
        ige.setBackground(Color.WHITE);
        
        JRadioButton iem = new JRadioButton("Ing. Electromecánica");
        iem.setBounds(20, 135, 250, 30);
        iem.setBackground(Color.WHITE);
        
        JRadioButton ie = new JRadioButton("Ing. Eléctrica");
        ie.setBounds(20, 170, 250, 30);
        ie.setBackground(Color.WHITE);
        
        JRadioButton ind = new JRadioButton("Ing. Industrial");
        ind.setBounds(20, 205, 250, 30);
        ind.setBackground(Color.WHITE);
        
        JRadioButton im = new JRadioButton("Ing. Mecatrónica");
        im.setBounds(20, 240, 250, 30);
        im.setBackground(Color.WHITE);
        
        JRadioButton isc = new JRadioButton("Ing. Sistemas Computacionales");
        isc.setBounds(20, 275, 250, 30);
        isc.setBackground(Color.WHITE);
        
        JRadioButton semi = new JRadioButton("Ing. Semiconductores");
        semi.setBounds(20, 310, 250, 30);
        semi.setBackground(Color.WHITE);
        
        //agrega todos los radio buttons a un grupo de selección
        ButtonGroup opciones = new ButtonGroup();
        opciones.add(amb);
        opciones.add(ige);
        opciones.add(iem);
        opciones.add(ie);
        opciones.add(ind);
        opciones.add(im);
        opciones.add(isc);
        opciones.add(semi);
        
        //Creación del boton para mostrar la elección
        JButton boton = new RoundedButton("Mostrar Selección");
        boton.setBounds(20, 355, 150, 30);
        boton.setBackground(new Color(100, 149, 237));
        boton.setForeground(Color.WHITE);
        
        //Evento de accion al dar click en el botón
        boton.addActionListener((ActionEvent e) -> {
            //Verifica la opción del radioButton seleccionada
            if (amb.isSelected()) {
                //Muestra una ventana con la selección
                new WindowMessage("<b>Seleccionaste: </b>Ing. Ambiental", 220, 60);
            } else if (ige.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Gestión Empresarial", 220, 60);
            } else if (iem.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Electromecanica", 220, 60);
            } else if (ie.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Electrica", 220, 60);
            } else if (ind.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Industrial", 220, 60);
            } else if (im.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Mecatronica", 220, 60);
            } else if (isc.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. Sistemas Computacionales", 220, 60);
            } else if (semi.isSelected()) {
                new WindowMessage("<b>Seleccionaste: </b>Ing. SemiConductores", 220, 60);
            } else {
                    new WindowError("Selecciona una opción");
            }
        });

        //Se agregan los elementos creados
        add(carreras);
        add(amb);
        add(ige);
        add(iem);
        add(ie);
        add(ind);
        add(im);
        add(isc);
        add(semi);
        add(boton);
    }
}