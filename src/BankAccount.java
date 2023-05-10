public class BankAccount {
    private String accountHolder;
    private double balance;

    public BankAccount(String name){
        accountHolder = name;
    }

    public String getAccountHolder() {
        return accountHolder;
    }

    public void setAccountHolder(String accountHolder) {
        this.accountHolder = accountHolder;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void betOnGame(double amount, Club winner, Game game){

    }

    public void betOnGame(double amount, int homeGoals, int awayGoals, Club winner, Game game){
        game.simulateGame();
        //if (game.getWinner() == winner)
    }
}
