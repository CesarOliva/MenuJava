package proyecto;

//Se importan las librerias a usar
import javax.swing.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Librerias personalizadas utilizadas
import elementos.PlaceholderTextField;
import elementos.WindowError;

//La clase heredada de un JPanel. Panel personalizado
public class Slider extends JPanel{
    public Slider() {
        //Configuración del diseño del panel
        setLayout(null);
        setBackground(Color.WHITE);
        
        //Creación y configuración de componentes
        JLabel label = new JLabel("Valor del slider: ");
        label.setBounds(200, 30, 150, 30);
        JSlider slider = new JSlider(0, 100, 50);
        slider.setMajorTickSpacing(10);
        slider.setMinorTickSpacing(5);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        slider.setBounds(20, 60, 500, 100);
        slider.setBackground(Color.WHITE);
        
        JTextField textField = new PlaceholderTextField("", 5);
        textField.setText("50");
        textField.setBounds(320,30, 50, 30);
        
        //Creación de checkbox
        JCheckBox checkBox = new JCheckBox("Activar Actualización automática", true);
        checkBox.setBounds(170, 170, 215, 30);
        checkBox.setBounds(20, 60, 500, 100);
        checkBox.setBackground(Color.WHITE);
        
        //Evento de accion al interactuar con el slider
        slider.addChangeListener(new ChangeListener(){
            @Override
            //Pendiente a cambios en el valor del slider
            public void stateChanged(ChangeEvent e){
                //Condición que se cumple cuando el checkbox está seleccionado
                if(checkBox.isSelected()){
                    int valor = slider.getValue();
                    //Actualiza el valor del slider en texto
                    label.setText("Valor del slider: "+valor);
                    textField.setText(String.valueOf(valor));
                }
            }
        });
        
        //Cambia el valor del slider
        textField.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //Intente cambiar el valor del slider
                try{
                    int valor = Integer.parseInt(textField.getText());
                    //Verifica que el valor sea valido
                    if(valor >=0 && valor <=100){
                        slider.setValue(valor);
                    }else{
                        //Muestra una ventana con información
                        new WindowError("Ingresa un dato del 1 al 100");
                    }
                // Captura el error si la conversión de String a número falla
                } catch (NumberFormatException ex) {
                    new WindowError("Ingrese un dato del tipo no requerido");
                }
            }
        });
        
        add(label);
        add(slider);
        add(textField);
        add(checkBox);
    }
}