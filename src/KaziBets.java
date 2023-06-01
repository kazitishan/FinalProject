import javax.swing.*;
import java.awt.*;

public class KaziBets extends JFrame{
    JLabel kaziBets = new JLabel("Kazi Bets");
    JPanel panel = new JPanel();
    public KaziBets(){
        this.setTitle("Kazi Bets");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(750, 750);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(0,255,133));

        panel.setBackground(new Color(56,0,60));
        panel.setBounds(0, 0, 100, 100);

        kaziBets.setHorizontalAlignment(JLabel.CENTER);
        kaziBets.setVerticalAlignment(JLabel.TOP);
        kaziBets.setForeground(new Color(255,255,255));
        kaziBets.setFont(new Font("Arial", Font.BOLD, 50));

        panel.add(kaziBets);
        this.add(panel);
        //this.pack();
    }

    public static void main(String[] args) {
        new KaziBets();
    }
}
