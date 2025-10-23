
import java.util.Random;
import java.util.Scanner;

public class Hash {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for(;;){
            String input = newSlovo();

            long zasifrovany = hashniRadek(input);
            if(zasifrovany == 300){
                System.out.println(zasifrovany);
            }
            
        }
        
    }

    public static  long hashniRadek(String input){
        char[] inputChar = input.toCharArray();
        long inputVal = 0;

        for (char c : inputChar){
            inputVal += c;
            inputVal = (inputVal * inputVal + 3) % 1013;
        }

        return inputVal;
    }

    public static String newSlovo(){
        String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
        StringBuilder salt = new StringBuilder();
        Random rnd = new Random();
        while (salt.length() < 18) { // length of the random string.
            int index = (int) (rnd.nextFloat() * SALTCHARS.length());
            salt.append(SALTCHARS.charAt(index));
        }
        String saltStr = salt.toString();
        return saltStr;
    }
}