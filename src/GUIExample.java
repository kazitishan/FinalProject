import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class GUIExample {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton submitButton;
    private JPanel buttonPanel;
    private JLabel instructionLabel;

    public GUIExample() throws FileNotFoundException {
        frame = new JFrame("GUI Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());

        mainPanel = new JPanel(new CardLayout());

        // Create a panel for name input
        namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(20);
        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                instructionLabel.setText("Hello, " + name + "! Please choose a team to support.");
                CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                cardLayout.next(mainPanel);
            }
        });
        namePanel.add(nameLabel);
        namePanel.add(nameField);
        namePanel.add(submitButton);

        mainPanel.add(namePanel, "NamePanel");

        // Create a panel for button layout
        buttonPanel = new JPanel(new GridLayout(4, 5));
        JButton[] buttons = new JButton[20];
        Profile user = new Profile(nameField.getText());
        for (int i = 0; i < 20; i++) {
            buttons[i] = new JButton(user.getEpl().getTable()[i].getName());
            buttons[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
                    cardLayout.show(mainPanel, "BlankPanel");
                }
            });
            buttonPanel.add(buttons[i]);
        }

        mainPanel.add(buttonPanel, "ButtonPanel");

        // Create a panel for the blank screen
        JPanel blankPanel = new JPanel();
        mainPanel.add(blankPanel, "BlankPanel");

        // Create an instruction label
        instructionLabel = new JLabel("Enter your name.");
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);

        frame.getContentPane().add(instructionLabel, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    new GUIExample();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });
    }
}
