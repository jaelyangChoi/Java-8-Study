package org.example.thejava;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;

public class methodReference {

    public static void main(String[] args) {
        //스태틱 메서드 참조
        UnaryOperator<String> staticRef = Greeting::hi;
        staticRef.apply("jaeryang");

        //인스턴스 메소드 참조
        Greeting greeting = new Greeting();
        UnaryOperator<String> instanceRef = greeting::hello;
        instanceRef.apply("jaeryang");

        //생성자 참조
        Supplier<Greeting> greetingSupplier = Greeting::new;
        greetingSupplier.get();

        //인자가 있는 생성자
        Function<String, Greeting> greetingFunction = Greeting::new;
        greetingFunction.apply("jaeryang");

        //임의의 인스턴스의 메소드 참조
        String[] names = {"jaeryang", "jaelim", "janghwan"};
        // new Comparator<String>() compare 구현
        Arrays.sort(names, String::compareToIgnoreCase); //"jaeryang".compareToIgnoreCase("jaelim")
    }
}
