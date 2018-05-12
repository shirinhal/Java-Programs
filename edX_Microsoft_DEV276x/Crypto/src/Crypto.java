import java.util.Arrays;
import java.util.Scanner;

public class Crypto {
    public static void main(String[] args){
        //take in the string to be encrypted
        //take in the shift value as well as group value
        Scanner user_input = new Scanner( System.in );
        System.out.print("Please enter a text to encrypt, you can use spaces or any special characters: ");
        String text = user_input.nextLine();
        System.out.print("Please enter a positive or a negative integer to shift your String: ");
        int shift = user_input.nextInt();
        System.out.print("Please enter a positive integer to code your group size: ");
        int groupSize = user_input.nextInt();
        String cyphertext = encryptString(text, shift, groupSize);
        System.out.println("Encrypted string is: " + cyphertext);

        String plaintext = decryptString(cyphertext, shift);
        System.out.println("Decrypted plain text string is: " + plaintext);

    }
    public static String normalizeText(String text){
        //String newText = text.replaceAll("[^a-zA-Z0-9]", "");
        String newText = text.replaceAll("[^a-zA-Z]", "");
        String normalizedText = newText.toUpperCase();
        return normalizedText;
    }
    public static String obify(String text){
        String newText1 = text.replaceAll("O", "OBO");
        String newText2 = newText1.replaceAll("A", "OBA");
        String newText3 = newText2.replaceAll("E", "OBE");
        String newText4 = newText3.replaceAll("I", "OBI");
        String newText5 = newText4.replaceAll("U", "OBU");
        String obifiedText = newText5.replaceAll("Y", "OBY");
        return obifiedText;
    }
    public static String caesarify(String text, int shift){
        int length = text.length();
        String caesarifiedText = "";
        for(int i=0 ; i<length ; i++){
            char currChar = text.charAt(i);
            int position = (int)currChar + shift;
            if(position < 65){
                position = 26 + position;
            }
            else if(position > 90 ){
                position = position - 26;
            }
            caesarifiedText = caesarifiedText + (char)position ;
        }
        return caesarifiedText;
    }
    public static String groupify(String text, int space){
        int length = text.length();
        int reminder = length % space;
        String groupifiedText = "";
        if(reminder != 0){
            int extra = space - reminder;
            for (int i = 1 ; i <= extra ; i++){
                text = text + "x";
            }
        }
        for (int j=0 ; j < text.length() ; j = j+space){
            groupifiedText = groupifiedText + text.substring(j, j+space) + " ";
        }
        return groupifiedText;
    }
    public static String encryptString(String text, int key, int spacing){

        String normalizedText = normalizeText(text);
        //String obifiedText = obify(normalizedText);
        //String caesarifiedText = caesarify(obifiedText, key);
        String caesarifiedText = caesarify(normalizedText, key);
        String groupifiedText = groupify(caesarifiedText, spacing);
        return groupifiedText;

    }
    public static String ungroupify(String text){
        String newText1 = text.replaceAll("x", "");
        String ungroupified = newText1.replaceAll(" ", "");
        //System.out.println(ungroupified);
        return ungroupified;
    }
    public static String decryptString(String text, int shift){
        String ungrouped = ungroupify(text);
        int length = ungrouped.length();
        String decriptedText = "";
        for(int i=0 ; i<length ; i++){
            char currChar = ungrouped.charAt(i);
            int position = (int)currChar - shift;
            if(position < 65){
                position = 26 + position;
            }
            else if(position > 90 ){
                position = position - 26;
            }
            decriptedText = decriptedText + (char)position ;
        }
        return decriptedText;
    }
}
