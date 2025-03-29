package elementos;

//Importa las librerías necesarias 
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

//Clase WindowError del tipo JFrame. Frame personalizado
public class WindowError extends JFrame {
    public WindowError(String text) {
        //Configuración de la ventana 
        setTitle("Error");
        setSize(300, 180);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Creación del Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        //Creación de los elementos de error
        JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/elementos/error.png")));
        icon.setBounds(30, 20, 50, 50);

        JTextPane error = new JTextPane();
        error.setContentType("text/html");
        error.setText("<html>"
                + "<p style='font-family:Inter; font-size:10px; font-weight:400; color:#000; text-align:center'>"+text+"</p>");
        error.setBounds(100, 5, 150, 80);
        error.setEditable(false);
        error.setFocusable(false);

        JButton button = new RoundedButton("OK");

        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setBounds(115, 100, 70, 30);
        
        button.addActionListener((ActionEvent e)->{
            dispose();
        });

        //Agrega los elementos al panel 
        panel.add(icon);
        panel.add(error);
        panel.add(button);

        //Hace visible el frame
        add(panel);
        setVisible(true);
    }
}