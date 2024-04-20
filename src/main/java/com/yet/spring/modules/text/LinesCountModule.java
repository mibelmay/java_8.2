package com.yet.spring.modules.text;

import org.springframework.stereotype.Component;
import java.io.*;

@Component
public class LinesCountModule implements ITextFileModule {
    @Override
    public String getDescription() {
        return "Функция выводит количество строк в файле";
    }

    @Override
    public void execute(String filePath) {
        int linesCount = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            while (reader.readLine() != null) {
                linesCount++;
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Количество строк в файле: " + linesCount);
    }
}
