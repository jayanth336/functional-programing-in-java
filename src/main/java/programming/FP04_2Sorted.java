package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP04_2Sorted {
    public static void main(String[] args) {
        /**
         * Created a list with custom type which is Course
         */
        List<FP04_Course> cours = List.of(
                new FP04_Course("spring", "framework", 98, 20000),
                new FP04_Course("spring boot", "framework", 95, 18000),
                new FP04_Course("api", "microservices", 97, 22000),
                new FP04_Course("microservices", "microservices", 96, 25000),
                new FP04_Course("fullstack", "fullstack", 91, 14000),
                new FP04_Course("aws", "cloud", 92, 21000),
                new FP04_Course("azure", "cloud", 99, 21000),
                new FP04_Course("docker", "cloud", 92, 21000),
                new FP04_Course("kubernetes", "cloud", 91, 20000)
        );

        /**
         * Sorted the courses in ascending order based on number of students
         */
        Comparator<FP04_Course> numberOfStudentsInAscOrder = Comparator.comparing(FP04_Course::getNoOfStudents);
        System.out.println(cours.stream()
                .sorted(numberOfStudentsInAscOrder)
                .collect(Collectors.toList()));

        /**
         * Sorted the courses in descending order based on number of students
         */
        Comparator<FP04_Course> numberOfStudentsInDescOrder = Comparator.comparing(FP04_Course::getNoOfStudents).reversed();
        System.out.println(cours.stream()
                .sorted(numberOfStudentsInDescOrder)
                .collect(Collectors.toList()));

        /**
         * Sorted the courses in descending order based on both number of students and review score
         */
        Comparator<FP04_Course> comparingByNoOfStudentsAndReviewScore
                = Comparator.comparing(FP04_Course::getNoOfStudents).thenComparing(FP04_Course::getReviewScore).reversed();
        System.out.println(cours.stream()
                .sorted(comparingByNoOfStudentsAndReviewScore)
                .collect(Collectors.toList()));
    }
}