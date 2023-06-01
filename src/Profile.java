import java.io.FileNotFoundException;

public class Profile {
    private String name;
    private Club team;
    private BankAccount bank;
    private PremierLeague epl;


    public Profile(String name, String team) throws FileNotFoundException {
        epl = new PremierLeague();
        this.name = name;
        this.team = epl.get(team);
        bank = new BankAccount(name);
    }

    public Profile(String name, Club team) throws FileNotFoundException {
        epl = new PremierLeague();
        this.name = name;
        this.team = team;
        bank = new BankAccount(name);
    }

    public Profile(String name) throws FileNotFoundException {
        epl = new PremierLeague();
        this.name = name;
        bank = new BankAccount(name);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Club getTeam() {
        return team;
    }

    public void setTeam(Club team) {
        this.team = team;
    }

    public BankAccount getBank() {
        return bank;
    }

    public void setBank(BankAccount bank) {
        this.bank = bank;
    }

    public PremierLeague getEpl() {
        return epl;
    }

    public void setEpl(PremierLeague epl) {
        this.epl = epl;
    }

    public void setFavoriteTeam(String team){
        this.team = epl.get(team);
    }

    public void betOnGame(double amount, Club winner){
        bank.withdraw(amount);
        epl.simulateGameWeek();
        Game game = new Game();
        for (Game g : epl.getFixtures()[epl.getGameWeek()]){
            if (g.contains(team)) game = g;
        }
        // if result of the game is predicted
        if (game.getWinner().equals(winner)){
            amount *= 1.5;
            bank.deposit(amount);
        }
    }

    public void betOnGame(double amount, int homeGoals, int awayGoals){
        bank.withdraw(amount);
        epl.simulateGameWeek();
        Game game = new Game();
        for (Game g : epl.getFixtures()[epl.getGameWeek()]){
            if (g.contains(team)) game = g;
        }

        Club winner = game.getPredictedScoreResult(homeGoals, awayGoals);

        // if result of the game is predicted
        if (game.getWinner().equals(winner)){
            amount *= 2;
            bank.deposit(amount);
        }
    }
}
