package programming;

import java.util.List;

public class FP02_Structured {
    public static void main(String[] args) {
        List<Integer> numbers = List.of(12, 9, 13, 4, 6, 2, 4, 12, 15);
        int sum = addListUsingStructured(numbers);
        System.out.println(sum);
    }

    /**
     * Printed sum of all the numbers in the list using Structured/ Traditional way
     */
    private static int addListUsingStructured(List<Integer> numbers) {
        int sum = 0;
        for(int n: numbers) sum += n;
        return sum;
    }
}
