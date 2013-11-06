import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 16:11
 */
public class Ejecutador {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente(2354);
        cliente1.agregarVuelo(new Vuelo(907, "Salta", new Date(2014, 2, 10)));
        cliente1.agregarVuelo(new Vuelo(714, "Jujuy", new Date(2013,12,30)));

        Cliente cliente2 = new Cliente(629);
        cliente2.agregarVuelo(new Vuelo(203, "Ushuaia", new Date(2014, 8, 20)));
        cliente2.agregarVuelo(new Vuelo(409, "Misiones", new Date(2014, 1, 1)));


        Cliente[] clientes = {cliente1,cliente2};
        Programa programa = new Programa(clientes);

        programa.ejecutar();

    }
}
