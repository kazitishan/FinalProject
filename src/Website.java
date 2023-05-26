import javax.swing.*;

public class Website extends JFrame {

    private JPanel mainPanel;
    private JTextField name;
    private JLabel welcome;

    public Website(){
        super("Kazi Bets");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(1280,720);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Website();
    }
}
