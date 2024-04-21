package com.yet.spring.modules.directory;

import com.drew.metadata.Directory;
import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ListFilesModule implements IDirectoryModule {
    @Override
    public String getDescription() {
        return "Функция выводит список всех файлов в каталоге";
    }

    @Override
    public void execute(String filePath) {
        File[] dir = new File(filePath).listFiles();
        if (dir == null || dir.length == 0) {
            System.out.println("Каталог пуст"); return;
        }
        System.out.println("Список файлов : ");
        for (var file : dir) {
            System.out.print((file.isFile() ? file.getName() + "\n" : ""));
        }
    }
}
