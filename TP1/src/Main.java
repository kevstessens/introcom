import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;

public class Main {

    public static void main(String[] args) {
        PrintWriter pw = null;

        try {
            Path path = Paths.get("about_time.wav");
            byte[] data = Files.readAllBytes(path);
            System.out.println("Freq 11025");
            System.out.println("Mono");
            System.out.println("1 BPS");
            File file = new File("fast.wav");
            FileWriter fw = new FileWriter(file, false);
            pw = new PrintWriter(fw);

            FileReader inputStream = null;
            FileWriter outputStream = null;

            inputStream = new FileReader("uno.wav");
            outputStream = new FileWriter("dos.wav");


            for(int i=0; i<72; i++){
                outputStream.write(inputStream.read());
            }
            for(int j=71; j<200; j++){
                System.out.println(inputStream.read());
                inputStream.read();
                outputStream.write(inputStream.read());
            }
                    inputStream.close();
                    outputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (pw != null) {
                pw.close();
            }
        }
    }
}
