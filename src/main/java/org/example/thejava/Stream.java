package org.example.thejava;

import org.springframework.util.StopWatch;

import java.util.List;

public class Stream {
    public static void main(String[] args) {

        List<String> names = List.of("jaeryang", "jaelim", "joegy", "gwang", "hwan");

        StopWatch stopWatch = new StopWatch();
        
        //직렬 처리
        stopWatch.start();

        names.stream().map(s -> {
            System.out.println(s + " => " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).toList();
        stopWatch.stop();

        System.out.println("직렬 처리 작업 시간: " + stopWatch.getLastTaskTimeMillis() + " ms");
        System.out.println();
        System.out.println("===================================================================");
        System.out.println();
        //병렬 처리
        stopWatch.start();

        names.parallelStream().map(s -> {
            System.out.println(s + " => " + Thread.currentThread().getName());
            return s.toUpperCase();
        }).toList();

        stopWatch.stop();
        System.out.println("병렬 처리 작업 시간: " + stopWatch.getLastTaskTimeMillis() + " ms");
    }
}
