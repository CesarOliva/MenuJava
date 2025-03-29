package elementos;

//Importa las librerías necesarias 
import java.awt.*;
import java.awt.event.ActionEvent;
import javax.swing.*;

//Clase WindowError del tipo JFrame. Frame personalizado
public class WindowMessage extends JFrame {
    public WindowMessage(String text, int heightW, int heightC) {
        //Configuración de la ventana 
        setTitle("Error");
        setSize(300, heightW);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        
        //Creación del Panel
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setLayout(null);

        //Creación de los elementos de información
        JLabel icon = new JLabel(new ImageIcon(getClass().getResource("/elementos/info.png")));
        icon.setBounds(70, 20, 50, 50);
        
        JLabel info = new JLabel("Información");
        info.setBounds(130, 5, 150, 80);
        info.setFont(new Font("Inter", Font.PLAIN, 16));
        info.setForeground(Color.BLACK);
        
        JTextPane datos = new JTextPane();
        datos.setContentType("text/html");
        datos.setText("<html>"
                + "<p style='font-family:Inter; font-size:10px; font-weight:400; color:#000; text-align:center'>"+text+"</p>");
        datos.setBounds(0, 70, 300, heightC);
        datos.setMargin(new Insets(0, 20, 0, 20));
        datos.setEditable(false);
        datos.setFocusable(false);

        JButton button = new RoundedButton("OK");

        button.setBackground(new Color(100, 149, 237));
        button.setForeground(Color.WHITE);
        button.setBounds(115, heightW-80, 70, 30);
        
        button.addActionListener((ActionEvent e)->{
            dispose();
        });

        //Agrega los elementos al panel 
        panel.add(icon);
        panel.add(info);
        panel.add(datos);
        panel.add(button);

        //Hace visible el frame
        add(panel);
        setVisible(true);
    }
}