package programming;

import java.util.stream.IntStream;

public class FP05_Exercise {
    public static void main(String[] args) {
        /**
         * Added a set of numbers in a particular range
         */
        System.out.println(
                IntStream.range(1,10).sum()
                );

        System.out.println(
                IntStream.rangeClosed(1,10).sum()
        );

        /**
         * Added first 10 even numbers starting with 2
         */
        System.out.println(
                IntStream.iterate(2, i -> i+2).limit(10).sum()
        );

        /**
         * Added first 10 powers of 2 numbers
         */
        System.out.println();
        System.out.println(
                IntStream.iterate(2, i -> i*2).limit(10).peek(System.out::println).sum()
        );
    }
}
