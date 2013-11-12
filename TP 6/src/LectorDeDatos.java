import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 12/11/13
 * Time: 12:37
 */
public class LectorDeDatos {

    public int leer (String datoAIngresar){
        Scanner entrada = new Scanner(System.in);
        System.out.print(datoAIngresar);
        int num = entrada.nextInt();
        return num;
    }
}
