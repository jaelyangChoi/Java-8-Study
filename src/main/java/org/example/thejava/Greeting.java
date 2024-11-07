package org.example.thejava;

public class Greeting {
    private String message;

    public Greeting() {
        this.message = "hello";
    }

    public Greeting(String message) {
        this.message = message;
    }

    public String hello(String name) {
        return "hello " + name;
    }

    public static String hi(String name) {
        return "hi " + name;
    }
}
