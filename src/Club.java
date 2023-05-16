import java.util.ArrayList;

public class Club implements Comparable{
    private String name;
    private int points;
    private int wins;
    private int draws;
    private int loses;
    private int goalsScored;
    private int goalsConceded;

    public Club(String name){
        this.name = name;
        points = 0;
        wins = 0;
        draws = 0;
        loses = 0;
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

    public int getGoalsScored() {
        return goalsScored;
    }

    public int getGoalsConceded() {
        return goalsConceded;
    }

    public int getGoalDifference(){
        return goalsScored - goalsConceded;
    }

    // methods:

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

    @Override
    public int compareTo(Object team) {
        if (team instanceof Club){

        }
        return 0;
    }
}
