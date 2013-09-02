import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: Lucas Ramos Oromi
 * Date: 26/08/13
 * Time: 17:36
 */

public class Filtro {

    public static void main(String[] args) {
        AudioSampleReader sampleReader;
        try {
            sampleReader = new AudioSampleReader(new File("uno.wav"));
            long nbSamples = sampleReader.getSampleCount() * sampleReader.getFormat().getChannels();
            System.out.println("nbChannel=" + sampleReader.getFormat().getChannels());
            System.out.println("frameRate=" + sampleReader.getFormat().getFrameRate());
            System.out.println("sampleSize=" + sampleReader.getFormat().getSampleSizeInBits());
            double[] samples = new double[(int)nbSamples];
            sampleReader.getInterleavedSamples(0, nbSamples, samples);
            double[] newSamples = new double[(int)nbSamples];

            // aplico la ec diferencial para hacer el filtro

            double a0 = 1, a1 = 0, a2 = 0, a3 = 0, a4 = 0, a5 =0, b1 = 0, b2 = 0, b3 = 0, b4 = 0;
            for (int i = 5; i < samples.length; i++) {
                newSamples[i] = a0 * samples[i] + a1 * samples[i-1] + a2 * samples[i-2] + a3 * samples[i-3] +
                        a4 * samples[i-4] + a5 * samples[i-5] - b1 * newSamples[i-1] - b2 * newSamples[i-2] -
                        b3 * newSamples[i-3] - b4 * newSamples[i-4];
            }

            File outFile = new File("filtrado.wav");
            AudioSampleWriter audioWriter = new AudioSampleWriter(outFile,
                    sampleReader.getFormat(), AudioFileFormat.Type.WAVE);
            audioWriter.write(samples);
            audioWriter.close();

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
