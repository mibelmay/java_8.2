package com.yet.spring.modules.directory;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ListFilesInfoModule implements IDirectoryModule {
    @Override
    public String getDescription() {
        return "Выводит количество файлов в каталоге";
    }

    @Override
    public void execute(String filePath) {
        File[] dir = new File(filePath).listFiles();
        if (dir == null || dir.length == 0) {
            System.out.println("Каталог пуст"); return;
        }
        long count = 0;
        for (var file : dir) {
            if (file.isFile())
                count += 1;
        }
        System.out.println("Количество файлов в каталоге: " + count);
    }
}
