package com.yet.spring.modules.text;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

@Component
public class CharsCountModule implements ITextFileModule {
    @Override
    public String getDescription() {
        return "Функция выводит количество вхождений каждого символа в файл";
    }

    @Override
    public void execute(String filePath) {
        try {
            Map<Character, Integer> characterCountMap = countCharacters(filePath);
            for (Map.Entry<Character, Integer> entry : characterCountMap.entrySet()) {
                System.out.println("\'" + entry.getKey() + "\': " + entry.getValue());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Map<Character, Integer> countCharacters(String filePath) throws IOException {
        Map<Character, Integer> map = new HashMap<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int character;
            while ((character = reader.read()) != -1) {
                char ch = (char) character;
                map.put(ch, map.getOrDefault(ch, 0) + 1);
            }
        }
        return map;
    }
}
