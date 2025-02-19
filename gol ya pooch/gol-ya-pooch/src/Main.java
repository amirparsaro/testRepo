import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        var frame = new JFrame("Hello, java");
        frame.setSize(300, 150);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        var label = new JLabel("Hello, Java!", JLabel.CENTER);
        frame.add(label);

        frame.setVisible(true);
    }
}