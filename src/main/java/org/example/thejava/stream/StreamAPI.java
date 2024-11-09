package org.example.thejava.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class StreamAPI {

    public static void main(String[] args) {
        List<OnlineClass> springClasses = new ArrayList<>();
        springClasses.add(new OnlineClass(1, "spring boot", true));
        springClasses.add(new OnlineClass(2, "spring data jpa", true));
        springClasses.add(new OnlineClass(3, "spring mvc", false));
        springClasses.add(new OnlineClass(4, "spring core", false));
        springClasses.add(new OnlineClass(5, "rest api development", false));

        List<OnlineClass> javaClasses = new ArrayList<>();
        javaClasses.add(new OnlineClass(6, "The Java, Test", true));
        javaClasses.add(new OnlineClass(7, "The Java, Code manipulation", true));
        javaClasses.add(new OnlineClass(8, "The Java, 8 to 11", false));

        List<List<OnlineClass>> classList = new ArrayList<>();
        classList.add(springClasses);
        classList.add(javaClasses);


        System.out.println("# spring 으로 시작하는 수업");
        springClasses.stream()
                .filter(oc -> oc.getTitle().startsWith("spring"))
                .forEach(oc -> System.out.println(oc.getTitle()));


        System.out.println("# close 되지 않은 수업");
        springClasses.stream()
                .filter(Predicate.not(OnlineClass::isClosed))
                .forEach(o -> System.out.println(o.getTitle()));


        System.out.println("# 수업 이름만 모아서 스트림 만들기");
        springClasses.stream()
                .map(OnlineClass::getTitle)
                .forEach(System.out::println);


        //flatting : 스트림 인자가 List일 때, List에 있는 내용들을 다 꺼내서 스트림으로 만든다.
        System.out.println("# 두 수업 목록에 들어있는 모든 수업 아이디 출력");
        classList.stream()
                // .flatMap(list -> list.stream())
                .flatMap(List::stream) // => Stream<OnlineClass> 반환
                .forEach(oc -> System.out.println(oc.getId()));


        System.out.println("# 10부터 1씩 증가하는 무제한 스트림 중에서 앞에 10개 빼고 최대 10개 까지만");
        Stream.iterate(10, i -> i + 1) //무제한 스트림 생성. but 중계형 오퍼레이터라 실행x
                .skip(10)
                .limit(10)
                .forEach(System.out::println);


        System.out.println("# 자바 수업 중에 Test가 들어있는 수업이 있는지 확인");
        boolean result = javaClasses.stream()
                .anyMatch(oc -> oc.getTitle().contains("Test"));  //allMatch는 모두 true여야 true
        System.out.println("result = " + result);


        System.out.println("# 스프링 수업 중에 제목에 spring이 들어간 제목만 모아서 List로 만들기");
        List<String> collect = springClasses.stream()
                .filter(oc -> oc.getTitle().contains("spring"))
                .map(OnlineClass::getTitle)
                //.collect(Collectors.toSet())
                .toList();
        collect.forEach(System.out::println);


        System.out.println("# 초기값 0에서 시작해 각 요소를 순차적으로 더해 총합을 계산");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        //reduce : 초기값과 집계 함수(accumulator)를 받아 각 요소를 순차적으로 처리하여 결과를 계산
        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);

        System.out.println("리스트의 합: " + sum);  // 출력: 리스트의 합: 15
    }

}
