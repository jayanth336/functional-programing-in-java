package programming;

import java.util.List;

public class FP01_Exercises {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);

        //Exercise 1
        printOnlyOddNumbers(numbers);

        List<String> courses = List.of("Spring", "Spring Boot", "API" , "Microservices","AWS", "PCF","Azure", "Docker", "Kubernetes");

        //Exercise 2
        printAllCoursesIndividually(courses);
        //Exercise 3
        printCoursesContainingSpring(courses);
        //Exercise 4
        printCoursesWithLetterSizeOfAtleast4(courses);
        //Exercise 5
        printSquaresOfEvenNumbers(numbers);
        //Exercise 6
        printCubesOfOddNumbers(numbers);
        //Exercise 7
        printNumberOfCharactersInEachCourse(courses);
    }

    private static void printOnlyOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i%2 != 0) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printAllCoursesIndividually(List<String> courses) {
        courses.stream()
                .forEach(System.out::println); //Method Reference
    }

    private static void printCoursesContainingSpring(List<String> courses) {
        courses.stream()
                .filter(i -> i.contains("Spring")) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printCoursesWithLetterSizeOfAtleast4(List<String> courses) {
        courses.stream()
                .filter(i -> i.length() >= 4) //Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printSquaresOfEvenNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i%2==0) //Lambda Expression
                .map(num -> (int)Math.pow(num, 2)) //Mapping Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printCubesOfOddNumbers(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i%2 != 0) //Lambda Expression
                .map(i -> Math.pow(i, 3)) //Mapping Function with Lambda Expression
                .forEach(System.out::println); //Method Reference
    }

    private static void printNumberOfCharactersInEachCourse(List<String> courses) {
        courses.stream()
                .map(i -> i + " " + i.length()) //Mapping Function with Lambda Expression
                .forEach(System.out::println); //Method Reference
    }
}
