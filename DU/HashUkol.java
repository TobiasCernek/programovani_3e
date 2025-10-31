package DU;

public class HashUkol {
    static int counter = 0;
    static int maxCounter = 15;
    public static void main(String[] args) {
        String zadani = "ProgramovaT";
        int ukolVal = mujHash(zadani);

        for (int length = 1; length <= 6; length++) {
            checkVsechnaString(length, ukolVal);
        }
    }

    static int mujHash(String str) {
        int out = 1;
        for (char ch: str.toCharArray()) {
            out = (out * (int)ch) % 9973;
        }
        return out;
    }

    public static void checkVsechnaString(int length, int targetHash) {
        String charsString = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] chars = charsString.toCharArray();
        char[] currentString = new char[length];

        najdiString(chars, currentString, 0, length, targetHash);
    }

    public static void najdiString(char[] chars, char[] currentString, int index, int length, int targetHash) {
        if (index == length) {
            String novyString = new String(currentString);
            if (mujHash(novyString) == targetHash && counter < maxCounter) {
                System.out.println(novyString);
                counter++;
            } else if (counter >= maxCounter) {
                return;
            }
        } else {
            for (char ch : chars) {
                currentString[index] = ch;
                najdiString(chars, currentString, index + 1, length, targetHash);
            }
        }
    }
}
