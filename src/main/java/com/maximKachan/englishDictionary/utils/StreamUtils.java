package com.maximKachan.englishDictionary.utils;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamUtils {
    public static void printList(List<String> list){
        list.forEach(System.out::println);
    }

    public static String findLongestWord(List<String> list){
        Stream<String> stringStream = list.stream();
        Optional<String> findOptionalString = stringStream.max(Comparator.comparingInt(String::length));
        return findOptionalString.orElse(null);
    }

    public static String findShortestWord(List<String> list){
        return list.stream().min(Comparator.comparingInt(String::length)).orElse(null);
    }

    public static List<String> createListFromText(String text){
        String[] arr = text.split(" ");
        return Stream.of(arr).map(s -> s.replaceAll("\\p{Punct}","")).collect(Collectors.toList());
    }

    public static List<String> filterBySubstring(String substring, List<String> list){

        return list.stream().filter(s -> s.contains(substring.toLowerCase())).sorted(Comparator.comparingInt(String::length)).collect(Collectors.toList());
    }
}
