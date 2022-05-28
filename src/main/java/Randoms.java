import java.util.*;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class Randoms implements Iterable<Integer> {
    protected Random random;
    protected List<Integer> randNum;
    private final int MIN;
    private final int MAX;
    private final int LIST_SIZE = 10;

    protected int index = 0;

    public Randoms(int min, int max) {
        MIN = min;
        MAX = max;
        random = new Random();
        randNum = random.ints(LIST_SIZE, min, max + 1)
                .boxed()
                .collect(Collectors.toList());
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public Integer next() {
                if (index > LIST_SIZE - 1) {
                    randNum = random.ints(LIST_SIZE, MIN, MAX + 1)
                            .boxed()
                            .collect(Collectors.toList());
                    index = 0;
                }
                return randNum.get(index++);
            }
        };
    }

    @Override
    public void forEach(Consumer<? super Integer> action) {
        Iterable.super.forEach(action);
    }

    @Override
    public Spliterator<Integer> spliterator() {
        return Iterable.super.spliterator();
    }

}