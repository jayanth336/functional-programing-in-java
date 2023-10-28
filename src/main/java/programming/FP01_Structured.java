package programming;

import java.util.List;

public class FP01_Structured {
    public static void main(String[] args) {
        printAllNumbersInListStructured(List.of(12,4,5,77,3,2,1,0));
        printAllEvenNumbersInListStructured(List.of(12,4,5,77,3,2,1,0));
    }

    /**
     * Used Structural/ Traditional way of printing list elements
     * Used enhanced for loop
     */
    private static void printAllNumbersInListStructured(List<Integer> numbers) {
        for(int i: numbers) {
            System.out.println(i);
        }
    }

    /**
     * Printed even numbers in structured way
     */
    private static void printAllEvenNumbersInListStructured(List<Integer> numbers) {
        for(int i: numbers) {
            if(i%2==0) System.out.println(i);
        }
    }
}
