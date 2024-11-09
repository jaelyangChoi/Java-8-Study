package org.example.thejava.stream;

import org.springframework.util.StopWatch;

import java.util.List;

/**
 * 중개 오퍼레이션 : filter, map, limit, skip, sorted, ...
 * 종료 오퍼레이션 : collect, allMatch, count, forEach, min, max, ...
 */

public class Stream {
    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();

        List<String> names = List.of("jaeryang", "jaelim", "joegy", "gwang", "hwan");

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
