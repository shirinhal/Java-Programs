import java.util.Arrays;
import java.util.Scanner;

public class BattleShip {
    public static String[][] ocean = new String[10][10];
    public static Scanner input = new Scanner(System.in);
    public static int playersShipCount = 0;
    public static int computersShipCount = 0;

    public static void main(String[] args){
        for(String[] row: ocean){
            Arrays.fill(row, " ");
        }
        //System.out.println(Arrays.deepToString(ocean));
        createMap();
        deployPlayersShips();
        System.out.print("Number of player's ship are: ");
        System.out.println(playersShipCount);
        deployComputersShips();
        System.out.print("Number of computer's ship are: ");
        System.out.println(computersShipCount);
        play();
    }
    public static void createMap(){
        System.out.println("**** Welcome to Battle Ships game ****");
        System.out.println();
        System.out.println("Right now, the sea is empty.");
        System.out.println();
        printMap();
    }
    public static void deployPlayersShips(){
        System.out.println("Deploy your ships: ");
        for (int i=1 ; i<=5 ; i++){
            System.out.print("Enter x coordinate for your #" + Integer.toString(i) + " ship: ");
            int x = input.nextInt();
            while (x < 0 || x>=10){
                System.out.print("Enter x coordinate for your #" + Integer.toString(i) + " ship again(0 to 9): ");
                x = input.nextInt();
            }

            System.out.print("Enter y coordinate for your #" + Integer.toString(i) + " ship: ");
            int y = input.nextInt();
            while (y < 0 || y>=10){
                System.out.print("Enter y coordinate for your #" + Integer.toString(i) + " ship again(0 to 9): ");
                y = input.nextInt();
            }
            if (ocean[x][y].equals(" ")){
                ocean[x][y] = "1";
                playersShipCount++;
            }
            else{
                System.out.println("This coordinate is occupied. Enter again!!");
                i--;
            }
        }
        //System.out.println(Arrays.deepToString(ocean));
        printMap();
    }
    public static void deployComputersShips(){
        System.out.println("Computer is deploying ships!");
        for (int i=1 ; i<=5 ; i++){
            int x = (int)(Math.random()*10);
            //System.out.println(x);
            int y = (int)(Math.random()*10);
            //System.out.println(y);
            if (ocean[x][y].equals(" ")){
                ocean[x][y] = "2";
                computersShipCount++;
                System.out.println("Ship #"  + Integer.toString(i) + " Deployed");
            }
            else{
                i--;
            }
        }
        System.out.println("------------------------------------------");
    }
    public static void playersTurn(){
        System.out.println("YOUR TURN");
        System.out.print("Enter x coordinate: ");
        int x = input.nextInt();
        while (x < 0 || x>=10){
            System.out.print("Enter x coordinate again(0 to 9): ");
            x = input.nextInt();
        }
        System.out.print("Enter y coordinate: ");
        int y = input.nextInt();
        while (y < 0 || y>=10){
            System.out.print("Enter y coordinate again(0 to 9): ");
            y = input.nextInt();
        }
        if(ocean[x][y].equals("2")){
            System.out.println("Boom! You sunk the computer's ship!");
            ocean[x][y] = "!"; // print the map as ! -- but might have to change the value
            computersShipCount--;
        }
        else if(ocean[x][y].equals("1")){
            System.out.println("Oh no, you sunk your won ship! :(");
            ocean[x][y] = "x"; //print the map with x for this location
            playersShipCount--;
        }
        else if(ocean[x][y].equals("-")){//previously guessed value change the euality
            playersTurn();
        }
        else{
            System.out.println("Sorry, you missed!");
            ocean[x][y] = "-";
        }
    }
    public static void computersTurn(){
        System.out.println("COMPUTER'S TURN");
        int x = (int)(Math.random()*10);
        int y = (int)(Math.random()*10);
        if(ocean[x][y].equals("2")){
            System.out.println("The computer sunk one of its own ships!");
            ocean[x][y] = "!"; // print the map as ! -- but might have to change the value
            computersShipCount--;
        }
        else if(ocean[x][y].equals("1")){
            System.out.println("The computer sunk one of your ships! :(");
            ocean[x][y] = "x"; //print the map with x for this location
            playersShipCount--;
        }
        else if(ocean[x][y].equals("+")){//previously guessed value change the equality
            computersTurn();
        }
        else{
            System.out.println("Computer missed!");
            if(ocean[x][y].equals(" ")) {
                ocean[x][y] = "+";
            }
        }
    }
    public static void play(){
        while (playersShipCount > 0 && computersShipCount > 0){
            playersTurn();
            computersTurn();
            printMap();
            System.out.println();
            System.out.print("Your ships: ");
            System.out.print(playersShipCount);
            System.out.print(" | computer ships: ");
            System.out.println(computersShipCount);
        }
        if (playersShipCount == 0){
            System.out.println("Sorry you lost and computer won!");
        }
        else if(computersShipCount == 0){
            System.out.println("Hooray! You win the battle! :)");
        }
    }
    public static void printMap(){
        System.out.println("   0123456789");
        for (int row=0 ; row < ocean.length ; row++){
            System.out.print(row + " |");
            for(int col=0 ; col < ocean[row].length ; col++){
                if(ocean[row][col] == null){
                    System.out.print(" ");
                }
                else if(ocean[row][col].equals("1")){
                    System.out.print("@");
                }
                else if(ocean[row][col].equals("2")){
                    System.out.print(" ");
                }
                else if(ocean[row][col].equals("+")){
                    System.out.print(" ");
                }
                else{
                    System.out.print(ocean[row][col]);
                }
            }
            System.out.println("| " + row);
        }
        System.out.println("   0123456789");
        System.out.println("------------------------------------------");
    }
}
