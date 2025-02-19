import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class winPanel extends JPanel{


    int block = 48;
    final int width;
    final int height;

     ImageIcon button;
    BufferedImage win;
   public JButton resButton;
   JFrame f;
   gamePanel gp;

    public winPanel(int width, int height, JFrame frame, gamePanel gp)
    {
      this.f = frame;
      this.gp = gp;
      


        this.height = height-block;
        this.width = width-block;
       this.setSize(new Dimension(this.width, this.height));
       this.setBackground(Color.GREEN);
       this.setLayout(null);
       
       layot(this);
       getImage();
       setButton(this);


    }

    public void getImage()
    {

        try {
            button = new ImageIcon("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\reButton.png");
            win = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\photo17107106894.jpg"));
            
        } catch (IOException e) {
            
            e.printStackTrace();
        }
    } 
    
    @Override
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        
        g.drawImage(win, 4*block, 1*block, 12*block, 6*block, null);

    }
    
    public void layot(JPanel jp) {
        JLabel labe = new JLabel();
        Random r = new Random();
        int rand = r.nextInt(3) + 1;
        switch (rand) {
          case 1:
          {
            labe.setText("دسخوشششش");
            break;
          }
          case 2:
          {
            labe.setText("بردی ولی نوبت مام میشه");
            break;
          }
          case 3:
          {
            labe.setText("you win but how ?");
            break;
          }
        }

        labe.setForeground(Color.BLACK);
        labe.setFont(new Font("Arial", Font.BOLD, 50));

        labe.setBounds(8*block, 6*block, 10*block, 5*block);
        

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
        label.setForeground(Color.BLACK);
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
