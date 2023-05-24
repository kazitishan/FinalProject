import java.util.ArrayList;
import java.util.Collections;

public class PremierLeague {
    private Club[] table;
    private Game[][] fixtures;
    private ArrayList<Game> allGames;
    private int gameWeek;

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
                "Leeds United",
                "Leicester City",
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
                if (!home.equals(away)){
                    allGames.add(new Game(home, away));
                }
            }
        }

        // using generate fixtures method to make the fixture list
        fixtures = new Game[38][10];
        generateFixtures();

        // making game week
        gameWeek = 0;
    }







    // getters and setters:
    public Club[] getTable() {
        return table;
    }

    public void setTable(Club[] table) {
        this.table = table;
    }

    public Game[][] getFixtures() {
        return fixtures;
    }

    public void setFixtures(Game[][] fixtures) {
        this.fixtures = fixtures;
    }

    public ArrayList<Game> getAllGames() {
        return allGames;
    }

    public void setAllGames(ArrayList<Game> allGames) {
        this.allGames = allGames;
    }

    public int getGameWeek() {
        return gameWeek;
    }

    public void setGameWeek(int gameWeek) {
        this.gameWeek = gameWeek;
    }






    public void generateFixtures(){
        for (int week = 0; week < 38; week++){
            System.out.println("GAME WEEK " + (week + 1));
            ArrayList<Club> teamsPlayedThisWeek = new ArrayList<Club>();

            for (int game = 0; game < 10; game++){
                ArrayList<Game> possibleGames = new ArrayList<Game>();
                // getting all possible games based on the teams that have not played this week yet
                for (Game g : allGames){
                    if (!g.contains(teamsPlayedThisWeek)){
                        possibleGames.add(g);
                    }
                }

                // getting a random game from the possible games
                int num = (int) (Math.random() * possibleGames.size());;
                Game randomGame = possibleGames.get(num);

                // removing the teams that are in the game from the teams that have not played this week
                teamsPlayedThisWeek.add(randomGame.getHome());
                teamsPlayedThisWeek.add(randomGame.getAway());

                fixtures[week][game] = randomGame;
                System.out.print(allGames.indexOf(randomGame) + " ");
                allGames.remove(randomGame);

                System.out.println((game + 1) + ". " +  randomGame + " " + teamsPlayedThisWeek.size() + " " + possibleGames.size());
            }
        }

        for (Game g : allGames){
            System.out.println(g);
        }
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

    public void simulateGameWeek(){
        for (Game game : fixtures[gameWeek]){
            game.simulateGame();
        }
        gameWeek++;
    }

    public Club get(String club){
        for (Club team : table){
            if (team.getName().equals(club)) return team;
        }
        return null;
    }
}
