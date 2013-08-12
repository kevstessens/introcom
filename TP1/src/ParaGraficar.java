/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * Date: 06/08/13
 * Time: 12:10
 * To change this template use File | Settings | File Templates.
 */

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class ParaGraficar {

    public static void main(String[] args) {
        int tamanioFormatChunk = 0;
        int bytesExtra = 0;
        int indiceData;
        int tamanioDataChunk = 0;
        int comienzoDatos;
        boolean estaComprimido;

        try {
            Path path = Paths.get("fast.wav");
            byte[] data = Files.readAllBytes(path);

            if (("" + (char) data[0] + (char) data[1] + (char) data[2] + (char)data[3]).equals("RIFF"))
                System.out.println("Es un archivo RIFF");
            if (("" + (char) data[8] + (char) data[9] + (char) data[10] + (char) data[11]).equals("WAVE"))
                System.out.println("Es un archivo WAV");
            if (("" + (char)data[12] + (char)data[13] + (char)data[14]).equals("fmt")){
                tamanioFormatChunk = (data[16] + (data[17] * 256) + (data[18] * 65536) + (data[19] * 16777216));
                System.out.println("Tamaño de format chunk: " + tamanioFormatChunk);

                if ((data[20] + (data[21] * 256)) == 1){
                    estaComprimido = false;
                    System.out.println("El archivo no esta comprimido");
                }else {
                    estaComprimido = true;
                    System.out.println("El archivo esta comprimido");
                }
                System.out.println("Cantidad de canales de salida: " + (data[22] + (data[23] * 256)));
                System.out.println("Frecuencia: " + (data[24] + (data[25] * 256) + (data[26] * 65536) +
                        (data[27] * 16777216)));
                System.out.println("bPS: " + (data[34] + (data[35] * 256)));

                if (estaComprimido){
                    bytesExtra = (data[36] + (data[37] * 256));
                    System.out.println("Bytes de más: " + bytesExtra);
                }
            }


            indiceData = 19 + tamanioFormatChunk + bytesExtra + 1;
            if (("" + (char) data[indiceData] + (char) data[indiceData + 1] + (char) data[indiceData + 2] +
                    (char) data[indiceData + 3]).equals("data")){
                tamanioDataChunk = (data[indiceData + 4] + (data[indiceData + 5] * 256) +
                        (data[indiceData + 6] * 65536) + (data[indiceData + 7] * 16777216));
                System.out.println("Tamaño de data chunk: " + tamanioDataChunk);
            }

            if (tamanioDataChunk > 6000){
                tamanioDataChunk = 6000;
            }
            comienzoDatos = indiceData + 8;
            for(int i = comienzoDatos; i < tamanioDataChunk; i++){
                int i2 = data[i] & 0xFF;
                System.out.println(i2);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
