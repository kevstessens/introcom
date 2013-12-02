
import java.io.File;
import java.io.SequenceInputStream;
import java.util.Vector;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;


public class AudioController {


//    public static void main(String[] args) {
//
//        String[] audioArray = {"Bata","Papa","Baba","Tata"};
//        listenAudio(concatenateAudio(audioArray));
//
//
//
//
//    }

    public void listenAudio(File concatenate) {

        try {

            // Se obtiene un Clip de sonido
            Clip sonido = AudioSystem.getClip();

            // Se carga con un fichero wav
            sonido.open(AudioSystem.getAudioInputStream(concatenate));

            // Comienza la reproducción
            sonido.start();

            // Espera mientras se esté reproduciendo.
            while (sonido.isRunning())
                Thread.sleep(1000);

            // Se cierra el clip.
            sonido.close();
        } catch (Exception e) {
            System.out.println("" + e);
        }
    }
    

    public  File concatenateAudio(String[] audioArray, String fileName) {
        try {
            Vector<AudioInputStream> finalAudio = new Vector<AudioInputStream>();
            int frameLength = 0;
          
            for (String anAudioArray : audioArray) {
                AudioInputStream audio = getAudio(anAudioArray);
                finalAudio.addElement(audio);
                frameLength += audio.getFrameLength();
            }

            AudioInputStream appendedFiles =
                    new AudioInputStream(
                            new SequenceInputStream(finalAudio.elements()),
                            finalAudio.get(0).getFormat(),
                            frameLength);
            
            AudioSystem.write(appendedFiles,
                    AudioFileFormat.Type.WAVE,
                    new File("audio/"+fileName+".wav"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return new File("audio/"+fileName+".wav");

    }

    public String[] getAudio(String[] lettersArray) {

        String[] audioArray = new String[lettersArray.length];

        if(lettersArray[0].equals("A") || lettersArray[0].equals("a")){
            audioArray[0]="Sil_A";
        }else if(lettersArray[0].equals("B") || lettersArray[0].equals("b")){
            audioArray[0]="Sil_B";
        }else if(lettersArray[0].equals("P") || lettersArray[0].equals("p")){
            audioArray[0]="Sil_P";
        }
        else{
            audioArray[0]="Sil_T";
        }


        for(int i =1; i<lettersArray.length-1; i++){

            if(lettersArray[i].equals("B") || lettersArray[i].equals("b")){
                audioArray[i]="B_A2";
            }
            else if(lettersArray[i].equals("P") || lettersArray[i].equals("p")){
                if(lettersArray[i+1].equals("A") || lettersArray[i+1].equals("a")){
                    audioArray[i]="P_A";
                }else{
                    audioArray[i]="P_T";
                }
            }else if(lettersArray[i].equals("T") || lettersArray[i].equals("t")){
                audioArray[i]="T_A";
            }else{
                if(lettersArray[i+1].equals("T") || lettersArray[i+1].equals("t")){
                    audioArray[i]="A_T";
                }else if(lettersArray[i+1].equals("B") || lettersArray[i+1].equals("b")){
                    audioArray[i]="A_B";
                }else{
                    audioArray[i]="A_P";
                }
            }
        }
        audioArray[lettersArray.length-1]="A_Sil";

        return audioArray;
    }

    public AudioInputStream getAudio(String name){

        try {
            return AudioSystem.getAudioInputStream(new File("audio/" + name + ".wav"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

}
