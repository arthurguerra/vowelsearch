package vowel.stream.search;

import org.junit.Test;
import vowel.stream.stream.StreamImpl;

import java.util.Optional;

import static junit.framework.TestCase.*;

/**
 * Test Vowel Search.
 */
public class TestVowelSearch {

    @Test
    public void testVowelExists() {
        StreamImpl stream = new StreamImpl("aAbBABacafe");
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));
        assertTrue(opt.isPresent());
        assertEquals(Character.valueOf('e'), opt.get());
    }

    @Test
    public void testVowelExistsNotAscii() {
        StreamImpl stream = new StreamImpl("aAbBABacafé");
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));
        assertTrue(opt.isPresent());
        assertEquals(Character.valueOf('é'), opt.get());
    }

    @Test
    public void testTwoVowelExists() {
        StreamImpl stream = new StreamImpl("aAbBABacufe");
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));
        assertTrue(opt.isPresent());
        assertEquals(Character.valueOf('u'), opt.get());
    }

    @Test
    public void testNoUniqueVowelsFound() {
        StreamImpl stream = new StreamImpl("aAbBABacafa");
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));
        assertFalse(opt.isPresent());
    }

    @Test
    public void testUniqueVowelsNotInAValidPattern() {
        StreamImpl stream = new StreamImpl("kAKbBABjcpfu");
        Optional<Character> opt = VowelSearch.firstChar(Optional.of(stream));
        assertFalse(opt.isPresent());
    }

    @Test
    public void testEmptyOptional() {
        StreamImpl stream = null;
        Optional<Character> opt = VowelSearch.firstChar(Optional.ofNullable(stream));
        assertFalse(opt.isPresent());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testIllegalArgument() {
        VowelSearch.firstChar(null);
    }
}
