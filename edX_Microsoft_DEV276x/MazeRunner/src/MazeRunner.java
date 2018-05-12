import java.util.Scanner;
public class MazeRunner {
    private static int counter = 0;
    private static Maze myMap = new Maze();
    private static Scanner input = new Scanner(System.in);


    public static void main (String [] args){
        intro(myMap);
        while(!myMap.didIWin()){//this method returns true when you win, false when you did not yet
            movePosition(input, myMap);
            movesMessage(counter);
        }
        System.out.println("Congratulations, you made it out alive, and you did it in " + counter + " moves!!");
    }



    private static void intro(Maze myMap){
        System.out.println("Welcome to Maze Runner!");
        System.out.println("Here is your current position: ");
        myMap.printMap();

    }

    private static String userMove (Scanner input){
        System.out.print("Where would you like to move? (R, L, U, D) ");
        String userElection = input.next();
        if(userElection.equals("R") || userElection.equals("L") || userElection.equals("U") || userElection.equals("D")){
            return userElection;
        } else{
            System.out.println("You have not chosen one of the four available movements. Please choose again. ");
            return userMove(input);
        }
    }

    private static void movePosition(Scanner input, Maze myMap){
        canItMove(userMove(input), myMap, input);
        counter++;
    }

    private static void canItMove (String userMove, Maze myMap, Scanner input){
        boolean canItMove;
        //If there are pits
        if(myMap.isThereAPit(userMove)){// Takes in the direction String the user entered in and returns if there is a pit ahead
            System.out.print("Watch out! There's a pit ahead, jump it? (Y) ");
            if(input.next().equals("Y")){
                myMap.jumpOverPit(userMove);
            } else {//if you dont choose to jump the pit:
                System.out.println("You will have to choose another direction if you wish not to jump the pit. ");
                movePosition(input, myMap);
            }
        }

        //If there are no pits
        switch (userMove){
            case "R":
                canItMove = myMap.canIMoveRight();
                if(canItMove){
                    myMap.moveRight();
                    myMap.printMap();
                } else {
                    System.out.println("Sorry, you have hit a wall. Enter a new direction.");
                    myMap.printMap();
                    movePosition(input, myMap);
                } break;

            case "L":
                canItMove = myMap.canIMoveLeft();
                if(canItMove){
                    myMap.moveLeft();
                    myMap.printMap();
                } else {
                    System.out.println("Sorry, you have hit a wall. Enter a new direction.");
                    myMap.printMap();
                    movePosition(input, myMap);
                } break;
            case "U":
                canItMove = myMap.canIMoveUp();
                if(canItMove){
                    myMap.moveUp();
                    myMap.printMap();
                } else {
                    System.out.println("Sorry, you have hit a wall. Enter a new direction.");
                    myMap.printMap();
                    movePosition(input, myMap);
                } break;
            case "D":
                canItMove = myMap.canIMoveDown();
                if(canItMove){
                    myMap.moveDown();
                    myMap.printMap();
                } else {
                    System.out.println("Sorry, you have hit a wall. Enter a new direction.");
                    myMap.printMap();
                    movePosition(input, myMap);
                } break;
            default:
                System.out.println("Error");
                break;
        }
    }

    private static void movesMessage(int moves){
        if(moves == 50){
            System.out.println("Warning: You have made 50 moves, you have 50 remaining before the maze exit closes");
        } else if (moves == 75){
            System.out.println("Alert! You have made 75 moves, you only have 25 moves left to escape.\n");
        } else if (moves == 90){
            System.out.println("DANGER! You have made 90 moves, you only have 10 moves left to escape!!");
        } else if (moves == 100){
            System.out.println("Oh no! You took too long to escape, and now the maze exit is closed FOREVER >:[");
            System.out.println("Sorry, but you didn't escape in time- you lose!");
            System.exit(0);
        }

    }

}