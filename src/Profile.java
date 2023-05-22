public class Profile {
    private String name;
    private Club team;
    private BankAccount bank;
    private PremierLeague epl;


    public Profile(String name, String team){
        epl = new PremierLeague();
        this.name = name;
        this.team = epl.get(team);
        bank = new BankAccount(name);
    }

    public Profile(String name, Club team){
        epl = new PremierLeague();
        this.name = name;
        this.team = team;
        bank = new BankAccount(name);
    }

    public void betOnGame(double amount, Club winner){
        bank.withdraw(amount);
        epl.simulateGameWeek();
        Game game = new Game();
        for (Game g : epl.getFixtures()[epl.getGameWeek()]){
            if (g.contains(team)) game = g;
        }
        // if winner is predicted
        if (game.getWinner().getName().equals(winner.getName())){
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
        if ()
    }
}
