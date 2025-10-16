import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Sifruj {
    public static void main(String[] args) {
        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get("klic.dat"));
            SecretKey key = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.ENCRYPT_MODE, key);

            Scanner scanner = new Scanner(System.in);
            String message = scanner.nextLine();
            scanner.close();
            byte[] ciphertext = cipher.doFinal(message.getBytes());

            Files.write(Paths.get("message.dat"), ciphertext);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}