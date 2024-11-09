package org.example.thejava.optional;


import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class App {
    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        //Spring으로 시작하는 수업이 있으면 id를 출력하라.
        Optional<OnlineClass> optional = springClasses.stream().filter(oc -> oc.getTitle().startsWith("spring")).findFirst();

        //JPA로 시작하는 수업이 없다면 비어있는 수업을 리턴하라.
        OnlineClass onlineClassNull = optional.orElse(null); //여기서 객체 반환 선언하면, 값이 있는 경우도 실행. lazy하게 처리 불가.

        //JPA로 시작하는 수업이 없다면 새로 만들어서 리턴하라.
        OnlineClass onlineClassNew = optional.orElseGet(() -> new OnlineClass(6, "jpa", true)); //실행x. supplier는 lazy.

        //JPA로 시작하는 수업이 없다면 에러를 던져라
        OnlineClass onlineClassThrow = optional.orElseThrow(NoSuchElementException::new);


    }
}
