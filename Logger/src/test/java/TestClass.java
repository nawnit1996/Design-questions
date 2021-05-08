import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class TestClass {
    public static void main(String[] args) {

    }

    private static void testSorting() {
        String []fruit = {"orange","apple","banana","papaya","kiwi"};
        Integer []price = {10,4,67,23,6};

        AtomicInteger count = new AtomicInteger(0);
        final Map<String, Integer> fruitIndex = Arrays.stream(fruit).collect(Collectors.toMap(value -> value, value -> count.getAndIncrement()));
        System.err.println(fruitIndex);

        Arrays.sort(fruit, Comparator.comparingInt(fr->price[fruitIndex.get(fr)]));
        Arrays.sort(price,Comparator.comparingInt(prie->prie));


        System.err.println(Arrays.asList(price));

        System.err.println(Arrays.asList(fruit));
        System.err.println("hi working");
    }
}
