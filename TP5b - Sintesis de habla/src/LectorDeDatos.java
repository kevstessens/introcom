import java.util.Scanner;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 10:52
 */
public class LectorDeDatos {

    public int leer (String datoAIngresar){
        Scanner entrada = new Scanner(System.in);
        System.out.print(datoAIngresar);
        int num = entrada.nextInt();
        return num;
    }
}
