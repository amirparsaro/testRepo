import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.Buffer;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.print.DocFlavor.READER;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class loosePanel extends JPanel {
    int height;
    int width;
    int block = 48;

    BufferedImage troll;
    ImageIcon button;
   public JButton resButton;
   JFrame f;
   gamePanel gp;
    
    public loosePanel(int width, int height, JFrame frame, gamePanel gp)
    {
        this.f = frame;
        this.gp = gp;

        this.height = height-block;
        this.width = width-block;
       this.setSize(new Dimension(this.width, this.height));
       this.setLayout(null);
       this.setBackground(Color.BLACK);
       layot(this);
       getImage();
       setButton(this);
    }
    public void getImage()
    {
        try {
            troll = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\Troll face 😲.jpg"));
            button = new ImageIcon("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\reButton.png");
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    } 
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.drawImage(troll, 4*block, 1*block, 10*block, 5*block, null);

    }
    
    public void layot(JPanel jp) {
        JLabel labe = new JLabel();
        Random r = new Random();
        int rand = r.nextInt(3) + 1;
        switch (rand) {
           case 1:
           {
             labe.setText("مال این حرفا نیستی");
             break;
           }
           case 2:
           {
             labe.setText("بازم باختی ");
             break;
           }
           case 3:
           {
             labe.setText("برو خونتون");
             break;
           }
        }
        
        labe.setForeground(Color.WHITE);
        labe.setFont(new Font("Arial", Font.BOLD, 50));
       
        labe.setBounds(5*block, 6*block, 10*block, 2*block);

        jp.add(labe);
        
    }
    
    public void setButton(JPanel p)
    {
        resButton = new JButton();

       resButton.setBounds(5*block, 10*block, 6*block, 3*block);
       resButton.setIcon(button);
        resButton.setContentAreaFilled(false); 
       resButton.setBorderPainted(false);
       resButton.setFocusPainted(false);
       

        
        JLabel label = new JLabel();
        label.setText("TRY AGAIN");
        label.setFont(new Font("ARIAL", Font.BOLD, 40));
        label.setBounds(1*block, 0, 5*block, 4*block);

        resButton.add(label);
        p.add(resButton);

         resButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            gp.gameSetup();
            f.getContentPane().removeAll();
            f.add(gp);
            f.revalidate();
            f.repaint();
            
            
         
        }
    });
        
    }
   
    
}
