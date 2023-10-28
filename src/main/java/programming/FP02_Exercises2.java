package programming;

import java.util.List;
import java.util.stream.Collectors;

public class FP02_Exercises2 {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Exercise 1
        List<Integer> squaredList = collectSquaredNumbersToAList(numbers);
        System.out.println(squaredList);
        //Exercise 2
        System.out.println(collectEvenNumbersToAList(numbers));

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        //Exercise 3
        System.out.println(collectLengthsOfEachCourseToAList(courses));
    }

    /**
     * Used Collectors.toList() to collect all the squared numbers to a list, instead of printing it
     */
    private static List<Integer> collectSquaredNumbersToAList(List<Integer> numbers) {
        return numbers.stream()
                .map(i -> (int)Math.pow(i,2))
                .collect(Collectors.toList());
    }

    private static List<Integer> collectEvenNumbersToAList(List<Integer> numbers) {
        return numbers.stream()
                .filter(i -> i%2 == 0)
                .collect(Collectors.toList());
    }

    private static List<Integer> collectLengthsOfEachCourseToAList(List<String> courses) {
        return courses.stream()
                .map(i -> i.length())
                .collect(Collectors.toList());
    }
}
