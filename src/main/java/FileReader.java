import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FileReader {

    private final static String TOP_100_PSWD_FILENAME = "top100.txt";
    private final static String TOP_100K_PSWD_FILENAME = "top100k.txt";
    private final static String TOP_1M_PSWD_FILENAME = "top1m.txt";

    public List<String> getTop100Passwords() {
        return getDataFromFile(new File("src/main/java/passwords/" + TOP_100_PSWD_FILENAME));
    }

    public List<String> getTopCommonPasswords() {
        return getDataFromFile(new File("src/main/java/passwords/" + TOP_1M_PSWD_FILENAME));
    }


    private List<String> getDataFromFile(File file) {
        List<String> passwords = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new java.io.FileReader(file))) {
            String line = reader.readLine();

            while (line != null) {
                passwords.add(line);
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.out.println("No such file...");
            System.exit(0);
        }
        System.out.println("Have read " + file.toString());
        return passwords;
    }
}
