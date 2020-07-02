package concurrency;

public class Main {
   
    public static void main(String[] args) {
         //run all of your threads from this main class.
        Reasoning reasoning = new Reasoning();
        reasoning.start();
        System.out.println("Start Reasoning thread");

        String[] team = new String[]{"epapas", "gabe chavez", "Abigail Swigert", "Abram Jablonski", "Adam Rice", "Amir", "christian", "Craig A. Stockton", "devonbrewster42", "Jonathan Diamond", "Jose Moreno", "Julian Ladd", "Marcelo Barbosa", "Michael Kinney", "Monica Howard", "Phoenix Megan Shane"};
        TeamTC1 team1 = new TeamTC1("TeamTC1 runnable thread", team);
        Thread thread1 = new Thread(team1);
        thread1.start();
        System.out.println("Start " + team1.threadName);


    }
}