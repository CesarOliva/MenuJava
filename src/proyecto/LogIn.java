package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

//"librerias" personalizadas utilizadas
import elementos.RoundedButton;
import elementos.PlaceholderTextField;
import elementos.PlaceholderPassField;
import elementos.WindowError;
import elementos.WindowMessage;

//La clase LogIn heredada de un JPanel. Panel personalizado
//Muestra el Inicio de sesión o registro
public class LogIn extends JPanel{
    //Se declara fuera por que se usa en otros metodo fuera del main
    private HashMap<String, String> users = new HashMap<>();
    private JFrame frame;
    private JPanel logIn, register, descLogIn, descRegister;
    private JPanel panelLogIn, panelRegister;
    private JTextField userField;
    private JPasswordField passField;
    private static LogIn instancia;
    
    //Declarando un color que se usará en el diseño
    public Color azul = new Color(100, 149, 237);
    
    public LogIn(JFrame frame){        
        //Configuración de la ventana
        frame = new JFrame("Iniciar Sesión o Registrarse");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 520);
        frame.setResizable(false); //Bloquea la opción de maximizar
        frame.setLayout(new BorderLayout());
        
        this.frame = frame;
        instancia = this;

        //Centra la ventana al iniciar
        frame.setLocationRelativeTo(null);

        //Mostrar Inicialmente el panel de Inicio de Sesión
        frame.add(MostrarLogIn());
        frame.setVisible(true);
        
        //Enfoca la ventana al iniciar para evitar que enfoque otros elementos
        SwingUtilities.invokeLater(() -> {
            this.frame.requestFocusInWindow(); 
        });
        
