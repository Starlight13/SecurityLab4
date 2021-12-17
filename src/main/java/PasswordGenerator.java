import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PasswordGenerator {
//    CHANCE_OF_TOP100 = 8%;
//    CHANCE_OF_COMMON = 87%;
//    CHANCE_OF_RANDOM = 5%;

    private List<String> passwords;
    private StringGenerator stringGenerator;

    private List<String> top100passwords;
    private List<String> topCommonPasswords;

    PasswordGenerator (StringGenerator stringGenerator) {
        this.stringGenerator = stringGenerator;
        FileReader fileReader = new FileReader();

        top100passwords = fileReader.getTop100Passwords();
        topCommonPasswords = fileReader.getTopCommonPasswords();
    }

//    public List<String> getPasswords() {
//        return passwords;
//    }

    public List<String> generatePasswords(int passwordCount) {
        Random random = new Random();
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < passwordCount; i++) {
            int currentNumber = random.nextInt(1000);
            if (currentNumber < 80) {
                passwords.add(top100passwords.get(random.nextInt(top100passwords.size() - 1)));
            } else if (currentNumber < 950) {
                passwords.add(topCommonPasswords.get(random.nextInt(topCommonPasswords.size() - 1)));
            } else {
                passwords.add(stringGenerator.getRandomAlphanumericString());
            }
        }
        return passwords;
    }
}
