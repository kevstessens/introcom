import javax.swing.*;
import net.miginfocom.swing.MigLayout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;


public class MainPanel extends JPanel {
    
    private  JTextField textField;
    private AudioController audioController;
    String[] lettersArray;
    String[] audioArray;
    
    public MainPanel() {
        audioController = new AudioController();
        buildUi();
    }

    private void buildUi() {


        setLayout(new MigLayout("fillx, insets 20 10 10 20, wrap 3"));
        JLabel label = createLabel("Sintesis de Habla");
        Font newLabelFont = new Font("Calibri", Font.BOLD, 25);
        label.setForeground(Color.getHSBColor(106, 172, 252));
        label.setFont(newLabelFont);

        JLabel label1 = new JLabel("A continuación usted debera ingresar una palabra que 4 letras que contengas A,P,B o T");
        add(label1, "wrap, span 2");

        JLabel label2 = new JLabel("Ingrese la palabra:");
        add(label2);

        textField = new JTextField();
        
        add(textField, "pushx,growx, wrap");
        

        
        JButton ok =  new JButton("Ok");
        ok.setBackground(Color.DARK_GRAY);
        add(ok, "span 2, align right");
        
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                
                String text = textField.getText();
                lettersArray = new String[text.length()];

               String[] allWords= text.split(" ");
                

                for(int i=0; i< text.length(); i++ ){

                    lettersArray[i]=text.substring(i,i+1);

                }

                audioArray = audioController.getAudio(lettersArray);


                for (String anAudioArray : audioArray) {
                    System.out.println(anAudioArray);
                }



            File concatenateAudio = audioController.concatenateAudio(audioArray, text);
            audioController.listenAudio(concatenateAudio);
            }
        });

       
        
    }

    private JLabel createLabel(String text) {
        return new JLabel(text, SwingConstants.CENTER);
    }


}
