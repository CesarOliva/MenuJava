package proyecto;

//Se importan las librerias a usar
import elementos.RoundedButton;
import java.awt.BorderLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

//La clase Menú heredada de un JPanel. Panel personalizado
//Esta clase ejecuta la función del menú con todos los codigos en ella.
public class Menu extends JPanel{
    //Se declara fuera por que se usa en otro metodo fuera del constructor
    private static JPanel contentPanel; //Se declara el panel que cambiará todos los codigos
    private static JButton botonActivo = null; //Se declara el boton que guardará el activo
    private JFrame frame;
    private static Menu instancia;
    //Declarando un color que se usará en el diseño
    public Color azul = new Color(100, 149, 237);
    
    //Constructor
    public Menu(JFrame frame){
        //Se crea el frame que contendrá dos paneles y se hacen sus configuraciones
        frame = new JFrame("Menú Proyecto");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 520);
        frame.setResizable(false); //Bloquea la opción de maximizar
        frame.setLayout(new BorderLayout());
        
        this.frame = frame;
        instancia = this; //Guarda la instancia en una variable estatica

        //Centra la ventana al iniciar
        frame.setLocationRelativeTo(null);

        //Se crea el panel del lado izquierdo (Menú) que contiene los botones que ejecutan los códigos
        JPanel menuPanel = new JPanel();
        menuPanel.setLayout(null);
        //Configuración de tamaño y fondo
        menuPanel.setBackground(azul);
        menuPanel.setPreferredSize(new Dimension(250, 520));

        //Creación y diseño de los botones
        JButton btnPromedio = new RoundedButton("Promedio");
        btnPromedio.setBounds(50, 27, 150, 30);
        btnPromedio.setBackground(Color.WHITE);
        btnPromedio.setForeground(azul);
        
        JButton btnDatos = new RoundedButton("Datos");
        btnDatos.setBounds(50, 71, 150, 30);
        btnDatos.setBackground(Color.WHITE);
        btnDatos.setForeground(azul);

        JButton btnComboBox = new RoundedButton("ComboBox");
        btnComboBox.setBounds(50, 115, 150, 30);
        btnComboBox.setBackground(Color.WHITE);
        btnComboBox.setForeground(azul);

        JButton btnRb = new RoundedButton("Radio Button");
        btnRb.setBounds(50, 159, 150, 30);
        btnRb.setBackground(Color.WHITE);
        btnRb.setForeground(azul);

        JButton btnCarreras = new RoundedButton("Carreras");
        btnCarreras.setBounds(50, 203, 150, 30);
        btnCarreras.setBackground(Color.WHITE);
        btnCarreras.setForeground(azul);

        JButton btnMaterias = new RoundedButton("Materias");
        btnMaterias.setBounds(50, 251, 150, 30);
        btnMaterias.setBackground(Color.WHITE);
        btnMaterias.setForeground(azul);

        JButton btnMostrar = new RoundedButton("Mostrar Datos");
        btnMostrar.setBounds(50, 295, 150, 30);
        btnMostrar.setBackground(Color.WHITE);
        btnMostrar.setForeground(azul);

        JButton btnSlider = new RoundedButton("Slider");
        btnSlider.setBounds(50, 339, 150, 30);
        btnSlider.setBackground(Color.WHITE);
        btnSlider.setForeground(azul);

        JButton btnRGB = new RoundedButton("RGB");
        btnRGB.setBounds(50, 387, 150, 30);
        btnRGB.setBackground(Color.WHITE);
        btnRGB.setForeground(azul);

        JButton btnTamaño = new RoundedButton("Cambio Tamaño");
        btnTamaño.setBounds(50, 431, 150, 30);
        btnTamaño.setBackground(Color.WHITE);
        btnTamaño.setForeground(azul);

        //Ejecución de las clases al presionar los botones
        btnPromedio.addActionListener((ActionEvent e) -> {
            //Ejecuta el metodo cambiarVista
            cambiarVista(new Promedio(), btnPromedio);
        });
        btnDatos.addActionListener((ActionEvent e) -> {
            cambiarVista(new DatosPersona(), btnDatos);
        });
        btnComboBox.addActionListener((ActionEvent e) -> {
            cambiarVista(new ComboBox(), btnComboBox);
        });
        btnRb.addActionListener((ActionEvent e) -> {
            cambiarVista(new RadioButton(), btnRb);
        });
        btnCarreras.addActionListener((ActionEvent e) -> {
            cambiarVista(new Carreras(), btnCarreras);
        });
        btnMaterias.addActionListener((ActionEvent e) -> {
            cambiarVista(new Materias(), btnMaterias);
        });
        btnMostrar.addActionListener((ActionEvent e) -> {
            cambiarVista(new MostrarDatos(), btnMostrar);
        });
        btnSlider.addActionListener((ActionEvent e) -> {
            cambiarVista(new Slider(), btnSlider);
        });
        btnRGB.addActionListener((ActionEvent e) -> {
            cambiarVista(new RGB(), btnRGB);
        });
        btnTamaño.addActionListener((ActionEvent e) -> {
            cambiarVista(new TamañoElemento(), btnTamaño);
        });

        //Se agregan los botones al panel del menú
        menuPanel.add(btnPromedio);
        menuPanel.add(btnDatos);
        menuPanel.add(btnComboBox);
        menuPanel.add(btnRb);
        menuPanel.add(btnCarreras);
        menuPanel.add(btnMaterias);
        menuPanel.add(btnMostrar);
        menuPanel.add(btnSlider);
        menuPanel.add(btnRGB);
        menuPanel.add(btnTamaño);

        //Creación del panel de la derecha donde se verá el codigo ejecutado
        contentPanel = new JPanel();
        contentPanel.setLayout(new BorderLayout());
        contentPanel.setBackground(Color.WHITE);

        contentPanel.add(new Presentacion());
        
        //Se agregam los paneles al frame y lo hace visible
        frame.add(menuPanel, BorderLayout.WEST);
        frame.add(contentPanel, BorderLayout.CENTER);
        frame.setVisible(true);
    }

    //Metodo que muestra el panel con el contenido del codigo
    //Cambia el diseño del boton activo
    private void cambiarVista(JPanel panel, JButton boton) {
        //Panel de presentación
        Presentacion presentacion  = new Presentacion();
        //Restaurar el botón anterior
        if (botonActivo != null) { 
            botonActivo.setBackground(Color.WHITE);
            botonActivo.setForeground(azul);
        }
        
        //Si se le da al boton activo
        if(botonActivo == boton){
            //Elimina el contenido del panel de contenido
            contentPanel.removeAll();
            //Agrega el panel de Presentación
            contentPanel.add(presentacion.getPanel(), BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();
        }else{
            //Cambiar el diseño al nuevo botón seleccionado
            boton.setBackground(azul);
            boton.setForeground(Color.WHITE);
            botonActivo = boton;
            
            //Elimina el contenido del panel de contenido
            contentPanel.removeAll();
            //Agrega el contenido del codigo a ejecutar al panel de contenido
            contentPanel.add(panel, BorderLayout.CENTER);
            contentPanel.revalidate();
            contentPanel.repaint();

        }                
    }
    
    //Cierra la ventana
    public void cerrar(){
        frame.dispose();
    }
    
    //Regresa la instancia para usarla en otra clase
    public static Menu getInstancia(){
        return instancia;
    }
}