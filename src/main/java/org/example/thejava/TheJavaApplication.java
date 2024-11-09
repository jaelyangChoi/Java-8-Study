package org.example.thejava;

import org.example.thejava.IF.RunSomeThing;

import java.util.function.*;

public class TheJavaApplication {
    public static void main(String[] args) {

        RunSomeThing runSomeThing1 = new RunSomeThing() {
            @Override
            public void doIt() {
                System.out.println("Anonymous inner class");
            }
        };
        runSomeThing1.doIt();

        RunSomeThing runSomeThing2 = () -> System.out.println("lambda expression");
        runSomeThing2.doIt();


        Function<Integer, Integer> plus10 = (input) -> input + 10;
        Function<Integer, Integer> multiple10 = (input) -> input * 10;

        System.out.println(plus10.compose(multiple10).apply(2) == 30);
        System.out.println(plus10.andThen(multiple10).apply(2) == 120);

        UnaryOperator<Integer> uPlus10 = input -> input + 10;
        BinaryOperator<Integer> bMultiple10 = (input1, input2) -> input1 * input2;

        System.out.println("uPlus10 = " + uPlus10.apply(10));
        System.out.println("bMultiple10 = " + bMultiple10.apply(10, 20));

        System.out.println(plus10.compose(multiple10).apply(2) == 30);
        System.out.println(plus10.andThen(multiple10).apply(2) == 120);

        Consumer<Integer> print = (i) -> System.out.println("i = " + i);
        print.accept(2);

        Supplier<Integer> supply2 = () -> 2;
        System.out.println(supply2.get());

        Predicate<String> isStartWithA = s -> s.startsWith("a");
        System.out.println("isStartWithA.test() = " + isStartWithA.test("pineapple"));


    }
}
