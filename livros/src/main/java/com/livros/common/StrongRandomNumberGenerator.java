package common;

import java.security.SecureRandom;
import java.util.Random;

public class StrongRandomNumberGenerator {
    private static final Random RANDOM = new SecureRandom();

    public static String generateStrongRandomId() {
        byte[] randomBytes = new byte[16];
        RANDOM.nextBytes(randomBytes);
        StringBuilder sb = new StringBuilder();
        for (byte b : randomBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
}
