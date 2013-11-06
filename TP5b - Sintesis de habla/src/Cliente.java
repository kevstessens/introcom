/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 12:57
 */
public class Cliente {

    private int numCliente;
    private Vuelo[] vuelos = new Vuelo[100];
    private int cantidadDeVuelos = 0;
    private Vuelo vueloPedido;

    public Cliente(int numCliente){
        this.numCliente = numCliente;
    }

    public void agregarVuelo(Vuelo vuelo){
        vuelos[cantidadDeVuelos] = vuelo;
        cantidadDeVuelos ++;
    }

    public int getNumCliente(){
        return numCliente;
    }

    public Vuelo[] getVuelos(){
        return vuelos;
    }

    public boolean tieneVuelo(int numVuelo){
        for (int i = 0; i < cantidadDeVuelos; i++){
            if (vuelos[i].getNumVuelo() == numVuelo){
                vueloPedido = vuelos[i];
                return true;
            }
        }
        return false;
    }

    public Vuelo getVueloPedido(){
        return vueloPedido;
    }
}
