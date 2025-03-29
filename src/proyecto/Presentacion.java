package proyecto;

//Se importan las librerias
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;

//Clase presentación heredada de un JPanel. Panel Personalizado
public class Presentacion extends JPanel{
    public Presentacion(){
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Datos del proyecto
        JLabel institucion = new JLabel("Instituto Tecnológico de Nuevo León");
        institucion.setFont(new Font("Inter", Font.PLAIN, 24));
        institucion.setBounds(82, 50, 385, 50);
        
        JLabel materia = new JLabel("Topicos Avanzados de Programación");
        materia.setFont(new Font("Inter", Font.PLAIN, 20));
        materia.setBounds(108, 100, 334, 50);
        
        JLabel proyecto = new JLabel("Proyecto Unidad 2");
        proyecto.setFont(new Font("Inter", Font.PLAIN, 16));
        proyecto.setBounds(210, 150, 130, 50);
        
        JLabel integrantestxt = new JLabel("Integrantes:");
        integrantestxt.setFont(new Font("Inter", Font.PLAIN, 16));
        integrantestxt.setBounds(80, 200, 100, 50);
                
        JTextPane integrantes = new JTextPane();
        integrantes.setContentType("text/html");
        integrantes.setText("<html>"
            +"<ul>"
                +"<li style='font-family:Inter; font-size: 10px; font-weight:400; margin-bottom:10px'>César Emilio Oliva Vázquez.&#9;&#9;23480864</li>"
                +"<li style='font-family:Inter; font-size: 10px; font-weight:400; margin-bottom:10px'>Angel Fernando López Santos.&#9;&#9;23480843</li>"
                +"<li style='font-family:Inter; font-size: 10px; font-weight:400; margin-bottom:10px'>Alan Alfonso Coronado Martínez.&#9;&#9;23480777</li>"
                +"<li style='font-family:Inter; font-size: 10px; font-weight:400; margin-bottom:10px'>Julio Andrés Herrera Martínez.&#9;&#9;22480923</li>"
                +"<li style='font-family:Inter; font-size: 10px; font-weight:400; margin-bottom:10px'>Omar Alejandro Arriaga Reyna.&#9;&#9;23480854</li>"
            + "</ul>"
        );
        integrantes.setBounds(34, 240, 403, 160);
        //Bloquea la escritura en el textPane
        integrantes.setEditable(false);
        integrantes.setFocusable(false);        
        JButton boton = new RoundedButton("Cerrar Sesión");
        boton.setBounds(200, 420, 130, 30);
        boton.setFocusPainted(false);
        boton.setBackground(new Color(223, 81, 81));
        boton.setForeground(Color.white);
        
        //Funcion del botón
        boton.addActionListener((ActionEvent e)->{
            Menu.getInstancia().cerrar();
            LogIn.getInstancia().mostrarVentana();
        });
        
        //Agregar los elementos al panel
        add(institucion);
        add(materia);
        add(proyecto);
        add(integrantestxt);
        add(integrantes);
        add(boton);
    }
    
    public JPanel getPanel(){
        return this;
    }
}