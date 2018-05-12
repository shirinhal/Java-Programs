import java.util.Random;
import java.util.Scanner;

public class OddsAndEvens {
    public static void main(String[] args){
        String[] oE =greeting();
        play(oE[0], oE[1]);


    }
    public static String[] greeting(){
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.println("Let's play a game called \"Odds and Evens\"");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Hi " + name + ", which do you choose? (O)dds or (E)vens? ");
        String oddEven = input.next();
        if(oddEven.equals("O")){
            System.out.println(name + " has picked odds! The computer will be evens.");
        }
        else{
            System.out.println(name + " has picked evens! The computer will be odds.");
        }
        System.out.println("-----------------------------------------");
        return new String[] {name, oddEven};
    }
    public static void play(String name, String oddEven){
        String playerName = name;
        String whoWins = oddEven;
        System.out.println("");
        Scanner input = new Scanner(System.in);
        System.out.print("How many \"fingers\" do you put out? ");
        int player = input.nextInt();
        Random rand = new Random();
        int computer = rand.nextInt(6);
        System.out.println("The computer plays " + computer + " \"fingers\".");
        System.out.println("-----------------------------------------");
        System.out.println("");
        int sum = player + computer;
        String results = "";
        if (sum%2 == 0){
            results = "even";
        }
        else{
            results = "odd";
        }
        System.out.println(player + " + " + computer + " = " + sum);
        System.out.println(sum + " is ..." + results + "!");
        if (sum%2 == 0){
            if(whoWins.equals("E")){
                System.out.println("That means " + name + " wins! :)");
            }
            else{
                System.out.println("That means computer wins! :)");
            }
        }
        else{
            if(whoWins.equals("O")){
                System.out.println("That means " + name + " wins! :)");
            }
            else{
                System.out.println("That means computer wins! :)");
            }
        }
        System.out.println("-----------------------------------------");
    }

}
