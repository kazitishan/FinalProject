import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class PremierLeague {
    private Club[] table;
    private Game[][] fixtures;
    private ArrayList<Game> allGames;
    private int gameWeek;

    public PremierLeague() throws FileNotFoundException {

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






    public void generateFixtures() throws FileNotFoundException {
        File fixturesFile = new File("src/Fixtures.txt");
        Scanner scan = new Scanner(fixturesFile);

        for (int week = 0; week < 38; week++){
            for (int game = 0; game < 10; game++){
                fixtures[week][game] = new Game(scan.nextLine());
                for (int team = 0; team < table.length; team++){
                    if (table[team].equals(fixtures[week][game].getHome())){
                        fixtures[week][game].setHome(table[team]);
                    }
                    if (table[team].equals(fixtures[week][game].getAway())){
                        fixtures[week][game].setAway(table[team]);
                    }
                }
            }
        }

        List<Game[]> fixturesList = Arrays.asList(fixtures);
        Collections.shuffle(fixturesList);
        fixtures = fixturesList.toArray(new Game[fixturesList.size()][]);

        // printing the fixtures
//        int week = 1;
//        for (Game[] gameweek : fixtures){
//            System.out.println("Gameweek " + week);
//            for (Game game : gameweek){
//                System.out.println(game);
//            }
//            week++;
//            System.out.println();
//        }
    }

    public void sortTable(){
        //table = sortedTable;

        ArrayList<Club> tempTable = new ArrayList<>(Arrays.asList(table));
        ArrayList<Club> sortedTable = new ArrayList<Club>();

        Club highest = ;
        for (int team = 0; team < tempTable.size(); team++){
            if (tempTable.get(team).getPoints() > highest.getPoints()){
                highest
            }

        }

    }

    public void simulateGameWeek(){
        for (Game game : fixtures[gameWeek]){
            game.simulateGame();
        }
        gameWeek++;
        sortTable();
    }

    public void simulateSeason(){
        for (int i = 0; i < 38; i++){
            simulateGameWeek();
        }
    }

    public Club get(String club){
        for (Club team : table){
            if (team.getName().equals(club)) return team;
        }
        return null;
    }
}
