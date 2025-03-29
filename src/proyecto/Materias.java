package proyecto;

//Se importan las librerias a usar
import java.awt.event.ActionEvent;
import java.awt.*;
import javax.swing.*;
import java.awt.event.ActionListener;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.WindowMessage;

public class Materias extends JPanel{
    public Materias() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Opciones a mostrar en los comboBox
        String carreras[] = {"Ing. Ambiental", "Ing. Gestión Empresarial", "Ing. Electromecánica", "Ing. Electrónica",
            "Ing. Industrial", "Ing. Mecatrónica", "Ing. Sistemas Computacionales", "Ing. Semiconductores"};
        String materias[] = {"Métodos Numéricos", "Principios Eléctricos", "Ecuaciones Diferenciales", "Sistemas Operativos",
            "Topicos Progamación", "Bases de datos"};
        String semestres[] = {"1° Semestre", "2° Semestre", "3° Semestre", "4° Semestre", "5° Semestre", "6° Semestre", "7° Semestre",
            "8° Semestre", "9° Semestre", "10° Semestre", "11° Semestre", "12° Semestre"};

        //Creación de Labels y comboBox para ingresar datos        
        JLabel labelCarrera = new JLabel("Carrera: ");
        labelCarrera.setBounds(20,30, 100, 30);
        
        JComboBox<String> comboCarrera = new JComboBox<>(carreras);
        comboCarrera.setMaximumRowCount(5);
        comboCarrera.setBounds(90, 30, 200, 30);
        comboCarrera.setBackground(Color.WHITE);
        
        JLabel labelSemestre = new JLabel("Semestre: ");
        labelSemestre.setBounds(20,80, 100, 30);
        
        JComboBox<String> comboSemestre = new JComboBox<>(semestres);
        comboSemestre.setMaximumRowCount(5);
        comboSemestre.setBounds(90, 80, 200, 30);
        comboSemestre.setBackground(Color.WHITE);
        
        JLabel labelMateria = new JLabel("Materia:");
        labelMateria.setBounds(20, 130, 200, 30);
        
        JComboBox<String> comboMateria = new JComboBox<>(materias);
        comboMateria.setMaximumRowCount(5);
        comboMateria.setBounds(90, 130, 200, 30);
        comboMateria.setBackground(Color.WHITE);
        
        //Creación del boton para mostrar la elección
        JButton boton = new RoundedButton("Mostrar Selección");
        boton.setBounds(20, 180, 150, 30);
        boton.setBackground(new Color(100, 150, 237));
        boton.setForeground(Color.WHITE);
        
        //Evento de accion al dar click en el botón
        boton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Obtener el item seleccionado del comboBox
                String carrera = (String) comboCarrera.getSelectedItem();
                String semestre = (String) comboSemestre.getSelectedItem();
                String materia = (String) comboMateria.getSelectedItem();
                //Muestra una ventana con la selección
                new WindowMessage("<b>Carrera: </b>" + carrera + "\n<br><b>Semestre: </b>" + semestre+"\n<br><b>Materia: </b>"+materia, 240, 80);
            }
        });
        
        //Se agregan los elementos creados
        add(labelCarrera);
        add(comboCarrera);
        add(labelSemestre);
        add(comboSemestre);
        add(labelMateria);
        add(comboMateria);
        add(boton);
    }
}