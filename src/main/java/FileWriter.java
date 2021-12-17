import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class FileWriter {
    public void writeToFile(List<String> passwords, String fileName) throws IOException {
        try(BufferedWriter writer = new BufferedWriter(new java.io.FileWriter(new File("src/main/java/results/" + fileName)))) {
            for (String password : passwords) {
                writer.write(password + "\n");
            }
        } catch (Exception e) {
        }
    }
}
