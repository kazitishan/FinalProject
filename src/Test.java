public class Test {
    public static void main(String[] args) {
        PremierLeague epl = new PremierLeague();
        epl.generateFixtures();
        int random = (int) (Math.random() * 10) + 1;
        System.out.println(random);
    }
}
