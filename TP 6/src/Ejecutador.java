import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 12/11/13
 * Time: 12:38
 */
public class Ejecutador {

    public static void main(String[] args) {
        Audio audio = new Audio();
        LectorDeDatos lector = new LectorDeDatos();

        String palabra = Integer.toString(lector.leer("Ingresar palabra: "));
        char[] lstPalabra = palabra.toCharArray();

        ArrayList concatenacion = new ArrayList();

        for (int i = 0; i < lstPalabra.length; i++){
            char letra = lstPalabra[i];

            if (i == 0){
                switch (letra){
                    case 'p': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_p (patata).wav");
                        break;
                    case 't': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_t (tutu).wav");
                        break;
                    case 'a': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_a (apesta).wav");
                        break;
                    case 'e': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_e (epifania).wav");
                        break;
                    case 'i': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_i (ipesa).wav");
                        break;
                    case 'o': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_o (otro).wav");
                        break;
                    case 'u': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\_u (upa).wav");
                        break;
                }
            }else if (i != lstPalabra.length - 1){
                char letraAnterior = lstPalabra[i-1];
                if (letraAnterior == 'p'){
                    switch (letra){
                        case 'a': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\pa (patata).wav");
                            break;
                        case 'e': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\pe (petete).wav");
                            break;
                        case 'i': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\pi (piti).wav");
                            break;
                        case 'o': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\po (popurri).wav");
                            break;
                        case 'u': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\pu (popurri).wav");
                            break;
                    }
                }else if (letraAnterior == 't'){
                    switch (letra){
                        case 'a': concatenacion.add(i, "C:\\Users\\skylight\\Documents\\GitHub\\introcom\\TP 6\\audio\\ta (apesta).wav");
                            break;
                    }
                }
            }
        }


    }
}
