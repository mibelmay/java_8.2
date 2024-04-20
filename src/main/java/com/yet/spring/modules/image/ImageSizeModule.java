package com.yet.spring.modules.image;

import org.springframework.stereotype.Component;

import java.io.File;

@Component
public class ImageSizeModule implements IImageFileModule {

    @Override
    public String getDescription() {
        return "Функция выводит размер изображения";
    }

    @Override
    public void execute(String filePath) {
        File file = new File(filePath);
        System.out.println("Размер изображения: " + formatFileSize(file.length()));
    }

    public String formatFileSize(long size) {
        if (size <= 0) return "0 байт";

        final String[] units = new String[]{"байт", "КБ", "МБ", "ГБ"};
        int digitGroups = (int) (Math.log10(size) / Math.log10(1024));

        return String.format("%.1f %s", size / Math.pow(1024, digitGroups), units[digitGroups]);
    }
}
