import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 05/11/13
 * Time: 10:40
 */
public class Concatenador {

    public void concatenar(Vuelo vuelo){
        Audio audio = new Audio();

        String pathElVueloNumero = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\el vuelo numero.wav";
        audio.ejecutarAudio(pathElVueloNumero);

        char[] numVuelo = Integer.toString(vuelo.getNumVuelo()).toCharArray();
        ArrayList pathNumeroVuelo = new ArrayList();
        for (int i = 0; i < (numVuelo.length); i++){
            char caracter = numVuelo[i];
            switch (caracter){
                case '0': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\0.wav");
                    break;
                case '1': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\1.wav");
                    break;
                case '2': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\2.wav");
                    break;
                case '3': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\3.wav");
                    break;
                case '4': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\4.wav");
                    break;
                case '5': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\5.wav");
                    break;
                case '6': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\6.wav");
                    break;
                case '7': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\7.wav");
                    break;
                case '8': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\8.wav");
                    break;
                case '9': pathNumeroVuelo.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\9.wav");
                    break;
            }
        }
        for (int i = 0; i < pathNumeroVuelo.size(); i++){
            audio.ejecutarAudio((String)pathNumeroVuelo.get(i));
        }

        String pathConDestinoA = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\con destino a.wav";
        audio.ejecutarAudio(pathConDestinoA);

        String destino = vuelo.getDestino();
        String pathDestino = "";
        if (destino.equals("Cordoba")) {
            pathDestino = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\cordoba.wav";

        } else if (destino.equals("Salta")) {
            pathDestino = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\salta.wav";

        } else if (destino.equals("Ushuaia")) {
            pathDestino = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\ushuaia.wav";

        } else if (destino.equals("Jujuy")) {
            pathDestino = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\jujuy.wav";

        } else if (destino.equals("Misiones")) {
            pathDestino = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\misiones.wav";

        }

        audio.ejecutarAudio(pathDestino);

        String pathPartiraElDia = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\partira el dia.wav";
        audio.ejecutarAudio(pathPartiraElDia);

        Date date = vuelo.getFechaDePartida();
        Calendar fechaDeSalida = Calendar.getInstance();
        fechaDeSalida.setTime(date);
        int anioDeSalida = fechaDeSalida.get(Calendar.YEAR) - 1900;
        int mesDeSalida = fechaDeSalida.get(Calendar.MONTH);
        int diaDeSalida = fechaDeSalida.get(Calendar.DAY_OF_MONTH);

        String pathDiaDeSalida = "";
        switch (diaDeSalida){
            case 1: pathDiaDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\primero.wav";
                break;
            case 2: pathDiaDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\2.wav";
                break;
            case 10: pathDiaDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\10.wav";
                break;
            case 20: pathDiaDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\20.wav";
                break;
            case 30: pathDiaDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\30.wav";
                break;
        }
        String pathMesDeSalida = "";
        switch (mesDeSalida){
            case 1: pathMesDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\enero.wav";
                break;
            case 2: pathMesDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\febrero.wav";
                break;
            case 8: pathMesDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\agosto.wav";
                break;
            case 0: pathMesDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\diciembre.wav";
                break;
        }
        String pathAnioDeSalida = "";
        switch (anioDeSalida){
            case 2013: pathAnioDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\2013.wav";
                break;
            case 2014: pathAnioDeSalida = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\2014.wav";
                break;
        }
        audio.ejecutarAudio(pathDiaDeSalida);

        String pathDe = "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP5b - Sintesis de habla\\audio\\de.wav";
        audio.ejecutarAudio(pathDe);

        audio.ejecutarAudio(pathMesDeSalida);

        audio.ejecutarAudio(pathDe);

        audio.ejecutarAudio(pathAnioDeSalida);
    }
}
