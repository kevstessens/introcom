import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 13:29
 */
public class Vuelo {
    private int numVuelo;
    private String destino;
    private Date fechaDePartida;

    public Vuelo(int numVuelo, String destino, Date fechaDePartida){
        this.numVuelo = numVuelo;
        this.destino = destino;
        this.fechaDePartida = fechaDePartida;
    }

    public int getNumVuelo(){
        return numVuelo;
    }

    public String getDestino(){
        return destino;
    }

    public Date getFechaDePartida(){
        return fechaDePartida;
    }
}
