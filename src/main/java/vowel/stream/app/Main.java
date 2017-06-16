package vowel.stream.app;

import vowel.stream.search.VowelSearch;
import vowel.stream.stream.StreamImpl;

import java.util.Optional;

/**
 * Test stream.
 */
public class Main {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Invalid input. ");
            System.exit(0);
        }

        StreamImpl stream = new StreamImpl(args[0]);
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));

        if (opt.isPresent()) {
            System.out.println("Unique vowel found: " + opt.get());
        } else {
            System.out.println("Unique vowel character not found in the stream.");
        }
    }

}
