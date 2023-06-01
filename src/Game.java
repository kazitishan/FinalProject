import java.util.ArrayList;

public class Game {
    private Club home;
    private Club away;
    private int homeGoals;
    private int awayGoals;
    private boolean played;

    public Game(){
        home = null;
        away = null;
        homeGoals = 0;
        awayGoals = 0;
        played = false;
    }

    public Game(Club home, Club away){
        this.home = home;
        this.away = away;
        played = false;
    }

    public Game(String game){
        home = new Club(game.substring(0,game.indexOf(" v ")));
        away = new Club(game.substring(game.indexOf(" v ") + 3));
        homeGoals = 0;
        awayGoals = 0;
        played = false;
    }

    public Club getHome() {
        return home;
    }

    public void setHome(Club home) {
        this.home = home;
    }

    public Club getAway() {
        return away;
    }

    public void setAway(Club away) {
        this.away = away;
    }

    public int getHomeGoals() {
        return homeGoals;
    }

    public void setHomeGoals(int homeGoals) {
        this.homeGoals = homeGoals;
    }

    public int getAwayGoals() {
        return awayGoals;
    }

    public void setAwayGoals(int awayGoals) {
        this.awayGoals = awayGoals;
    }

    public void simulateGame(){
        homeGoals = (int) (Math.random() * 8);
        awayGoals = (int) (Math.random() * 8);
        played = true;

        home.addGoalsScored(homeGoals);
        away.addGoalsScored(awayGoals);

        home.addGoalsConceded(awayGoals);
        away.addGoalsConceded(homeGoals);

        if (homeGoals > awayGoals){
            home.win();
            away.lose();
        }
        else if (awayGoals > homeGoals){
            away.win();
            home.lose();
        }
        else {
            home.draw();
            away.draw();
        }
    }

    public Club getWinner(){
        if (homeGoals > awayGoals) return home;
        if (awayGoals > homeGoals) return away;
        return null;
    }

    public Club getPredictedScoreResult(int homeGoals, int awayGoals){
        if (homeGoals > awayGoals) return home;
        if (awayGoals > homeGoals) return away;
        return null;
    }

    public String toString(){
        if (played){
            return home.getName() + " " + homeGoals + " - " + awayGoals + " " + away.getName();
        }
        return home.getName() + " vs. " + away.getName();
    }

    public boolean contains(ArrayList<Club> teams){
        for (Club team : teams){
            if (team.equals(home)) return true;
            if (team.equals(away)) return true;
        }
        return false;
    }

    public boolean contains(Club team){
        if (team.equals(home)) return true;
        if (team.equals(away)) return true;
        return false;
    }
}
