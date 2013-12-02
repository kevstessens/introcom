import javax.swing.*;
import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * To change this template use File | Settings | File Templates.
 */

public class Sistema {

    public static void main(String[] args) throws Exception {

        Integer result = 1;
        String text;

        while(result != 0){


            System.out.println("1. Ingresar palabras con A-E-I-O-U-P-T");
            System.out.println("0. Salir");
            Scanner scanner = new Scanner(System.in);
            result = scanner.nextInt();

            switch (result){
                case 0:
                    break;

                case 1:
                    text = JOptionPane.showInputDialog("Ingrese palabra: ");

                    Reproductor.reproducir(GeneradorDePalabras.generarPalabra(text.split("\\s+")));


                    break;

                default:
                    System.out.println("Hubo un error");
            }
        }
    }

}
