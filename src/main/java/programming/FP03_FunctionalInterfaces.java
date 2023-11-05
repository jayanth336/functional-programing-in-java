package programming;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * NOTE:
 * Functional Interface - It's an Interface that contains only one abstract method
 *                      - WKT an Abstract method can have only method definition and not implementation
 *                      - As FI has only one abstract method, it means FI can exhibit only one functionality
 *                      - It's also called as SAM (Single Abstract Method) Interfaces
 */
public class FP03_FunctionalInterfaces {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        /**
         * Predicate Functional Interface - Give an Input of any type, returns Output of boolean    - for filter
         * Function Functional Interface  - Give an Input of any type, returns Output of given type - for map
         * Consumer Functional Interface  - Give an Input of any type, returns Output of void       - for forEach
         */

        Predicate<Integer> isEvenPredicate = x -> x % 2 == 0;

        /*
        Predicate<Integer> isEvenPredicate2 = new Predicate<Integer>() {
            @Override
            public boolean test(Integer x) {
                return x%2==0;
            }
        };
        */

        /*
        Predicate<Integer> isEvenPredicate3 = (x) -> {
            return x%2==0;
        };
         */

        Function<Integer, Integer> squareFunction = x -> x * x;

        /*
        Function<Integer, Integer> squareFunction2 = new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer x) {
                return x * x;
            }
        };
         */

        Consumer<Integer> sysoutConsumer = System.out::println;

        /*
        Consumer<Integer> sysoutConsumer2 = new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) {
                System.out.println(integer);
            }
        };
         */

        numbers.stream()
                .filter(isEvenPredicate)
                .map(squareFunction)
                .forEach(sysoutConsumer);

    }
}
