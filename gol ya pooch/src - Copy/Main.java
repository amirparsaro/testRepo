import java.awt.Color;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Main {

    

    public static void main(String[] args) {
        
        //gamePanel gp = new gamePanel();
        final int block = 48;
        final int screeenWidth = 20*block;
        final int sceenHeight = 15*block;

         JFrame frame = new JFrame();
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         gamePanel gp = new gamePanel(frame);
         frame.setBackground(Color.BLACK);

         frame.setSize(screeenWidth, sceenHeight);
         frame.setTitle("pedram");
         frame.setResizable(false);
         
         ImageIcon img = new ImageIcon("luff_left1.png");
         frame.setIconImage(img.getImage());

         frame.add(gp); 
          frame.setVisible(true); 
         
    }
}