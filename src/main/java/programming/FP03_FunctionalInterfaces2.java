package programming;

import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class FP03_FunctionalInterfaces2 {
    public static void main(String[] args) {
        /**
         * BinaryOperator Functional Interface - Give 2 Inputs of Integer type, returns an Output of same type
         * Supplier Functional Interface       - No Input, returns an Output of any type - Opposite of Consumer FI
         */
        Supplier<Integer> supplier = () -> 2;
        System.out.println(supplier.get());

        Supplier<Integer> supplier2 = () -> {
            Random random = new Random();
            return random.nextInt();
        };
        System.out.println(supplier2.get());

        /**
         * UnaryOperator Functional Interface - Give an Input of Integer type, returns an Output of same type
         */
        UnaryOperator<Integer> op = x -> 3 * x;
        System.out.println(op.apply(10));

        /**
         * BiPredicate Functional Interface - Give 2 Inputs of any type, returns a boolean
         * Predicate FI with additional input parameter
         */
        BiPredicate<Integer, String> biPredicate = (num, str) -> {
            return num<10 && str.length()>=10;
        };
        System.out.println(biPredicate.test(2, "valueCheckForBiPredicate"));

        /**
         * BiFunction Functional Interface - Similar to Function, but we have additional input
         *                                 - Give 2 inputs of any type, returns an output of given type
         */
        BiFunction<Integer, String, String> biFunction = (num, str) -> {
            return num + " " + str;
        };
        System.out.println(biFunction.apply(2, "testing_output"));

        /**
         * BiConsumer Functional Interface - Give 2 inputs, returns an output of void type
         */
        BiConsumer<String, String> biConsumer = (a,b) -> {
            System.out.println(a);
            System.out.println(a+b);
        };
        biConsumer.accept("this ", "is_testing");
    }
}
