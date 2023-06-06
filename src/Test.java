import javax.swing.*;
import java.io.FileNotFoundException;

public class Test {
    public static void main(String[] args) throws FileNotFoundException {
        PremierLeague epl = new PremierLeague();
        epl.simulateSeason();
        int week = 1;
        for (Game[] gameweek : epl.getFixtures()){
            System.out.println("Gameweek " + week);
            for (Game game : gameweek){
                System.out.println(game);
            }
            week++;
            System.out.println();
        }

        int position = 1;
        for (Club team : epl.getTable()){
            System.out.print(position + ". ");
            System.out.println(team.getName() + " " + team.getPoints() + " " +team.getGoalDifference());
            position++;
        }
    }
}
