package vowel.stream.stream;

/**
 * IStream implementation.
 */
public class StreamImpl implements IStream {
    private char[] buffer;
    private int i;

    public StreamImpl(String s) {
        buffer = s.toCharArray();
        i = 0;
    }

    @Override
    public char getNext() {
        return buffer[i++];
    }

    @Override
    public boolean hasNext() {
        return i < buffer.length;
    }
}
