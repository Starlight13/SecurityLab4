import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class HumanLikePaswordsGenerator {
    private final int MIN_WORDS = 1;
    private final int MAX_WORDS = 3;
    private final int MIN_PASSWORD_LENGTH = 8;

    private final List<String> dictionary;

    HumanLikePaswordsGenerator() {
        FileReader fileReader = new FileReader();
        dictionary = fileReader.getDictionary();
    }

    public String getHumanLikePassword() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < random.nextInt(MAX_WORDS - 1) + MIN_WORDS; i++) {
            String word = dictionary.get(random.nextInt(dictionary.size()-1));
            if (random.nextInt(100) < 50) {
                String capitalLetter = word.substring(0, 1).toUpperCase();
                word = capitalLetter + word.substring(1);
            }
            stringBuilder.append(word);
        }
        if (stringBuilder.length() < MIN_PASSWORD_LENGTH) {
            while (stringBuilder.length() < MIN_PASSWORD_LENGTH) {
                stringBuilder.append(random.nextInt(2021));
            }
        }

        String password = stringBuilder.toString();

        if (random.nextInt(100) < 7) {
            password = password.replaceAll("o", "0");
        } else if (random.nextInt(100) < 7) {
            password = password.replaceAll("i", "1");
        }

        return password;
    }
}
