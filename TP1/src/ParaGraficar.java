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
        PrintWriter pw = null;

        try {
            Path path = Paths.get("about_time.wav");
            byte[] data = Files.readAllBytes(path);
            System.out.println("Freq 11025");
            System.out.println("Mono");
            System.out.println("1 BPS");

            for(int i=71; i<1000; i++){
                int i2 = data[i] & 0xFF;
                System.out.println(i2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }    }
}
