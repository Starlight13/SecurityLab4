import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception{
        StringGenerator stringGenerator = new StringGenerator();
        PasswordGenerator passwordGenerator = new PasswordGenerator(stringGenerator);
        FileWriter fileWriter = new FileWriter();

        List<String> passwords = passwordGenerator.generatePasswords(200000);

        List<String> md5Hashes = new ArrayList<>();
        MessageDigest md = MessageDigest.getInstance("MD5");

//        for (String password: passwords) {
//            byte[] bytes = password.getBytes(StandardCharsets.UTF_8);
//            BigInteger bigInt = new BigInteger(1,md.digest(bytes));
//            String hashtext = bigInt.toString(16);
//            while(hashtext.length() < 32 ){
//                hashtext = "0" + hashtext;
//            }
//            md5Hashes.add(hashtext);
//        }
//
//        fileWriter.writeToFile(passwords, "weakNoHash.csv");
//        fileWriter.writeToFile(md5Hashes, "weak.csv");

        List<String> argon2Hashes = new ArrayList<>();
        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        int i = 0;
        for (String password: passwords) {
            System.out.println(++i);
            argon2Hashes.add(argon2.hash(4, 2048, 8, password));
        }

        fileWriter.writeToFile(passwords, "strongNoHash.csv");
        fileWriter.writeToFile(argon2Hashes, "strong.csv");
    }
}
