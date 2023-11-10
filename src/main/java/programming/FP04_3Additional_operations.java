package programming;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class FP04_3Additional_operations {
    public static void main(String[] args) {
        List<FP04_Course> courses = List.of(
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

        Comparator<FP04_Course> comparingByNoOfStudentsAndReviewScore = Comparator.comparing(FP04_Course::getNoOfStudents)
                .thenComparing(FP04_Course::getReviewScore);

        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .collect(Collectors.toList())
        );

        /**
         * Set LIMIT count
         */
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .limit(5)
                        .collect(Collectors.toList())
        );

        /**
         * Set SKIP count
         */
        System.out.println(
                courses.stream()
                        .sorted(comparingByNoOfStudentsAndReviewScore)
                        .skip(3)
                        .collect(Collectors.toList())
        );

        /**
         * Found SUM of number of students present in the resultant stream of courses
         * Used mapToInt instead of map to be more specific of the data type that's being mapped to
         * sum() returns int or double
         */
        System.out.println(
                courses.stream()
                        .filter(course -> course.getReviewScore() > 95)
                        .mapToInt(FP04_Course::getNoOfStudents)
                        .sum()
        );

        /**
         * Found AVERAGE of number of students present in the resultant stream of courses
         * Used mapToInt instead of map to be more specific of the data type that's being mapped to
         * average() returns optional
         */
        System.out.println(
                courses.stream()
                        .filter(course -> course.getReviewScore() > 95)
                        .mapToInt(course -> course.getNoOfStudents())
                        .average()
        );

        /**
         * Found COUNT of the resultant
         * Used mapToInt instead of map to be more specific of the data type that's being mapped to
         * count() returns int
         */
        System.out.println(
                courses.stream()
                        .filter(course -> course.getReviewScore() > 95)
                        .mapToInt(course -> course.getNoOfStudents())
                        .count()
        );

        /**
         * Found MIN of the resultant
         * Used mapToInt instead of map to be more specific of the data type that's being mapped to
         */
        System.out.println(
                courses.stream()
                        .filter(course -> course.getReviewScore() > 95)
                        .mapToInt(course -> course.getNoOfStudents())
                        .min()
        );

        /**
         * Found MAX of the resultant
         * Used mapToInt instead of map to be more specific of the data type that's being mapped to
         */
        System.out.println(
                courses.stream()
                        .filter(course -> course.getReviewScore() > 95)
                        .mapToInt(course -> course.getNoOfStudents())
                        .max()
        );

        /**
         * Grouped as per course category
         * Mapped all courses in that category
         */
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(FP04_Course::getCategory))
        );

        /**
         * Grouped as per course category
         * Mapped the count of courses in that category. Looked similar to key=value format
         */
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(FP04_Course::getCategory,
                                Collectors.counting()))
        );

        /**
         * Grouped as per course category
         * Mapped the course names in that category
         */
        System.out.println(
                courses.stream()
                        .collect(Collectors.groupingBy(FP04_Course::getCategory,
                                Collectors.mapping(FP04_Course::getName, Collectors.toList())))
        );

    }
}