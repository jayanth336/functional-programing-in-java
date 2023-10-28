package programming;

import java.util.List;

public class FP01_Functional {
    public static void main(String[] args) {
        printAllNumbersInListFunctional(List.of(12,4,5,77,3,2,1,0));
        printAllNumbersInListFunctionalSimpler(List.of(12,4,5,77,3,2,1,0));
        printAllEvenNumbersInListFunctional(List.of(12,4,5,77,3,2,1,0));
        printAllEvenNumbersInListFunctionalSimpler(List.of(12,4,5,77,3,2,1,0));
    }

    private static void printValue(int number) {
        System.out.println(number);
    }
    private static boolean isEven(int number) {
        return number%2 == 0;
    }

    /**
     * Used Functional programming to print list of elements
     * Focussed on what to do instead of how to do
     * Used method referencing which has syntax Classname::static_method_name
     */
    private static void printAllNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .forEach(FP01_Functional::printValue);
    }

    /**
     * Simpler approach
     */
    private static void printAllNumbersInListFunctionalSimpler(List<Integer> numbers) {
        numbers.stream()
                .forEach(System.out::println);
    }

    /**
     * Printed even numbers
     * Used method referencing for isEven static method
     * Used filter and retain only even numbers and run a for each loop only on those even numbers
     */
    private static void printAllEvenNumbersInListFunctional(List<Integer> numbers) {
        numbers.stream()
                .filter(FP01_Functional::isEven)
                .forEach(System.out::println);
    }

    /**
     * Simpler approach
     * Used lambda expression instead of having a separate method
     */
    private static void printAllEvenNumbersInListFunctionalSimpler(List<Integer> numbers) {
        numbers.stream()
                .filter(i -> i%2==0)
                .forEach(System.out::println);
    }
}
