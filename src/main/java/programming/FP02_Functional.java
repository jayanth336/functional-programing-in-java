package programming;

import java.util.List;

public class FP02_Functional {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListUsingFunctional(numbers);
        System.out.println(sum);
        System.out.println(addListUsingFunctionalSimpler(numbers));
        System.out.println(printMinOfTheList(numbers));
        System.out.println(printMaxOfTheList(numbers));

        /**
         * Intermediate Operations - Operations which return Stream are Intermediate Operations
         * Methods involved in Intermediate Operations - map(), sorted(), distinct(), filter()
         */

        /**
         * Terminal Operations - Operations which return specific type of data like void, List, etc. are Terminal Operations
         * Methods involved in Terminal Operations - forEach(), collect(),
         */
    }

    private static int sum(int a, int b) {return a+b;}

    /**
     * Used reduce method to reduce entire list to one value - it performs reduction operation
     * Syntax reduce(initial_value, accumulating_function)
     */
    private static int addListUsingFunctional(List<Integer> number) {
        return number.stream()
                .reduce(0, FP02_Functional::sum); //Reduce Method
    }

    /**
     * Simpler approach
     * Put accumulating function definition in form of lambda expression
     */
    private static int addListUsingFunctionalSimpler(List<Integer> numbers) {
        return numbers.stream()
                .reduce(0, (x,y) -> x+y);
    }

    /**
     * Used reduce method to determine min value from the list
     * Understood the logic with an example by fixing an imaginary value for max (=1000)
     */
    private static int printMinOfTheList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer.MAX_VALUE, (x,y) -> (y<x) ? y : x);
    }

    /**
     * Used reduce method to determine max value from the list
     * Understood the logic with an example by fixing an imaginary value for min (=0)
     */
    private static int printMaxOfTheList(List<Integer> numbers) {
        return numbers.stream()
                .reduce(Integer.MIN_VALUE, (x,y) -> (x<y) ? y : x);
    }
}
