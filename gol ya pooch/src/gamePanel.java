import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
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

public class gamePanel extends JPanel {
    final int block = 48;
    final int screenWidth = 20 * block;
    final int screenHeight = 15 * block;

    final int button1X = 4 * block;
    final int button1Y = 10 * block;

    int button2X = 13 * block;
    int button2Y = 10 * block;

    ImageIcon fist1, fist2;
    BufferedImage Mehran, backGround;

    public winPanel win;
    public loosePanel loose;

    boolean gameReset = false;

    

    

    public int gamesetup;
    public int gameFinal;
    JFrame f;
    

    public gamePanel(JFrame frame) {
        

        this.f = frame;
        win = new winPanel(screenWidth, screenHeight, f, this);
        loose = new loosePanel(screenWidth, screenHeight, f, this);

        
        getImages();
        gamesetup = -1;
        gameFinal = -1;
        gameSetup();

        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.RED);
        this.setLayout(null);

        //labels(this);
        addButton(this);



        if(gameReset)
        {
            f.getContentPane().removeAll();
            f.add(this);
            f.revalidate();
            f.repaint();
        }
        
        
    }

    public void gameSetup() {
        Random rand = new Random();
        gamesetup = rand.nextInt(2) + 1;
    }

    public void labels(JPanel jp) {
        JLabel lab1 = new JLabel("گل یا پوچ");
        lab1.setBounds(8 * block, 2 * block, 5 * block, 2 * block);
        lab1.setFont(new Font("Arial", Font.BOLD, 40));
        jp.add(lab1);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        // Draw the images first (background)
       drawMain(g2d);
    }

    public void drawMain(Graphics2D g) {
        g.drawImage(backGround, 0, 0, screenWidth, screenHeight, null);

        g.drawImage(Mehran, 4*block, 1*block ,12*block, 12*block, null);
       
    }

    

    public void getImages() {
        fist1 = new ImageIcon("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\left.png");
        fist2 = new ImageIcon("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\right.png");
        try {
            backGround = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\back-export.png"));
            Mehran = ImageIO.read(new File("C:\\Users\\TUF\\Desktop\\gol ya pooch\\src\\images\\golya.jpg"));

        } catch(IOException e) {
            e.printStackTrace();
        }
    }
    public void lateGame()
    {
        if(gameFinal == 1)
        {
            f.getContentPane().removeAll();
            f.add(win);
            f.revalidate();
            f.repaint();
        }
        if(gameFinal == 0)
        {
            f.getContentPane().removeAll();
            f.add(loose);
            f.revalidate();
            f.repaint();
        }
    }

    public void addButton(JPanel jp) {
        JButton button1 = new JButton("chap");
        JButton button2 = new JButton("rast");

        button1.setBorderPainted(false);
        button2.setBorderPainted(false);

        button1.setIcon(fist1);
        button2.setIcon(fist2);
        
        button1.setBackground(Color.RED);
        button2.setBackground(Color.RED);
        


        button1.setBounds(button1X,  button1Y, 3 * block, 3 * block);
        button2.setBounds(button2X, button2Y, 3 * block, 3 * block);

        button1.setContentAreaFilled(false); 
        button1.setBorderPainted(false);
        button1.setFocusPainted(false);

        button2.setContentAreaFilled(false); 
        button2.setBorderPainted(false);
        button2.setFocusPainted(false);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gamesetup == 1) {
                    gameFinal = 1;
                   
                } else if (gamesetup == 2) {
                    gameFinal = 0;
                    
                }
                lateGame();
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gamesetup == 2) {
                    gameFinal = 1;
                    

                   
                } else if (gamesetup == 1) {
                    gameFinal = 0;
                    
                }
                lateGame();
            }
        });

        jp.add(button1);
        jp.add(button2);
    }

    // lets override reset buttons
  

    
    
}
