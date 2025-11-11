import java.util.Scanner;

public class RPSGame {
    private Player player;
    private NPC opponent;

    public RPSGame(Player player, NPC opponent) {
        this.player = player;
        this.opponent = opponent;
    }

    public void start() {
    Scanner scan = new Scanner(System.in);
    System.out.println("What is your name? ");
    String name = scan.next();
    System.out.println("What is your choice? ");
    String typed = "";
    typed = scan.next();
    if (validateChoice(typed.toLowerCase())) {
        System.out.println("Great, thanks");
        setPlayerValues(name, typed);
    } else if (validateChoice(typed.toLowerCase()) == false) {
        for (int i = 1; i <= 3; i++) {
            System.out.println("Invalid. You have " + (3 - i) + " tries left.");
            typed = scan.next();
            if (validateChoice(typed.toLowerCase()) == true) {
                i = 10;
                setPlayerValues(name, typed);
            }
            if (3 - i == 0) {
                System.out.println("You are out of tries, random choice chosen.");
                typed = RPSGame.generateRandomChoice();
                setPlayerValues(name, typed);
            }
        }
    }  
    }

    public void setPlayerValues(String name, String choice) {
        player.setName(name);
        player.setChoice(choice);
    }

    public boolean didPlayerWin() {
        if (player.getChoice().equals(opponent.getChoice())) {
            return false;
        }
        if (player.getChoice().equals("rock") && opponent.getChoice().equals("paper") 
            || player.getChoice().equals("paper") && opponent.getChoice().equals("scissors")
            || player.getChoice().equals("scissors") && opponent.getChoice().equals("rock")) {
                return false;
            }
        if ((player.getChoice().equals("paper") && opponent.getChoice().equals("rock"))
            || (player.getChoice().equals("scissors") && opponent.getChoice().equals("paper"))
            || (player.getChoice().equals("rock") && opponent.getChoice().equals("scissors"))) {
                return true;
        }
        return false;
    }

    public String toString() {
        if (didPlayerWin()) {
            return player.getName() + " won!\nCongratulations!";
        }
        return "Opponent won!\nBetter luck next time!";
    }

    public String displayResults(){
        String l1 = "== Game Results ==\n";
        String l2 = player.getName() + " chose " + player.getChoice() + ".\n"; 
        String l3 = "Opponent chose " + opponent.getChoice() + ".\n"; 
        String l4_5 = toString();
        return l1 + l2 + l3 + l4_5;
    }

    public static boolean validateChoice(String choice) {
        if (choice.equals("rock") || choice.equals("scissors") || choice.equals("paper")) {
            return true;
        }
        return false;
    }
    
    public static String generateRandomChoice(){
        int num = (int) (Math.random() * 3) + 1;
        if (num == 1) {
            return "rock";
        } else if (num == 2) {
            return "paper";
        }
        return "scissors";
    }

}
