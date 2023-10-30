package utils;

import com.mifmif.common.regex.Generex;
import lombok.experimental.UtilityClass;

@UtilityClass
public class RandomUtils {
    private Generex generex;

    public String getRandomNumber(int length) {
        generex = new Generex(String.format("[0-9]{%s}", length));
        return generex.random();
    }

    public static String generateRandomString(int length) {
        generex = new Generex(String.format("([0-9]|[a-z]){%s}", length));
        return generex.random();
    }

    public String generateEmail() {
        return String.format("test%s@mailinator.com", getRandomNumber(9));
    }
}
