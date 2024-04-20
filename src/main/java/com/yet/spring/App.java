package com.yet.spring;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import com.yet.spring.modules.IFileModule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication(scanBasePackages = "com.yet.spring")
public class App {
    private static List<IFileModule> modules;

    @Autowired
    public App(List<IFileModule> modules) {
        App.modules = modules;
    }

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);

        System.out.println("Введите название файла: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();
        if (!new File(fileName).exists()) {
            System.out.println("Файла с таким названием не существует");
            return;
        }

        System.out.println("Доступные модули:");
        int num = 1;
        List<IFileModule> availableModules = new ArrayList<>();
        for (var module : modules) {
            if (module.isFileSupported(fileName)) {
                availableModules.add(module);
                System.out.println(num++ + ". " + module.getDescription());
            }
        }

        System.out.println("Введите номер модуля: ");
        num = in.nextInt();
        availableModules.get(num - 1).execute(new File(fileName).getPath());
    }
}