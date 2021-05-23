package ru.geekbrains.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class Lesson8Application {

    public static void main(String[] args) {
        Stream.of(1,2,3,4,5,6,7,8,9,10).skip(5).limit(5).collect(Collectors.toList());
        SpringApplication.run(Lesson8Application.class, args);
    }

}