        agregarListener(frame);
    }
    
    //Listener del focus
    public void agregarListener(JFrame frame) {
        frame.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frame.requestFocusInWindow(); // Quita el foco del JTextField
            }
        });
    }
    
    
    //Metodo que muestra los paneles de la sección de Iniciar Sesión
    private JPanel MostrarLogIn(){
        //Panel que contendrá los dos paneles
        panelLogIn = new JPanel(new BorderLayout());

        //Panel que muestra los elementos de inicio de sesión
        logIn = new JPanel();
        logIn.setLayout(null);
        logIn.setPreferredSize(new Dimension(400, 520));
        logIn.setBackground(Color.WHITE);
        
        //Elementos del panel de Inicio de sesión
        JLabel textLogIn = new JLabel("Iniciar Sesión");
        textLogIn.setBounds(110, 120, 300, 30);
        textLogIn.setFont(new Font("Inter", Font.PLAIN, 30));
        
        JLabel textUse = new JLabel("Ingrese su usuario y contraseña");
        textUse.setBounds(97, 160, 250, 30);
        textUse.setFont(new Font("Inter", Font.PLAIN, 14));
        
        userField = new PlaceholderTextField("Usuario", 20);
        userField.setBounds(100, 210, 200, 30);
        userField.setFont(new Font("Inter", Font.PLAIN, 12));
        
        passField = new PlaceholderPassField("Contraseña", 20);
        passField.setBounds(100, 250, 200, 30);
        passField.setFont(new Font("Inter", Font.PLAIN, 12));

        //Creación del botón redondeado
        JButton loginButton = new RoundedButton("Iniciar Sesión");
        loginButton.setBounds(125, 300, 150, 30);
        
        loginButton.setBackground(new Color(100, 149, 237));
        loginButton.setForeground(Color.WHITE);
        loginButton.setFocusPainted(false);
        loginButton.setFont(new Font("Inter", Font.PLAIN, 14));
        
        //Funcionalidad del botón. Inicia sesión
        loginButton.addActionListener(new LogInAction());        
        //Agregar elementos al panel de logIn
        logIn.add(textLogIn);
        logIn.add(textUse);
        logIn.add(userField);
        logIn.add(passField);
        logIn.add(loginButton);    
        
 
        
        //Panel que muestra el panel de instrucciones
        descLogIn = new JPanel();
        descLogIn.setLayout(null);
        descLogIn.setPreferredSize(new Dimension(400, 520));
        descLogIn.setBackground(azul);
        
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/elementos/imagen.png")));
        fondo.setBounds(0, 0, 400, 520); // Ajusta al tamaño de la ventana
        
        //Creación de los elementos
        JLabel titulo = new JLabel("¡Bienvenido!");
        titulo.setFont(new Font("Inter", Font.PLAIN, 30));
        titulo.setBounds(115, 140, 250, 30);
        titulo.setForeground(Color.WHITE);
        
        JLabel texto1 = new JLabel("Ingrese sus datos para usar todas");
        JLabel texto2 = new JLabel("las funciones del programa");
        
        texto1.setFont(new Font("Inter", Font.PLAIN, 14));
        texto1.setBounds(87, 140, 300, 100);
        texto1.setForeground(Color.WHITE);
        
        texto2.setFont(new Font("Inter", Font.PLAIN, 14));
        texto2.setBounds(110, 155, 300, 100);
        texto2.setForeground(Color.WHITE);

        JLabel registrarse = new JLabel("¿No está registrado? Pruebe");
        registrarse.setFont(new Font("Inter", Font.PLAIN, 14));        
        registrarse.setBounds(105, 250, 250, 30);        
        registrarse.setForeground(Color.WHITE);
        
        //Creación del botón redondeado
        JButton btnCR = new RoundedButton("Registrarse");
        btnCR.setBounds(125, 280, 150, 30);
        btnCR.setBackground(Color.WHITE);
        btnCR.setForeground(azul);                        
        btnCR.setFont(new Font("Inter", Font.PLAIN, 14));

        
        //Funcionalidad del boton cambiar a registrarse
        btnCR.addActionListener((ActionEvent e)->{
            CambiarVista(MostrarRegister());
        });
        
        //Agregar elementos al panel de instrucciones
        descLogIn.add(titulo);
        descLogIn.add(texto1);
        descLogIn.add(texto2);
        descLogIn.add(registrarse);
        descLogIn.add(btnCR);
        descLogIn.add(fondo);
        
        //Se agregan los paneles al panel principal
        panelLogIn.add(logIn, BorderLayout.WEST);
        panelLogIn.add(descLogIn, BorderLayout.EAST);
        
        //Regresa el panel con todo el contenido
        return panelLogIn;
    }    
    
    //Metodo que retorna los paneles de la sección de Iniciar Sesión
    private JPanel MostrarRegister(){
        //Panel que contendrá los dos paneles
        panelRegister = new JPanel(new BorderLayout());
        
        //Panel que muestra el panel de instrucciones
        descRegister = new JPanel();
        descRegister.setLayout(null);
        descRegister.setPreferredSize(new Dimension(400, 520));
        descRegister.setBackground(azul);

        //Imagen de fondo
        JLabel fondo = new JLabel(new ImageIcon(getClass().getResource("/elementos/imagen.png")));
        fondo.setBounds(0, 0, 400, 520); // Ajusta al tamaño de la ventana
        
        //Diseño y acomodo de los elementos
        JLabel titulo = new JLabel("¡Hola!");
        titulo.setFont(new Font("Inter", Font.PLAIN, 30));
        titulo.setBounds(160, 140, 150, 30);
        titulo.setForeground(Color.WHITE);
        
        JLabel texto1 = new JLabel("Registrese con sus datos para usar");
        JLabel texto2 = new JLabel("todas las funciones del programa");
        
        texto1.setFont(new Font("Inter", Font.PLAIN, 14));
        texto1.setBounds(85, 140, 300, 100);
        texto1.setForeground(Color.WHITE);
        
        texto2.setFont(new Font("Inter", Font.PLAIN, 14));
        texto2.setBounds(95, 155, 300, 100);
        texto2.setForeground(Color.WHITE);

        JLabel ingresar = new JLabel("¿Ya tienes una cuenta? Intente");
        ingresar.setFont(new Font("Inter", Font.PLAIN, 14));        
        ingresar.setBounds(100, 250, 250, 30);        
        ingresar.setForeground(Color.WHITE);

        JButton btnCL = new RoundedButton("Iniciar Sesión");
        btnCL.setBounds(125, 280, 150, 30);
        btnCL.setBackground(Color.WHITE);
        btnCL.setForeground(azul);                        
        btnCL.setFont(new Font("Inter", Font.PLAIN, 14));

        //Funcionalidad del boton cambiar a logIn
        btnCL.addActionListener((ActionEvent e)->{
           CambiarVista(MostrarLogIn()); 
        });
        
        //Agregar elementos al panel de instrucciones
        descRegister.add(titulo);
        descRegister.add(texto1);
        descRegister.add(texto2);
        descRegister.add(ingresar);
        descRegister.add(btnCL);        
        descRegister.add(fondo);        

        
        
        //Panel que muestra los elementos de registrarse
        register = new JPanel();
        register.setLayout(null);
        register.setPreferredSize(new Dimension(400, 520));
        register.setBackground(Color.WHITE);
        
        //Elementos del panel de Inicio de sesión
        JLabel textRegister = new JLabel("Registrarse");
        textRegister.setBounds(120, 120, 300, 40);
        textRegister.setFont(new Font("Inter", Font.PLAIN, 30));
        
        JLabel textUse = new JLabel("Cree un usuario y contraseña");
        textUse.setBounds(100, 160, 250, 30);
        textUse.setFont(new Font("Inter", Font.PLAIN, 14));
        textRegister.setFont(new Font("Inter", Font.PLAIN, 30));
        
        userField = new PlaceholderTextField("Usuario", 20);
        userField.setBounds(100, 210, 200, 30);
        userField.setFont(new Font("Inter", Font.PLAIN, 12));
        
        passField = new PlaceholderPassField("Contraseña", 20);
        passField.setBounds(100, 250, 200, 30);
        passField.setFont(new Font("Inter", Font.PLAIN, 12));

        //Creación del botón redondeado
        //Creación del botón redondeado
        JButton registerButton = new RoundedButton("Registrarse");
        registerButton.setBounds(125, 300, 150, 30);
        
        registerButton.setBackground(new Color(100, 149, 237));
        registerButton.setForeground(Color.WHITE);
        registerButton.setFocusPainted(false);
        registerButton.setFont(new Font("Inter", Font.PLAIN, 14));


         //Funcionalidad del botón. Registra 
        registerButton.addActionListener(new RegisterAction());

        
        //Agregar elementos al panel de registro
        register.add(textRegister);
        register.add(textUse);
        register.add(userField);
        register.add(passField);
        register.add(registerButton);    

        
        //Se agregan los paneles al panel principal
        panelRegister.add(descRegister, BorderLayout.WEST);
        panelRegister.add(register, BorderLayout.EAST);

        //Regresa el panel con todo el contenido
        return panelRegister;
    }
    
    //Cambia la vista del panel
    private void CambiarVista(JPanel panel){
        //Elimina el contenido del panel de contenido
        frame.getContentPane().removeAll();
        //Agrega el nuevo panel
        frame.add(panel);
        frame.revalidate();
        frame.repaint();        
        //Enfoca la ventana al iniciar para evitar que enfoque otros elementos
        SwingUtilities.invokeLater(() -> {
            frame.requestFocusInWindow(); 
        });        

    }
    
    //Ejecucción del botón registro
    private class RegisterAction implements ActionListener{
        public void actionPerformed(ActionEvent e) {
            //Obtener el usuario y la contraseña de los campos correspondientes            
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            //Verifica si el usuario o la contraseña están vacíos
            if (user.isEmpty() || pass.isEmpty()) {
                //Muestra mensaje de error con un panel personalizado
                new WindowError("Usuario y contraseña no pueden estar vacíos");
                //Si el usuario ya existe
            } else if (users.containsKey(user)) {
                new WindowError("El usuario ya existe");
                //Si no existe el usuario y los datos están completos
            } else {
                users.put(user, pass);
                new WindowMessage("Usuario registrado exitosamente", 200, 40);
               CambiarVista(MostrarLogIn());
            }
            
        }
    }
    
    //Hace visible de nuevo la ventana de logIn
    public void mostrarVentana(){
        frame.setVisible(true);
    }
    
    public static LogIn getInstancia(){
        return instancia;
    }
            
    //Ejecución del botón de Inicio de sesión
    private class LogInAction implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //Obtener el usuario y la contraseña de los campos correspondientes
            String user = userField.getText();
            String pass = new String(passField.getPassword());

            //Verifica si el usuario existe y si coindice la contrasela
            if (users.containsKey(user) && users.get(user).equals(pass)) {
                //Limpia el userField y passwordFiield;
                userField.setText("");
                passField.setText("");
                //Oculta la ventana
                frame.dispose();
                
                //Inicio de sesión exitoso y abre el menú                                
                new Menu(frame);
            } else {
                //Muestra mensaje de error
                new WindowError("Usuario o contraseña incorrectos");
                
            }
        }
    }
}