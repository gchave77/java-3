package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning reasoning = new Reasoning();
        reasoning.start();
        System.out.println("Start Reasoning thread");

        String[] team = new String[]{"Emilios @epapas", "gabe chavez", "Abigail Swigert", "Abram Jablonski", "Adam Rice", "christian", "devonbrewster42", "Jose Moreno", "Julian Ladd", "Marcelo Barbosa", "Michael Kinney", "Monica Howard", "Phoenix Megan Shane"};
        TeamTC1 team1 = new TeamTC1("Team V8", team);
        Thread thread1 = new Thread(team1);
        thread1.start();
        System.out.println("Start " + team1.threadName + " thread");


    }
}