import javax.swing.*;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
//        JFrame frame = new JFrame("Image GUI Example");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//
//
//        JLabel imageLabel = new JLabel();
//
//        Club ex = new Club("Chelsea");
//        ImageIcon x = new ImageIcon(String.valueOf(ex.getIcon()));
//        frame.getContentPane().add(imageLabel);
//
//        frame.pack();
//        frame.setVisible(true);
        PremierLeague epl = new PremierLeague();
        epl.simulateGameWeek();
        int week = 1;
        for (Game[] gameweek : epl.getFixtures()){
            System.out.println("Gameweek " + week);
            for (Game game : gameweek){
                System.out.println(game);
            }
            week++;
            System.out.println();
        }
    }
}
