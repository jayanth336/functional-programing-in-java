package programming;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class G_Coding_Exercise {
    static List<Integer> list = new ArrayList<>(List.of(1,2,3,4,5,5,6,6,7));

    public static void main(String[] args) {
        previousDayDate();
        currentDayDate();
        totalDistinctNumbers();
        totalNumbers();
        duplicateCount();
        appendCharacter();
        sumAListWithInitialValue100();
        sumAListWithoutInitialValue();
        sort2ListsInDescendingOrder();
        oddNumbers();
        evenNumbers();
        secondLowestNumber();
        secondHighestNumber();
        maxAndMinInAnArray();
        duplicateStrings();
        isTheNumberPalindrome();
        duplicateNumbersUsingSet();
        primeNumberOrNot();
        replaceAStringInList();
    }

    private static void replaceAStringInList() {
        List<String> list = new ArrayList<>(List.of("java", "kafka", "react", "spring", "aws"));
        list.set(2, "git");
        System.out.println(list);
    }

    private static void primeNumberOrNot() {
        int n = 312;
        System.out.println(
                IntStream.rangeClosed(2, n/2)
                        .anyMatch(i -> n%i==0));
    }

    private static void duplicateNumbersUsingSet() {
        Set<Integer> set = new HashSet<>();
        list.stream()
                .filter(i -> !set.add(i))
                .forEach(System.out::println);
    }

    private static void isTheNumberPalindrome() {
        long n = 12321;
        String value = String.valueOf(n);
        int length = value.length();
        System.out.println(IntStream.rangeClosed(0, length/2)
                .allMatch(i -> value.charAt(i) == value.charAt(length-1-i)));
    }

    private static void duplicateStrings() {
        String s = "JavaApi";
        Arrays.stream(s.split(""))
                .map(i -> i.toUpperCase())
                .collect(Collectors.groupingBy(i->i, Collectors.counting()))
                .forEach((k,v) -> {
                    if(v>2) System.out.println(k + " : " + v);
                });
    }

    private static void maxAndMinInAnArray() {
        int[] ar = {1,2,3,4,5};

        System.out.println();
        System.out.println((
                Arrays.stream(ar)
                        .max().getAsInt())
        );

        System.out.println(
                Arrays.stream(ar)
                        .min().getAsInt()
        );
        System.out.println();
    }

    private static void secondHighestNumber() {
        System.out.println();
        System.out.println(
                list.stream()
                        .distinct()
                        .sorted(Comparator.reverseOrder())
                        .skip(1)
                        .reduce((a,b) -> (a>b)?a:b).get()
        );
    }

    private static void secondLowestNumber() {
        System.out.println();
        System.out.println(
                list.stream()
                        .distinct()
                        .sorted()
                        .skip(1)
                        .reduce((a,b) -> (a<b)?a:b).get()
        );
    }

    private static void evenNumbers() {
        System.out.println();
        list.stream()
                .filter(i -> i%2==0)
                .forEach(System.out::println);
    }

    private static void oddNumbers() {
        list.stream()
                .filter(i -> i%2==1)
                .forEach(System.out::println);
    }

    private static void sort2ListsInDescendingOrder() {
        List<Integer> oddList = Arrays.asList(1,3,5,7,9);
        List<Integer> evenList = Arrays.asList(2,4,6,8,10);

        List<Integer> flatList = Arrays.asList(oddList, evenList)
                .stream()
                .flatMap(i -> i.stream())
                .sorted()
                .toList();
        System.out.println(flatList);

    }

    private static void sumAListWithoutInitialValue() {
        System.out.println(
                list.stream()
                        .reduce((a,b) -> a+b).get()
        );
    }

    private static void sumAListWithInitialValue100() {
        System.out.println(
                list.stream()
                        .reduce(100, (a,b) -> a+b)
        );
    }

    private static void appendCharacter() {
        Stream<Character> characterStream = Stream.of('A','B','C');
        characterStream
                .map(i -> i+"_"+(char)(i+23))
                .forEach(System.out::println);
    }

    private static void duplicateCount() {
        List<Integer> duplicates = new ArrayList<>();
        list.stream()
                .collect(Collectors.groupingBy(i->i, Collectors.counting()))
                .forEach((k,v) -> {
                    if(v>1) duplicates.add(k);
                });
        System.out.println(duplicates);
    }

    private static void totalNumbers() {
        System.out.println(list.size());
    }

    private static void totalDistinctNumbers() {
        System.out.println(list.stream()
                .distinct()
                .count());
    }

    private static void currentDayDate() {
        System.out.println(LocalDate.now());
    }

    private static void previousDayDate() {
        System.out.println(LocalDate.now().minusDays(1));
    }
}
