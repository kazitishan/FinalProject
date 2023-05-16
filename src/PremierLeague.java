import java.util.ArrayList;
import java.util.Collections;

public class PremierLeague {
    private Club[] table;
    private Game[][] fixtures;
    private ArrayList<Game> allGames;

    public PremierLeague(){

        // adding every club in the premier league into an array
        table = new Club[20];
        String[] clubs = {
                "Arsenal",
                "Aston Villa",
                "Bournemouth",
                "Brentford",
                "Brighton & Hove Albion",
                "Chelsea",
                "Crystal Palace",
                "Everton",
                "Fulham",
                "Leicester City",
                "Leeds United",
                "Liverpool",
                "Manchester City",
                "Manchester United",
                "Newcastle United",
                "Nottingham Forest",
                "Southampton",
                "Tottenham Hotspur",
                "West Ham United",
                "Wolverhampton Wanderers"};
        for (int club = 0; club < clubs.length; club++){
            table[club] = new Club(clubs[club]);
        }

        // making an arrayList of every game to be played in the season
        allGames = new ArrayList<Game>();
        for (Club home : table){
            for (Club away : table){
                if (!home.getName().equals(away.getName())){
                    allGames.add(new Game(home, away));
                }
            }
        }

        // using generate fixtures method to make the fixture list
        fixtures = new Game[38][10];
        generateFixtures();
    }

    public void generateFixtures(){
        for (int week = 0; week < 38; week++){
            ArrayList<Club> teamsPlayedThisWeek = new ArrayList<Club>();
            for (int game = 0; game < 10; game++){
                int num = (int) (Math.random() * allGames.size());;
                Game randomGame = allGames.get(num);
                if (teamsPlayedThisWeek.size() > 0){
                    for (int team = 0; team < teamsPlayedThisWeek.size(); team++){
                        if (randomGame.contains(teamsPlayedThisWeek.get(team))){
                            num = (int) (Math.random() * allGames.size());;
                            randomGame = allGames.get(num);
                        }
                    }
                }
                teamsPlayedThisWeek.add(randomGame.getHome());
                teamsPlayedThisWeek.add(randomGame.getAway());
                fixtures[week][game] = randomGame;
                allGames.remove(num);
            }
        }

        for (int row = 0; row < fixtures.length; row++){
            System.out.println("Game week " + (row + 1));
            for (int col = 0; col < fixtures[0].length; col++){
                System.out.println(fixtures[row][col].toString());
            }
            System.out.println();
        }

        System.out.println(allGames.size());
    }

    public void sortTable(){
        while (inOrder() == false){
            for (int team = 0; team < table.length; team++){
                Club current;
            }
        }
    }

    public boolean inOrder(){
        for (int team = 0; team < table.length - 1; team++){
            if (table[team].getPoints() < table[team + 1].getPoints()) return false;
            if (table[team].getPoints() == table[team + 1].getPoints()){
                if (table[team].getGoalDifference() < table[team + 1].getGoalDifference()) return false;
            }
        }
        return true;
    }

    public void swap(int index1, int index2){
        Club temp = table[index1];

    }
}
