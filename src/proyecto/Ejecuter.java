package proyecto;

//importa las librerias necesarias
import javax.swing.*;

//Clase principal que ejecuta el Inicio de sesión. 
public class Ejecuter {
    public static void main(String[] args){
        JFrame frame = new JFrame("LogIn");
        //Ejecuta el inicio de sesión al iniciar el programa
        new LogIn(frame);
    }
}