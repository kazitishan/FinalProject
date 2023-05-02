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
            Game[] gameWeek = new Game[10];

            boolean validGame = false;
            for (int game = 0; game < 10; game++){
                while (validGame == false){
                    int random = (int) (Math.random() * allGames.size()) + 1;
                    Game randomGame = allGames.get(random);
                    for (Game g : gameWeek){
                        if (g != null){
                            if (g.getHome().equals(randomGame.g))
                        }
                    }
                }
            }


            fixtures[week] = gameWeek;
        }
    }

    public void sortTable(){

    }

}
