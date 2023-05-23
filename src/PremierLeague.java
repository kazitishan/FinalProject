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
            ArrayList<Club> teamsNotPlayedThisWeek = new ArrayList<Club>();
            ArrayList<Game> possibleGames = new ArrayList<Game>();
            for (Club c : table){
                teamsNotPlayedThisWeek.add(c);
            }
            for (int game = 0; game < 10; game++){
                // getting all possible games based on the teams that have not played this week yet
                for (Game g : allGames){
                    if (g.contains(teamsNotPlayedThisWeek)){
                        possibleGames.add(g);
                    }
                }

                // getting a random game from the possible games
                int num = (int) (Math.random() * possibleGames.size());;
                Game randomGame = possibleGames.get(num);

                // removing the teams that are in the game from the teams that have not played this week
                teamsNotPlayedThisWeek.remove(randomGame.getHome());
                teamsNotPlayedThisWeek.remove(randomGame.getAway());
                fixtures[week][game] = randomGame;
                allGames.remove(randomGame);
                System.out.println((game + 1) + ". " +  randomGame + " " + teamsNotPlayedThisWeek.size() + " " + allGames.size());
            }
        }

        for (Game g : allGames){
            System.out.println(g);
        }

//        for (int row = 0; row < fixtures.length; row++){
//            System.out.println("Game week " + (row + 1));
//            for (int col = 0; col < fixtures[0].length; col++){
//                System.out.println(fixtures[row][col].toString());
//            }
//            System.out.println();
//        }
//
//        System.out.println(allGames.size());
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
