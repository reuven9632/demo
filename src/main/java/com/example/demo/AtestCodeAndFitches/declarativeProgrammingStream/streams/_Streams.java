package com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.streams;

import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

import static com.example.demo.AtestCodeAndFitches.declarativeProgrammingStream.streams._Streams.Gender.*;

public class _Streams {
    public static void main(String[] args) {
        List<_Person> people = List.of(
                new _Person("Igor", MALE),
                new _Person("Sveta", FEMALE),
                new _Person("Orna", FEMALE),
                new _Person("Dani", MALE)
        );

        System.out.println("**********************************");
        people.stream()
                .map(person -> person.getGender())
                .collect(Collectors.toSet())    /**Set is List of unic elements*/
                .forEach(System.out::println);


        System.out.println("**********************************");
        people.stream()
                .map(person -> person.getGender())
                .collect(Collectors.toList())   /** List is Array of elements\data*/
                .forEach(System.out::println);

        System.out.println("**********************************");
        people.stream()
                .filter(person -> person.getGender().equals(MALE))
                .collect(Collectors.toList())
                .forEach(System.out::println);

        System.out.println("**********************************");
        people.stream()
                .map(person -> person.getName())
                .mapToInt(String::length)
                .forEach(System.out::println);


        
    }









    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    static class _Person{
        private String name;
        private Gender gender;
    }

    enum Gender{
        MALE,
        FEMALE,
        PREFER_NOT_TO_SAY
    }
}
