import java.util.Scanner;
import java.text.DecimalFormat;

public class TripPlanner {
    public static void main(String[] args){
        greeting();
        spacer();
        travelTimeBudge();
        spacer();
        timeDifference();
        spacer();
        countryArea();
        spacer();
        System.out.println("");
//        System.out.println(roundFunc(5.22345));
    }

    public static void greeting(){
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to Vacation Planner!");
        System.out.print("What is your name? ");
        String name = input.nextLine();
        System.out.print("Nice to meet you " + name + ", where are you travelling to? ");
        String destination = input.nextLine();
        System.out.println("Great! "+ destination + " sounds like a great trip");
    }

    public static void travelTimeBudge(){
        Scanner input = new Scanner(System.in);
        System.out.print("How many days are you going to spend travelling? ");
        int days = input.nextInt();
        int hours = days * 24;
        int mins = hours * 60;
        System.out.print("How much money, in USD, are you planning to spend on your trip? ");
        int money = input.nextInt();
        double dailyBudge = (double)(money/days);
        System.out.print("What is the three letter currency symbol for your travel destination? ");
        String currencySymbol = input.next();
        System.out.print("How many " + currencySymbol + " are in 1 USD? ");
        double currencyConversion = input.nextDouble();
        double convertedCurrency = money * currencyConversion;
        double convertedPerDay = convertedCurrency/days;

        System.out.print("If you are travelling for " + days + " days that is the same as ");
        System.out.println(hours + " hours or " + mins + " minutes");
        System.out.print("If you are going to spend $" + money + " USD that means ");
        System.out.println("per day you can spend up to $" + roundFunc(dailyBudge) + " USD");
        System.out.print("Your total budget in " + currencySymbol + " is " + roundFunc(convertedCurrency) + " ");
        System.out.print(currencySymbol + " which per day is " + roundFunc(convertedPerDay));
        System.out.println(" " + currencySymbol);

    }

    public static void timeDifference(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the time difference, in hours, between your home ");
        System.out.print("and your destination? ");
        int hours = input.nextInt();
        int timeAtDestination;
        if (hours >= 0){
            timeAtDestination = hours;
        }
        else{
            timeAtDestination = 24 + hours;
        }
        System.out.print("That means that when it is midnight at home it will be ");
        System.out.println(timeAtDestination + ":00 in your travel destination");
        int timeAtNoon = 12+hours;
        if(timeAtNoon > 24){
            timeAtNoon = timeAtNoon - 24;
        }
        else if(timeAtNoon < 0){
            timeAtNoon = 24 + timeAtNoon;
        }
        System.out.println("and when it is noon at home it will be " + timeAtNoon + ":00");
    }

    public static void countryArea(){
        Scanner input = new Scanner(System.in);
        System.out.print("What is the square area of your destination country in km2? ");
        double area = input.nextDouble();
        double miles = area * 0.386102;
        System.out.println("In miles2 that is " + roundFunc(miles));
    }

    public static String roundFunc(double value){
        DecimalFormat df2 = new DecimalFormat(".##");
        //double yourval = value;
        String out = df2.format(value);
        return out;
    }
    public static void spacer(){
        System.out.println("***********");
        System.out.println("");
    }

}
