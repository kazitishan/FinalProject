public class PremierLeague {
    private Club[] table;
    private Game[][] fixtures;

    public PremierLeague(){
        table = new Club[20];
        fixtures = new Game[38][10];
        String[] clubs = {
                "Arsenal",
                "Aston Villa FC",
                "Bournemouth AFC",
                "Brentford",
                "Brighton & Hove Albion",
                "Chelsea",
                "Crystal Palace",
                "Everton",
                "Fulham",
                "Leicester City",
                "Leeds United",
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
        generateFixtures();
    }

    public void generateFixtures(){

    }

    public void sortTable(){

    }

}
