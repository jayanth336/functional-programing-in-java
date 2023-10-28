package programming;

import java.util.Comparator;
import java.util.List;

public class FP02_Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        //Exercise 1
        System.out.println(printSumOfSquaresOfNumbers(numbers));
        //Exercise 2
        System.out.println(printSumOfOddNumbersInList(numbers));
        //Exercise 3
        printDistinctNumbersFromList(numbers);
        //Exercise 4
        printSortedFormOfList(numbers);
        //Exercise 5
        printDistinctSortedNumbersFromList(numbers);
        //Exercise 6
        printReverseSortedFormOfNumbers(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        //Exercise 7
        printReverseSortedFormOfStringList(courses);
        //Exercise 8
        printReverseSortedFormOfStringListAsPerCourseLength(courses);
    }

    private static int printSumOfSquaresOfNumbers(List<Integer> numbers) {
        return numbers.stream()
                    .map(i -> (int)Math.pow(i,2))
                    .reduce(0, (x,y) -> x+y);
    }

    private static int printSumOfOddNumbersInList(List<Integer> numbers) {
        return numbers.stream()
                    .filter(i -> i%2 !=0)
                    .reduce(0, (x,y) -> x+y);
    }

    private static void printDistinctNumbersFromList(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void printSortedFormOfList(List<Integer> numbers) {
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }

    private static void printDistinctSortedNumbersFromList(List<Integer> numbers) {
        numbers.stream()
                .distinct()
                .sorted()
                .forEach(System.out::println);
    }

    /**
     * For natural order 1,2,3,4,5,.. we can either leave it blank without specifying anything or specify Comparator.naturalOrder()
     * For reverse order ..,5,4,3,2,1 we need to specify Comparator.reverseOrder()
     */
    private static void printReverseSortedFormOfNumbers(List<Integer> numbers) {
        System.out.println();
        numbers.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void printReverseSortedFormOfStringList(List<String> courses) {
        courses.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);
    }

    private static void printReverseSortedFormOfStringListAsPerCourseLength(List<String> courses) {
        System.out.println();
        courses.stream()
                .sorted(Comparator.comparing(i -> i.length()))
                .forEach(System.out::println);
    }
}
