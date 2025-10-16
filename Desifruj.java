import java.nio.file.Files;
import java.nio.file.Paths;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Desifruj {
    public static void main(String[] args) {
        try {
            byte[] keyBytes = Files.readAllBytes(Paths.get("klic.dat"));
            SecretKey key = new SecretKeySpec(keyBytes, "AES");

            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(Cipher.DECRYPT_MODE, key);

            byte[] messageBytes = Files.readAllBytes(Paths.get("message.dat"));
            byte[] message = cipher.doFinal(messageBytes);

            System.out.println(new String(message));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}