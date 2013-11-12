import javax.sound.sampled.*;
import java.io.File;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 12/11/13
 * Time: 12:36
 */
public class Audio {

    public void ejecutarAudio(String path) {
        try {
            File f = new File(path);
            AudioInputStream audio = AudioSystem.getAudioInputStream(f);
            AudioFormat format;
            format = audio.getFormat();
            SourceDataLine auline;
            DataLine.Info info = new DataLine.Info(SourceDataLine.class, format);
            auline = (SourceDataLine) AudioSystem.getLine(info);
            auline.open(format);
            auline.start();
            int nBytesRead = 0;
            byte[] abData = new byte[524288];
            while (nBytesRead != -1) {
                nBytesRead = audio.read(abData, 0, abData.length);
                if (nBytesRead >= 0) {
                    auline.write(abData, 0, nBytesRead);
                }
            }
        } catch (Exception E) {
            System.out.println(E.getMessage());

        }
    }
}
