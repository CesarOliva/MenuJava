package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;

//La clase heredada de un JPanel. Panel personalizado
public class TamañoElemento extends JPanel {
    
    //Atributos del código
    private int circleSize = 50; // Tamaño inicial del círculo
    private JPanel drawingPanel;
    private boolean showCircle = true; // Controla si el círculo se muestra

    public TamañoElemento() {
    
        setBackground(Color.WHITE);
        // Crear el slider
        JSlider slider = new JSlider(JSlider.HORIZONTAL, 0, 300, 50);
        slider.setMajorTickSpacing(50);
        slider.setMinorTickSpacing(25);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBackground(Color.WHITE);

        // Crear el checkbox
        JCheckBox showCircleCheckBox = new JCheckBox("Mostrar Círculo", true);
        showCircleCheckBox.setBackground(Color.WHITE);
        
        // Panel para los controles
        JPanel controlPanel = new JPanel();
        controlPanel.add(slider);
        controlPanel.add(showCircleCheckBox);
        controlPanel.setBackground(Color.WHITE);

        // Panel para dibujar el círculo
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                if (showCircle) { // Solo dibujar si showCircle es true
                    int x = (getWidth() - circleSize) / 2;
                    int y = (getHeight() - circleSize) / 2;
                    g.setColor(Color.BLUE);
                    g.fillOval(x, y, circleSize, circleSize);
                }
            }
        };
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        drawingPanel.setBackground(Color.WHITE);
        // Listener para el slider
        slider.addChangeListener(e -> {
            circleSize = slider.getValue();
            drawingPanel.repaint();
        });

        // Listener para el checkbox
        showCircleCheckBox.addActionListener(e -> {
            showCircle = showCircleCheckBox.isSelected();
            drawingPanel.repaint();
        });

        // Añadir componentes a la ventana
        add(controlPanel, BorderLayout.SOUTH);
        add(drawingPanel, BorderLayout.CENTER);

        //Hace visible el frame
        SwingUtilities.invokeLater(() -> {
            TamañoElemento frame = new TamañoElemento();
            frame.setBackground(Color.WHITE);
            frame.setVisible(true);
        });
    }
}