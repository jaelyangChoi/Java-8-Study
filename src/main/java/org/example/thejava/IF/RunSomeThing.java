package org.example.thejava.IF;

@FunctionalInterface
public interface RunSomeThing {

    abstract void doIt();

    static void printName() {
        System.out.println("Jaeryang");
    }

    default void printAge() {
        System.out.println("32");
    }
}
