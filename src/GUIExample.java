import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.FileNotFoundException;

public class GUIExample {
    private JFrame frame;
    private JPanel mainPanel;
    private JPanel namePanel;
    private JLabel nameLabel;
    private JTextField nameField;
    private JButton nextButton;
    private JPanel buttonPanel;
    private JLabel instructionLabel;
    private JPanel tablePanel;
    private GridLayout tableLayout;
    private JLabel[][] tableCells;

    public GUIExample() throws FileNotFoundException {
        initializeFrame();
        createMainPanel();
        createNamePanel();
        createButtonPanel();
        createBlankPanel();
        createInstructionLabel();

        frame.getContentPane().add(instructionLabel, BorderLayout.NORTH);
        frame.getContentPane().add(mainPanel, BorderLayout.CENTER);

        frame.setSize(1280, 720);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    private void initializeFrame() {
        frame = new JFrame("Kazi Bets");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout());
    }

    private void createMainPanel() {
        mainPanel = new JPanel(new CardLayout());
    }

    private void createNamePanel() {
        namePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));

        nameLabel = new JLabel("Enter your name:");
        nameField = new JTextField(20);
        nextButton = new JButton("Next");

        nextButton.addActionListener(e -> proceedToButtons());

        nameField.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    proceedToButtons();
                }
            }
        });

        namePanel.add(nameLabel);
        namePanel.add(nameField);
        namePanel.add(nextButton);

        mainPanel.add(namePanel, "NamePanel");
    }

    private void createButtonPanel() throws FileNotFoundException {
        buttonPanel = new JPanel(new GridLayout(4, 5));
        buttonPanel.setBackground(new Color(0, 255, 133));

        JButton[] buttons = new JButton[20];

        // Making user object
        Profile user = new Profile(nameField.getText());

        for (int i = 0; i < 20; i++) {
            String club = user.getEpl().getTable()[i].getName();
            buttons[i] = new JButton(club);
            buttons[i].setFont(new Font("Calibri", Font.BOLD, 13));
            buttons[i].setIcon(user.getEpl().get(club).getIcon());
            buttons[i].setBackground(new Color(56, 0, 60));
            buttons[i].setForeground(new Color(255, 255, 255));
            Border border = BorderFactory.createLineBorder(new Color(0, 255, 133), 2);
            buttons[i].setBorder(border);

            buttons[i].addActionListener(e -> showTable());

            buttonPanel.add(buttons[i]);
        }

        mainPanel.add(buttonPanel, "ButtonPanel");
    }

    private void createBlankPanel() {
        JPanel blankPanel = new JPanel();
        mainPanel.add(blankPanel, "BlankPanel");
    }

    private void createInstructionLabel() {
        instructionLabel = new JLabel("Enter your name.");
        instructionLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

    private void proceedToButtons() {
        String name = nameField.getText();
        instructionLabel.setText("Hello, " + name + "! Please choose a team to support.");
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.next(mainPanel);
        nameField.requestFocusInWindow();
    }

    private void showTable() {
        if (tablePanel != null) {
            mainPanel.remove(tablePanel);
        }

        tableLayout = new GridLayout(21, 8); // Increase row count by 1 to accommodate the header row
        tablePanel = new JPanel(new BorderLayout());

        // Top panel with "matchweek" label
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel matchweekLabel = new JLabel("Matchweek");
        topPanel.add(matchweekLabel);
        tablePanel.add(topPanel, BorderLayout.NORTH);

        // Left panel with buttons and text field
        JPanel leftPanel = new JPanel(new GridBagLayout());

        JTextField numberField = new JTextField();
        numberField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });

        JButton button1 = new JButton("Button 1");
        JButton button2 = new JButton("Button 2");
        JButton button3 = new JButton("Button 3");

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridy = 0;
        leftPanel.add(numberField, gbc);

        gbc.gridy = 1;
        gbc.weighty = 1.0;
        leftPanel.add(button1, gbc);

        gbc.gridy = 2;
        leftPanel.add(button2, gbc);

        gbc.gridy = 3;
        leftPanel.add(button3, gbc);

        tablePanel.add(leftPanel, BorderLayout.WEST);

        // Right panel with labels
        JPanel rightPanel = new JPanel(new GridBagLayout());

        GridBagConstraints rightGbc = new GridBagConstraints();
        rightGbc.fill = GridBagConstraints.HORIZONTAL;
        rightGbc.weightx = 1.0;
        rightGbc.gridx = 0;
        rightGbc.gridy = GridBagConstraints.RELATIVE;

        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel("Label " + (i + 1));
            rightPanel.add(label, rightGbc);
        }
        tablePanel.add(rightPanel, BorderLayout.EAST);

        JPanel tableContentPanel = new JPanel(tableLayout);
        tablePanel.add(tableContentPanel, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel(); // Empty panel for spacing
        tablePanel.add(bottomPanel, BorderLayout.SOUTH);

        tableCells = new JLabel[21][8]; // Increase row count by 1 to accommodate the header row

        // Header row
        String[] headers = {"#", "Team", "Pl", "W", "D", "L", "GD", "Pts"};
        for (int col = 0; col < 8; col++) {
            JLabel headerCell = new JLabel(headers[col]);
            headerCell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
            headerCell.setHorizontalAlignment(SwingConstants.CENTER);

            // Set colors for the headers
            if (col != 0) {
                headerCell.setOpaque(true);
                headerCell.setBackground(new Color(56, 0, 60));
                headerCell.setForeground(Color.WHITE);
            }

            tableContentPanel.add(headerCell);
            tableCells[0][col] = headerCell;
        }

        // Remaining rows
        for (int row = 1; row < 21; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel cell = new JLabel("");
                cell.setBorder(BorderFactory.createLineBorder(Color.BLACK));
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                tableContentPanel.add(cell);
                tableCells[row][col] = cell;
            }
        }

        mainPanel.add(tablePanel, "TablePanel");
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "TablePanel");
        frame.revalidate();
        frame.repaint();
    }


    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new GUIExample();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
