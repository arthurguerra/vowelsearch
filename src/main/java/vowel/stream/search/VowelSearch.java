package vowel.stream.search;

import vowel.stream.stream.IStream;

import java.util.*;

/**
 * VowelSearch class will look for the first vowel character v after a consonant, which is after another vowel.
 * Also, v must be unique in the stream.
 */
public class VowelSearch {
    private static final String VOWELS = "aáàãâäÁÀÃÂeéêëÉÊiíïÍoóõôöÓÕÔuúüÚ";
    private static final String DIGITS = "0123456789";

    public static boolean isVowel(char c) {
        return VOWELS.indexOf(c) != -1;
    }

    public static boolean isDigit(char c) {
        return DIGITS.indexOf(c) != -1;
    }

    public static boolean isConsonant(char c) {
        return !isDigit(c) && !isVowel(c);
    }

    public static boolean isValidTriplet(char[] triplet) {
        return triplet != null && isVowel(triplet[0]) && isConsonant(triplet[1]) && isVowel(triplet[2]);
    }

    public static boolean isValidChar(char c) {
        return c != ' ' && c != '\n' && c != '\t';
    }

    /**
     * Finds the first unique vowel char coming after a consonant that comes after a vowel.
     * @param streamOpt optional containing stream the get the characters from
     * @return {@link Optional} character containing or not a vowel
     */
    public static Optional<Character> firstChar(Optional<IStream> streamOpt) {
        if (streamOpt == null) {
            throw new IllegalArgumentException("Null optional stream provided");
        }

        if (!streamOpt.isPresent()) {
            return Optional.empty();
        }

        Queue<Character> uniqueVowels = new LinkedList<>();
        Set<Character> seenVowels = new HashSet<>();
        char[] triplet = new char[3];
        IStream stream = streamOpt.get();
        while(stream.hasNext()) {
            char c = stream.getNext();

            if (!isValidChar(c)) {
                continue;
            }

            triplet[0] = triplet[1];
            triplet[1] = triplet[2];
            triplet[2] = c;

            if (isValidTriplet(triplet)) {
                if (seenVowels.contains(c)) {
                    uniqueVowels.remove(c);
                } else {
                    uniqueVowels.add(c);
                }
            }

            if (isVowel(c) && !seenVowels.contains(c)) {
                seenVowels.add(c);
            }
        }

        return uniqueVowels.isEmpty() ? Optional.empty() : Optional.of(uniqueVowels.peek());
    }
}
