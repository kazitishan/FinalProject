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
    
    public void simulateGame(){

    }
}
