package programming;

import java.util.List;
import java.util.function.Predicate;

/**
 * NOTE:
 * Behavior Parameterization - Passing behavior as a parameter
 * The behavior could be of any type depending on the necessity - for ex. Predicate, Function, Consumer, BinaryOperator, etc..
 */
public class FP03_BehaviorParameterization {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        /**
         * Used filter and implemented lambda expression right there within filter
         */
        numbers.stream()
                .filter(x -> x%2==0)
                .forEach(System.out::println);

        /**
         * We passed method definition (or) behavior as a parameter
         */
        filterEven(numbers, x-> x%2==0);
    }

    private static void filterEven(List<Integer> numbers, Predicate<Integer> predicate) {
        numbers.stream()
                .filter(predicate)
                .forEach(System.out::println);
    }
}

