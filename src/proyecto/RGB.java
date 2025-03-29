package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeListener;

//La clase heredada de un JPanel. Panel personalizado
public class RGB extends JPanel {  
    //Atributos del código.
    private JSlider redSlider, greenSlider, blueSlider;
    private JCheckBox enableCheckBox;
    private JPanel colorPanel;
    
    public RGB() {
        //Configuración del diseño del panel
        setLayout(new BorderLayout());
        setBackground(Color.WHITE);
        
        // Panel para mostrar el color (centro)
        colorPanel = new JPanel();
        colorPanel.setBackground(Color.BLACK);
        colorPanel.setPreferredSize(new Dimension(200, 200));
        add(colorPanel, BorderLayout.CENTER);
        
        // Sliders RGB
        redSlider = new JSlider(0, 255, 0);
        greenSlider = new JSlider(0, 255, 0);
        blueSlider = new JSlider(0, 255, 0);
        
        // Configuración de los sliders
        configureSlider(redSlider);
        configureSlider(greenSlider);
        configureSlider(blueSlider);
        
        // Checkbox
        enableCheckBox = new JCheckBox("Habilitar", true);
        enableCheckBox.setBackground(Color.WHITE);
        enableCheckBox.addItemListener(e -> updateColor());
        
        // Panel de controles (abajo derecha)
        JPanel controlPanel = new JPanel();
        controlPanel.setBackground(Color.WHITE);
        controlPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5); // Espaciado
        
        // Agregar componentes al panel de control
        gbc.gridx = 0;
        gbc.gridy = 0;
        controlPanel.add(new JLabel("Rojo:"), gbc);
        gbc.gridy = 1;
        controlPanel.add(new JLabel("Verde:"), gbc);
        gbc.gridy = 2;
        controlPanel.add(new JLabel("Azul:"), gbc);
        
        gbc.gridx = 1;
        gbc.gridy = 0;
        controlPanel.add(redSlider, gbc);
        gbc.gridy = 1;
        controlPanel.add(greenSlider, gbc);
        gbc.gridy = 2;
        controlPanel.add(blueSlider, gbc);
        
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        controlPanel.add(enableCheckBox, gbc);
        
        // Panel contenedor para alinear abajo-derecha
        JPanel southPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        southPanel.setBackground(Color.WHITE);
        southPanel.add(controlPanel);
        add(southPanel, BorderLayout.SOUTH);
        
        // Listeners para los sliders
        ChangeListener slideListener = e -> updateColor();
        redSlider.addChangeListener(slideListener);
        redSlider.setBackground(Color.WHITE);
        greenSlider.addChangeListener(slideListener);
        greenSlider.setBackground(Color.WHITE);
        blueSlider.addChangeListener(slideListener);
        blueSlider.setBackground(Color.WHITE);        
    }
    
    //Configuración del slider
    private void configureSlider(JSlider slider) {
        slider.setMajorTickSpacing(50);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setPreferredSize(new Dimension(150, 50));
    }
    
    //Actualiza el color del panel
    private void updateColor() {
        //Verifica si está seleccionado el checkbox para hacer el cambio de color
        if (enableCheckBox.isSelected()) {
            int red = redSlider.getValue();
            int green = greenSlider.getValue();
            int blue = blueSlider.getValue();
            colorPanel.setBackground(new Color(red, green, blue));
        } else {
            //Color negro si no está activo el checkbox
            colorPanel.setBackground(Color.BLACK);
        }
    }
}