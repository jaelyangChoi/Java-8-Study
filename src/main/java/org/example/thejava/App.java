package org.example.thejava;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Spliterator;

public class App {

    public static void main(String[] args) {
        ArrayList<String> names = new ArrayList<>();
        names.add("John");
        names.add("Jane");
        names.add("Bob");
        names.add("Mary");

        names.forEach(System.out::println);

        System.out.println("=============================================");
        Spliterator<String> spliterator1 = names.spliterator();
        Spliterator<String> spliterator2 = spliterator1.trySplit();
        while (spliterator1.tryAdvance(System.out::println)) ;
        System.out.println("=============================================");
        while (spliterator2.tryAdvance(System.out::println)) ;

        System.out.println("=============================================");
        names.removeIf(s -> s.startsWith("J"));
        names.forEach(System.out::println);
        System.out.println("=============================================");
        names.sort(String::compareToIgnoreCase);
        names.forEach(System.out::println);
        System.out.println("=============================================");

        Comparator<String> compareToIgnoreCase = String::compareToIgnoreCase;
        names.sort(compareToIgnoreCase.reversed());

        names.sort(Comparator.reverseOrder());

    }
}
