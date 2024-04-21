package com.yet.spring.modules.directory;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class TotalSizeCountModule implements IDirectoryModule {
    @Override
    public String getDescription() {
        return "Функция выводит подсчет размера всех файлов в каталоге";
    }

    @Override
    public void execute(String filePath) {
        File[] dir = new File(filePath).listFiles();
        if (dir == null || dir.length == 0) {
            System.out.println("Каталог пуст"); return;
        }
        long size = 0;
        for (var file : dir) {
            if (file.isFile())
                size += file.length();
        }
        System.out.println("Суммарный размер всех файлов в каталоге: " + size + " байт");
    }
}
