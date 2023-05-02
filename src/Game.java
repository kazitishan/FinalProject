public class Game {
    private Club home;
    private Club away;
    private int homeGoals;
    private int awayGoals;

    public Game(Club home, Club away){
        home.playTeamAtHome(away);
        away.playTeamAway(home);
        this.home = home;
        this.away = away;
        homeGoals = 0;
        awayGoals = 0;
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

    }

    public String toString(){
        return home.getName() + " vs. " + away.getName();
    }
}
