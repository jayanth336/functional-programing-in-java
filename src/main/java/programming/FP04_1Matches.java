package programming;

import java.util.List;
import java.util.function.Predicate;

public class FP04_1Matches {
    public static void main(String[] args) {
        /**
         * Created a list with custom type which is Course
         */
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

        /**
         * Checked if all the courses have review score above 95
         */
        //To display the courses that fit in to the requirement
        courses.stream()
                .filter(course -> course.getReviewScore()>95)
                .forEach(System.out::println);

        //To display boolean value collectively to check if the courses that fit in to the requirement
        //Used allMatch - All should be matched
        System.out.println(courses.stream()
                .allMatch(course -> course.getReviewScore()>90));

        System.out.println(courses.stream()
                .allMatch(course -> course.getReviewScore()>95));

        /**
         * Created a Predicated variable, so that we can use the condition without duplicating
         */
        Predicate<FP04_Course> reviewScoreGreaterThan90Predicate = course -> course.getReviewScore() > 90;
        Predicate<FP04_Course> reviewScoreGreaterThan95Predicate = course -> course.getReviewScore() > 95;

        //Used noneMatch - Not even a single match should be found
        System.out.println(courses.stream()
                .noneMatch(reviewScoreGreaterThan90Predicate));

        System.out.println(courses.stream()
                .noneMatch(reviewScoreGreaterThan95Predicate));

        //Used anyMatch - Atleast one match should be found
        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan90Predicate));

        System.out.println(courses.stream()
                .anyMatch(reviewScoreGreaterThan95Predicate));

    }
}
