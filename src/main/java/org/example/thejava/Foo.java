package org.example.thejava;

import java.util.function.IntConsumer;

public class Foo {
    public static void main(String[] args) {
        Foo foo = new Foo();
        foo.run();
    }

    private void run() {
        int baseNumber = 10;

        //Local class
        class LocalClass {
            void pintBaseNumber() {
                int baseNumber = 11;
                System.out.println("baseNumber = " + baseNumber); //11
            }
        }

        //Anonymous class
        IntConsumer integerConsumer = new IntConsumer() {
            public void accept(int baseNumber) {
                System.out.println("baseNumber = " + baseNumber); //11
            }
        };

        //Lambda
        IntConsumer intConsumer = i -> System.out.println(i + baseNumber); //i를 baseNumber로 변경 불가..
    }
}
