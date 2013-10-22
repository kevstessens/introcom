import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends JFrame{

    private JFrame frame;

    public MainFrame(String[] args){
        buildUi();
    }

    private void buildUi() {
        frame = new JFrame("Aplicación de Sintesis de habla");
        MainPanel mainPanel = new MainPanel();
        frame.add(mainPanel);
        frame.setVisible(true);
        frame.pack();

        frame.addWindowListener(new WindowAdapter()
        {
            @Override
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });

    }




}
