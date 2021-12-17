import java.util.Random;

public class StringGenerator {
    int ALPHANUM_LEFT_LIMIT = 48; // numeral '0'
    int ALPHANUM_RIGHT_LIMIT = 122; // letter 'z'
    int MIN_STRING_LENGTH = 8;
    int MAX_STRING_LENGTH = 14;

    int SPECIAL_CHARS_LEFT_LIMIT = 33; // char '!'
    int SPECIAL_CHARS_RIGHT_LIMIT = 47; // char '/'
    int MIN_SPECIAL_CHARS = 1;
    int MAX_SPECIAL_CHARS = 3;

    public String getRandomAlphanumericString() {

        Random random = new Random();

        int stringLength = random.ints(MIN_STRING_LENGTH, MAX_STRING_LENGTH).findFirst().getAsInt();

        StringBuilder randomString = random.ints(ALPHANUM_LEFT_LIMIT, ALPHANUM_RIGHT_LIMIT + 1)
                .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
                .limit(stringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append);

        random.ints(0, stringLength-1)
                .limit(random.ints(MIN_SPECIAL_CHARS, MAX_SPECIAL_CHARS).findFirst().getAsInt())
                .forEach(el -> randomString.setCharAt(el, (char)(random.ints(SPECIAL_CHARS_LEFT_LIMIT, SPECIAL_CHARS_RIGHT_LIMIT).findFirst().getAsInt())));

        return randomString.toString();
    }
}
