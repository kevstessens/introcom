import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import java.io.File;
import java.io.SequenceInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: keevstessens
 * To change this template use File | Settings | File Templates.
 */
public class GeneradorDePalabras {

    public static List<String> generarPalabra(String[] splitText) throws Exception {
        List<String> audio_files;
        List<String> words = new ArrayList<String>();

        for (String s : splitText) {
            audio_files = new ArrayList<String>();


            audio_files.add("_" + s.charAt(0) + ".wav");

            for(int i = 1; i < s.length(); i++){
                audio_files.add(s.charAt(i - 1) + "" + s.charAt(i) + ".wav");
            }

            audio_files.add(s.charAt(s.length() - 1) + "_.wav");

            concatenar(audio_files, s + ".wav");
            words.add(s + ".wav");

        }
        return words;

    }


    public static Boolean concatenar(List<String> sourceFilesList, String destinationFileName) throws Exception {
        Boolean result = false;

        AudioInputStream audioInputStream = null;
        List<AudioInputStream> audioInputStreamList = null;
        AudioFormat audioFormat = null;
        Long frameLength = null;

        try {
            // loop through our files first and load them up
            for (String sourceFile : sourceFilesList) {
                audioInputStream = AudioSystem.getAudioInputStream(new File("audio/" + sourceFile));

                // get the format of first file
                if (audioFormat == null) {
                    audioFormat = audioInputStream.getFormat();
                }

                // add it to our stream list
                if (audioInputStreamList == null) {
                    audioInputStreamList = new ArrayList<AudioInputStream>();
                }
                audioInputStreamList.add(audioInputStream);

                // keep calculating frame length
                if(frameLength == null) {
                    frameLength = audioInputStream.getFrameLength();
                }
                else {
                    frameLength += audioInputStream.getFrameLength();
                }
            }

            // now write our concatenated file
            AudioSystem.write(new AudioInputStream(new SequenceInputStream(Collections.enumeration(audioInputStreamList)), audioFormat, frameLength), AudioFileFormat.Type.WAVE, new File(destinationFileName));

            // if all is good, return true
            result = true;
        }
        catch (Exception e) {
            throw e;
        }
        finally {
            if (audioInputStream != null) {
                audioInputStream.close();
            }
            if (audioInputStreamList != null) {
                audioInputStreamList = null;
            }
        }

        return result;
    }
}
