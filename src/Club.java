import java.util.ArrayList;

public class Club {
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private ArrayList<Club> teamsPlayedAtHome;
    private ArrayList<Club> teamsPlayedAway;

    public Club(String name){
        this.name = name;
        points = 0;
        wins = 0;
        draws = 0;
        loses = 0;
        teamsPlayedAtHome = new ArrayList<Club>();
        teamsPlayedAway = new ArrayList<Club>();
    }


    // getter and setters:


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public int getWins() {
        return wins;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public int getDraws() {
        return draws;
    }

    public void setDraws(int draws) {
        this.draws = draws;
    }

    public int getLoses() {
        return loses;
    }

    public void setLoses(int loses) {
        this.loses = loses;
    }

    public ArrayList<Club> getTeamsPlayedAtHome() {
        return teamsPlayedAtHome;
    }

    public void setTeamsPlayedAtHome(ArrayList<Club> teamsPlayedAtHome) {
        this.teamsPlayedAtHome = teamsPlayedAtHome;
    }

    public ArrayList<Club> getTeamsPlayedAway() {
        return teamsPlayedAway;
    }

    public void setTeamsPlayedAway(ArrayList<Club> teamsPlayedAway) {
        this.teamsPlayedAway = teamsPlayedAway;
    }


    // methods:


    public void playTeamAtHome(Club awayTeam){
        teamsPlayedAtHome.add(awayTeam);
    }

    public void playTeamAway(Club homeTeam){
        teamsPlayedAway.add(homeTeam);
    }

    public void win(){
        points += 3;
        wins++;
    }

    public void draw(){
        points += 1;
        draws++;
    }

    public void lose(){
        loses++;
    }
}
