package com.yet.spring.modules.text;

import org.springframework.stereotype.Component;

import java.io.*;

@Component
public class DigitsSumModule implements ITextFileModule {
    @Override
    public String getDescription() {
        return "Функция выводит сумму всех цифр в файле";
    }

    @Override
    public void execute(String filePath) {
        File file = new File(filePath);
        int sum = 0;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            int character;
            while ((character = reader.read()) != -1) {
                char ch = (char) character;
                if (Character.isDigit(ch))
                    sum += Character.getNumericValue(ch);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Сумма цифр в файле: " + sum);
    }
}