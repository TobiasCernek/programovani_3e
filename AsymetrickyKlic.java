
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.util.Base64;

public class AsymetrickyKlic {
    public static void main(String[] args) {
        try {
            KeyPairGenerator kpg = KeyPairGenerator.getInstance("EC");
            kpg.initialize(256);
            KeyPair kp = kpg.generateKeyPair();

            PrivateKey prk = kp.getPrivate();
            PublicKey puk = kp.getPublic();

            System.out.println("Tajny klic: " + Base64.getEncoder().encodeToString(prk.getEncoded()));

            System.out.println("Verejny klic: " + Base64.getEncoder().encodeToString(puk.getEncoded()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
}
