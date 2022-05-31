import java.util.*;
import java.util.Iterator;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected List<Integer> randNum;
    private final int MIN;
    private final int MAX;

    public Randoms(int min, int max) {
        MIN = min;
        MAX = max;
        random = new Random();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                return MIN + random.nextInt(MAX - MIN + 1);
            }
        };
    }
}