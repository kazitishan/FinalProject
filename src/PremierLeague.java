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
                boolean validGame = false;
                int num = 0;
                Game randomGame = new Game(new Club(""), new Club(""));
                while (validGame == false){
                    num = (int) (Math.random() * allGames.size());
                    randomGame = allGames.get(num);
                    if (teamsPlayedThisWeek.contains(randomGame.getHome()) || teamsPlayedThisWeek.contains(randomGame.getAway()))
                }
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

//        for (int week = 0; week < 38; week++){
//            Game[] gameWeek = new Game[10];
//
//            for (int game = 0; game < 10; game++){
//                gameWeek[0] = new Game(new Club("temp"), new Club("temp2"));
//                int random = (int) (Math.random() * (allGames.size()) - 1) + 1;
//                Game randomGame = allGames.get(random);
//                boolean validGame = false;
//                while (validGame == false){
//                    for (Game g : gameWeek){
//                        if (g != null){
//                            if (!g.getHome().getName().equals(randomGame.getHome().getName())    &&    !g.getHome().getName().equals(randomGame.getAway().getName())    &&    !g.getAway().getName().equals(randomGame.getHome().getName())    &&     !g.getAway().getName().equals(randomGame.getAway().getName())) {
//                                validGame = true;
//                            }
//                        }
//                    }
//                }
//                gameWeek[game] = randomGame;
//            }
//
//            fixtures[week] = gameWeek;
//        }
//
//        for (int gameWeek = 0; gameWeek < fixtures.length; gameWeek++){
//            System.out.println("GAMEWEEK " + (gameWeek + 1));
//            for (Game g : fixtures[gameWeek]){
//                System.out.println(g.toString());
//            }
//            System.out.println();
//        }
    }

    public void sortTable(){

    }

}
