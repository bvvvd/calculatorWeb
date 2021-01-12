package ru.exam.task1.services;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CalculatorService {
    private static final List<Character> consonants = List.of('а', 'о', 'и', 'е', 'ё', 'э', 'ы', 'у', 'ю', 'я');
    private static final List<Character> vowel = List.of('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'к', 'л', 'м', 'н', 'п', 'р', 'с', 'т', 'ф', 'х', 'ц', 'ч', 'ш', 'щ');

    public static Map<String, Integer> calculate(String expression) {
        Map<String, Integer> map = new HashMap<>();
        map.put("согласные", 0);
        map.put("гласные", 0);
        map.put("неопознанные", 0);

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (consonants.contains(c)) {
                Integer integer = map.get("согласные");
                if (integer != null) {
                    map.put("согласные", integer + 1);
                }
                continue;
            }

            if (vowel.contains(c)) {
                Integer integer = map.get("гласные");
                if (integer != null) {
                    map.put("гласные", integer + 1);
                }
                continue;
            }

            Integer integer = map.get("неопознанные");
            map.put("неопознанные", integer + 1);
        }

        return map;
    }
}