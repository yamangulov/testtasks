package ru.yamangulov.testtasks;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

public class Main {
    public static void main(String[] args) {
        Map<String, Integer> words = new LinkedHashMap<>();
        String text = "Я помню чудное мгновенье:\n" +
                "Передо мной явилась ты,\n" +
                "Как мимолетное виденье,\n" +
                "Как гений чистой красоты.\n" +
                "\n" +
                "В томленьях грусти безнадежной,\n" +
                "В тревогах шумной суеты,\n" +
                "Звучал мне долго голос нежный\n" +
                "И снились милые черты.\n" +
                "\n" +
                "Шли годы. Бурь порыв мятежный\n" +
                "Рассеял прежние мечты,\n" +
                "И я забыл твой голос нежный,\n" +
                "Твои небесные черты.\n" +
                "\n" +
                "В глуши, во мраке заточенья\n" +
                "Тянулись тихо дни мои\n" +
                "Без божества, без вдохновенья,\n" +
                "Без слез, без жизни, без любви.\n" +
                "\n" +
                "Душе настало пробужденье:\n" +
                "И вот опять явилась ты,\n" +
                "Как мимолетное виденье,\n" +
                "Как гений чистой красоты.\n" +
                "\n" +
                "И сердце бьется в упоенье,\n" +
                "И для него воскресли вновь\n" +
                "И божество, и вдохновенье,\n" +
                "И жизнь, и слезы, и любовь.";

        List<String> list = split(text);
        System.out.println(list);
        System.out.println(listToMap(list));
    }

    public static List<String> split(String str){
        return Stream.of(str.split("\\s+"))
                .map (elem -> new String(elem.replaceAll("[^A-Za-zА-Яа-я\\s]", "").toLowerCase()))
                .collect(Collectors.toList());
    }

    public static Map<String, Integer> listToMap(List<String> list) {
        Map<String, Integer> map = new LinkedHashMap<>();
        for (String elem : list) {
            if (map.containsKey(elem)) {
                map.put(elem, map.get(elem) + 1);
            } else {
                map.put(elem, 1);
            }
        }
        map = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (v1, v2)->v1, LinkedHashMap::new));
        return map;
    }


}
