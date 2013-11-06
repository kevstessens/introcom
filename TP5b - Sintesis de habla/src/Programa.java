/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 13:56
 */
public class Programa {

    private Cliente[] clientes;
    private int numClientePedido;
    private Cliente clientePedido;


    public Programa(Cliente[] clientes){
        this.clientes = clientes;
    }

    public void ejecutar() {
        Audio audio = new Audio();
        LectorDeDatos lector = new LectorDeDatos();
        Concatenador concatenador = new Concatenador();

        String pathBienvenido = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\bienvenido.wav";
        audio.ejecutarAudio(pathBienvenido);


        String pathIngresarNumCliente = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\ingresar num cliente.wav";
        audio.ejecutarAudio(pathIngresarNumCliente);

        numClientePedido = lector.leer("Ingrese un número de cliente: ");
        while (!clienteEsta()){

            String pathClienteNoEncontrado = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\num cliente no encontrado.wav";
            audio.ejecutarAudio(pathClienteNoEncontrado);

            audio.ejecutarAudio(pathIngresarNumCliente);

            numClientePedido = lector.leer("Ingrese un número de cliente: ");
        }
        if (clientePedido.getVuelos() == null){

            String pathClienteNoTieneVuelos = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\cliente no tiene vuelos.wav";
            audio.ejecutarAudio(pathClienteNoTieneVuelos);

        }else {

            String pathIngresarNumVueloPedido = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\ingresar num vuelo.wav";
            audio.ejecutarAudio(pathIngresarNumVueloPedido);

            int numVueloPedido = lector.leer("Ingrese un número de vuelo: ");
            while (!clientePedido.tieneVuelo(numVueloPedido)){

                String pathVueloNoEncontrado = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\num vuelo no encontrado.wav";
                audio.ejecutarAudio(pathVueloNoEncontrado);

                audio.ejecutarAudio(pathIngresarNumVueloPedido);

                numVueloPedido = lector.leer("Ingrese un número de vuelo: ");
            }
            Vuelo vuelo = clientePedido.getVueloPedido();
            concatenador.concatenar(vuelo);
        }

        String pathSaludoFinal = "C:\\Users\\skylight\\Documents\\Lucas\\Fac\\Intro Com\\adios.wav";
        audio.ejecutarAudio(pathSaludoFinal);

    }

    private boolean clienteEsta(){
        for (int i = 0; i<clientes.length; i++){
            if (numClientePedido == clientes[i].getNumCliente()){
                clientePedido = clientes[i];
                return true;
            }
        }
        return false;
    }
}
