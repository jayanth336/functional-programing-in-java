package programming;

import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;

public class FP03_Exercises {
    public static void main(String[] amin) {

        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Exercise 1
        /**
         * Extracted BinaryOperator Functional Interface from Integer::sum
         */
        BinaryOperator<Integer> sum1 = Integer::sum;
        BinaryOperator<Integer> sum2 = new BinaryOperator<Integer>() {
            @Override
            public Integer apply(Integer a, Integer b) {
                return a + b;
            }
        };

        int sum = numbers.stream()
                        .reduce(0, sum2);
        System.out.println(sum);

        //Exercise 2
        /**
         * Performed Behavior Parameterization for map i.e 'Function' Functional Interface
         * This can be used when a requirement is in such a way that the mapper part keeps changing and rest all remains same
         */
        mappingFunction(numbers, x -> x * x);
        mappingFunction(numbers, x -> (int) Math.pow(x,3));

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        //Exercise 3
        convertToUpperCase(courses);
    }

    private static void mappingFunction(List<Integer> numbers, Function<Integer, Integer> function) {
        numbers.stream()
                .map(function)
                .forEach(System.out::println);
    }

    private static void convertToUpperCase(List<String> courses) {
        courses.stream()
                .map(str -> str.toUpperCase())
                .forEach(str -> System.out.println(str));
    }
}
