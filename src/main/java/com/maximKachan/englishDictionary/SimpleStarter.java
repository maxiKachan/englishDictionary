package com.maximKachan.englishDictionary;

import com.maximKachan.englishDictionary.utils.StreamUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

import static org.slf4j.LoggerFactory.getLogger;

public class SimpleStarter {
    private static final Logger log = getLogger(SimpleStarter.class);

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("knowledge");
        list.add("do");
        list.add("say");
        list.add("go");
        list.add("get");
        list.add("make");
        list.add("know");
        list.add("one");
        list.add("time");
        list.add("year");
        list.add("have");
        list.add("think");
        StreamUtils.printList(list);
        System.out.println(StreamUtils.findLongestWord(list));
        System.out.println(StreamUtils.findShortestWord(list));
        List<String> listFromText = StreamUtils.createListFromText("Я программист на Java и инженер по транспортным средствам. Последние пять лет я проектировал самосвалы");
        listFromText.forEach(System.out::println);
        StreamUtils.printList(StreamUtils.filterBySubstring("know", list));
    }
}
