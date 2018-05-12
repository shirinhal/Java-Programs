import java.util.Scanner;

public class FractionCalculator {
    public static Scanner input = new Scanner(System.in);

    /*
    The FractionCalculator class is a class that will allow the user to enter in
    fractions and operations, calculating and displaying the result. It will run
    until the user tells it to quit. When this program is complete, you won’t have
    to second guess your fraction arithmetic ever again!
     */
    public static void main(String[] args){
        Fraction frac1;
        Fraction frac2;
        initialize();
        String operation = getOperation();

        while(operation.toUpperCase() != "Q"){
            frac1 = getFraction();
            frac2 = getFraction();

            if (frac2.getNumerator() != 0 && operation.equals("/")) {
                System.out.print(frac1.toString() + " " + operation + " " + frac2.toString());
                System.out.print(" = " + frac1.divide(frac2).toString());
                }
            else if (frac2.getNumerator() == 0 && operation.equals("/")){
                System.out.print(" = " + frac1.divide(frac2).toString());
            }
            else{
                System.out.print(frac1.toString() + " " + operation + " " + frac2.toString() );
                if (operation.equals("+")) {
                    System.out.print(" = " + frac1.add(frac2).toString());
                } else if (operation.equals("-")) {
                    System.out.print(" = " + frac1.subtract(frac2).toString());
                } else if (operation.equals("*")) {
                    System.out.print(" = " + frac1.multiply(frac2).toString());
                } else if (operation.equals("=")) {
                    System.out.print(" is " + frac1.equals(frac2));
                }
            }
            System.out.println("\n---------------------------------------------------------------------------------");
            operation = getOperation();
        }
    }
    public static void initialize(){
        System.out.println("This program is a fraction calculator.");
        System.out.println("It will add, subtract, multiply and divide fractions until you type Q to quit.");
        System.out.println("Please enter your fractions in the form of a/b, where a and b are integers.");
        System.out.println("---------------------------------------------------------------------------------");
    }
    public static String getOperation(){
        System.out.print("Please enter an operation (+, -, /, *, =, or Q to quit): ");
        String op = input.nextLine();
        while (op.matches("[^+-/*=qQ]") || op.length() != 1){
            System.out.print("Invalid input (+, -, /, *, =, or Q to quit): ");
            op = input.nextLine();
        }
        if (op.equals("Q") || op.equals("q")){
            System.exit(0);
        }
        return op;
    }
    public static boolean validFraction(String input){
        if (input.contains("/")){
            String[] parts = input.split("/");
            if (parts.length == 2) {
                if (parts[0].matches("^-?[\\d]+") && parts[1].matches("^-?[\\d]+")) {
                    if (Integer.valueOf(parts[1]) != 0){
                        return true;
                    }
                }
            }
        }
        else if (input.matches("^-?[\\d]")){
            return true;
        }
        return false;
    }
    public static Fraction getFraction(){
        System.out.print("Please enter a fraction (a/b) or integer (a): ");
        String fractionInit = input.nextLine();
        while(!validFraction(fractionInit)){
            System.out.print("Invalid fraction. Please enter (a/b) or (a), where a and b are integers and b is not zero: ");
            fractionInit = input.nextLine();
        }
        if (fractionInit.contains("/")){
            String[] parts = fractionInit.split("/");
            Fraction frac = new Fraction(Integer.valueOf(parts[0]), Integer.valueOf(parts[1]));
            return frac;
        }
        else{
            Fraction frac = new Fraction(Integer.valueOf(fractionInit));
            return frac;
        }
    }
}
