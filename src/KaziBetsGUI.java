import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.Scanner;

public class KaziBetsGUI {
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
    private JPanel leftPanel;
    private JPanel rightPanel;
    private String userName;
    private Profile user;

    public KaziBetsGUI() throws FileNotFoundException {
        user = new Profile();
        initializeFrame();
        createMainPanel();
        createNamePanel();
        createButtonPanel();
        createBlankPanel();
        createInstructionLabel();

        // Add components to the frame
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

        for (int i = 0; i < 20; i++) {
            String club = user.getEpl().getTable()[i].getName();
            buttons[i] = new JButton(club);
            buttons[i].setFocusable(false);
            buttons[i].setFont(new Font("Calibri", Font.BOLD, 13));
            buttons[i].setIcon(user.getEpl().get(club).getIcon());
            buttons[i].setBackground(new Color(56, 0, 60));
            buttons[i].setForeground(new Color(255, 255, 255));
            Border border = BorderFactory.createLineBorder(new Color(0, 255, 133), 2);
            buttons[i].setBorder(border);

            int index = i;
            buttons[i].addActionListener(e -> {
                user.setFavoriteTeam(buttons[index].getText());
                showTable(userName);
            });

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
        userName = nameField.getText();
        user.setName(userName);
        instructionLabel.setText("Hello, " + userName + "! Please choose a team to support.");
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.next(mainPanel);
        nameField.requestFocusInWindow();
    }

    private void showTable(String userName) {
        if (tablePanel != null) {
            mainPanel.remove(tablePanel);
        }

        tableLayout = new GridLayout(21, 8); // Increase row count by 1 to accommodate the header row
        tablePanel = new JPanel(new BorderLayout());

        // Top panel with "matchweek" label
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel matchweekLabel = new JLabel("Matchweek " + (user.getEpl().getGameWeek() + 1));
        topPanel.add(matchweekLabel);
        tablePanel.add(topPanel, BorderLayout.NORTH);

        // Left panel with buttons, label, and text field
        leftPanel = new JPanel(new GridBagLayout());

        JLabel homeVsAwayLabel = new JLabel(user.getCurrentGame().toString());
        JTextField numberField = new JTextField();
        numberField.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) && c != '.') {
                    e.consume();
                }
            }
        });

        JButton win = new JButton(user.getTeam().getName() + " Win");
        JButton draw = new JButton("Draw");
        JButton loss = new JButton(user.getTeam().getName() + " Loss");

        win.setFocusable(false);
        draw.setFocusable(false);
        loss.setFocusable(false);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridy = 0;
        gbc.insets = new Insets(0, 0, 10, 0); // Add bottom insets for spacing
        leftPanel.add(homeVsAwayLabel, gbc);

        gbc.gridy = 1;
        gbc.insets = new Insets(0, 0, 10, 0); // Add bottom insets for spacing
        leftPanel.add(numberField, gbc);

        gbc.gridy = 2;
        gbc.insets = new Insets(0, 0, 5, 0); // Add bottom insets for spacing
        leftPanel.add(win, gbc);

        gbc.gridy = 3;
        leftPanel.add(draw, gbc);

        gbc.gridy = 4;
        gbc.insets = new Insets(5, 0, 0, 0); // Add top insets for spacing
        leftPanel.add(loss, gbc);

        tablePanel.add(leftPanel, BorderLayout.WEST);

        // Right panel with labels
        rightPanel = new JPanel(new GridBagLayout());

        GridBagConstraints rightGbc = new GridBagConstraints();
        rightGbc.fill = GridBagConstraints.HORIZONTAL;
        rightGbc.weightx = 1.0;
        rightGbc.gridx = 0;
        rightGbc.gridy = GridBagConstraints.RELATIVE;

        JLabel[] gameLabels = new JLabel[10];

        for (int i = 0; i < 10; i++) {
            JLabel label = new JLabel(user.getCurrentGameWeek()[i].toString());
            rightPanel.add(label, rightGbc);
            gameLabels[i] = label;
        }

        // Calculate the width of the panels based on the frame size
        int frameWidth = frame.getWidth();
        int middlePanelWidth = frameWidth / 2;
        int rightPanelWidth = frameWidth / 4;
        int leftPanelWidth = frameWidth / 4;

        // Set the preferred sizes for the panels
        leftPanel.setPreferredSize(new Dimension(leftPanelWidth, leftPanel.getPreferredSize().height));
        rightPanel.setPreferredSize(new Dimension(rightPanelWidth, rightPanel.getPreferredSize().height));

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
            headerCell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
            headerCell.setHorizontalAlignment(SwingConstants.CENTER);
            headerCell.setOpaque(true);
            headerCell.setBackground(new Color(56, 0, 60));
            headerCell.setForeground(Color.WHITE);
            tableContentPanel.add(headerCell);
            tableCells[0][col] = headerCell;
        }

        // Remaining rows
        for (int row = 1; row < 21; row++) {
            for (int col = 0; col < 8; col++) {
                JLabel cell = new JLabel("");
                cell.setBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY));
                cell.setHorizontalAlignment(SwingConstants.CENTER);
                tableContentPanel.add(cell);
                tableCells[row][col] = cell;

                if (col == 0) {
                    cell.setOpaque(true);
                    cell.setBackground(new Color(56, 0, 60));
                    cell.setForeground(Color.WHITE);
                }
            }
        }

        fillTable();

        tableContentPanel.setPreferredSize(new Dimension(middlePanelWidth, tableContentPanel.getPreferredSize().height));

        mainPanel.add(tablePanel, "TablePanel");
        instructionLabel.setText(user.getName() + " - " + user.getTeam().getName() + " - $" + user.getBalance());
        CardLayout cardLayout = (CardLayout) mainPanel.getLayout();
        cardLayout.show(mainPanel, "TablePanel");
        frame.revalidate();
        frame.repaint();

        // Button actions
        win.addActionListener(e -> {
            if (user.getEpl().getGameWeek() <= 37 && isValidNumberField(numberField.getText())) {
                double betAmount = Double.parseDouble(numberField.getText());
                if (betAmount <= user.getBalance()) {
                    homeVsAwayLabel.setText(user.getCurrentGame().toString());
                    matchweekLabel.setText("Matchweek " + (user.getEpl().getGameWeek() + 1));
                    for (int i = 0; i < 10; i++) {
                        gameLabels[i].setText(user.getCurrentGameWeek()[i].toString());
                    }
                    user.betOnGame(betAmount, user.getTeam());
                    fillTable();
                    instructionLabel.setText(user.getName() + " - " + user.getTeam().getName() + " - $" + user.getBalance());
                }
            }
            else if (user.getEpl().getGameWeek() == 38 || user.getBalance() == 0){
                File highestScore = new File("src/HighestScore.txt");
                Scanner scan = null;
                try {
                    scan = new Scanner(highestScore);
                } catch (FileNotFoundException ex) {
                    throw new RuntimeException(ex);
                }

                double profit = user.getBalance() - 100;

                String line = scan.nextLine();
                double highestProfit = 0;
                if (line.equals("none")){
                    highestProfit = profit;
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(highestScore, false));
                        writer.write(highestProfit + "");
                        writer.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
                else{
                    highestProfit = Double.parseDouble(line);
                }


                if (profit > highestProfit) {
                    highestProfit = profit;
                    try {
                        BufferedWriter writer = new BufferedWriter(new FileWriter(highestScore, false));
                        writer.write(highestProfit + "");
                        writer.close();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }

                bottomPanel.removeAll();
                JLabel resultLabel = new JLabel("Profit: " + profit + " | Highest Profit: " + highestProfit);
                resultLabel.setFont(new Font("Calibri", Font.BOLD, 16));
                bottomPanel.add(resultLabel);
                bottomPanel.revalidate();
                bottomPanel.repaint();
            }
        });

        draw.addActionListener(e -> {
            if (user.getEpl().getGameWeek() <= 37 && isValidNumberField(numberField.getText())) {
                double betAmount = Double.parseDouble(numberField.getText());
                if (betAmount <= user.getBalance()) {
                    user.betOnGame(betAmount, null);
                    fillTable();
                    instructionLabel.setText(user.getName() + " - " + user.getTeam().getName() + " - $" + user.getBalance());
                    homeVsAwayLabel.setText(user.getCurrentGame().toString());
                    matchweekLabel.setText("Matchweek " + (user.getEpl().getGameWeek() + 1));

                    for (int i = 0; i < 10; i++) {
                        gameLabels[i].setText(user.getCurrentGameWeek()[i].toString());
                    }
                }
            }
            else if (user.getEpl().getGameWeek() == 38 || user.getBalance() == 0){
                bottomPanel.removeAll();
                JLabel resultLabel = new JLabel("L loser!");
                resultLabel.setFont(new Font("Calibri", Font.BOLD, 16));
                resultLabel.setForeground(Color.RED);
                bottomPanel.add(resultLabel);
                bottomPanel.revalidate();
                bottomPanel.repaint();
            }
        });

        loss.addActionListener(e -> {
            if (user.getEpl().getGameWeek() <= 37 && isValidNumberField(numberField.getText())) {
                double betAmount = Double.parseDouble(numberField.getText());
                if (betAmount <= user.getBalance()) {
                    Club predictedWinner;
                    if (user.getCurrentGame().getHome().equals(user.getTeam())) {
                        predictedWinner = user.getCurrentGame().getAway();
                    } else {
                        predictedWinner = user.getCurrentGame().getHome();
                    }

                    user.betOnGame(betAmount, predictedWinner);
                    fillTable();
                    instructionLabel.setText(user.getName() + " - " + user.getTeam().getName() + " - $" + user.getBalance());
                    homeVsAwayLabel.setText(user.getCurrentGame().toString());
                    matchweekLabel.setText("Matchweek " + (user.getEpl().getGameWeek() + 1));

                    for (int i = 0; i < 10; i++) {
                        gameLabels[i].setText(user.getCurrentGameWeek()[i].toString());
                    }
                }
            }
            else if (user.getEpl().getGameWeek() == 38 || user.getBalance() == 0){
                bottomPanel.removeAll();
                JLabel resultLabel = new JLabel("L loser!");
                resultLabel.setFont(new Font("Calibri", Font.BOLD, 16));
                resultLabel.setForeground(Color.RED);
                bottomPanel.add(resultLabel);
                bottomPanel.revalidate();
                bottomPanel.repaint();
            }
        });

    }

    private boolean isValidNumberField(String input) {
        String decimalPattern = "\\d+(\\.\\d{1,2})?";
        return input.matches(decimalPattern);
    }


    /**
     * Fills the table with data from the Premier League simulation.
     */
    public void fillTable() {
        Club[] info = user.getEpl().getTable();
        int position = 0;
        for (int row = 1; row < 21; row++) {
            tableCells[row][0].setText(row + "");
            tableCells[row][1].setText(info[position].getName());
            tableCells[row][2].setText(user.getEpl().getGameWeek() + "");
            tableCells[row][3].setText(info[position].getWins() + "");
            tableCells[row][4].setText(info[position].getDraws() + "");
            tableCells[row][5].setText(info[position].getLoses() + "");
            tableCells[row][6].setText(info[position].getGoalDifference() + "");
            tableCells[row][7].setText(info[position].getPoints() + "");
            position++;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                new KaziBetsGUI();
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
