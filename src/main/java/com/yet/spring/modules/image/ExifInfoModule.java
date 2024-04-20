package com.yet.spring.modules.image;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import org.springframework.stereotype.Component;

@Component
public class ExifInfoModule implements IImageFileModule {

    @Override
    public String getDescription() {
        return "Функция выводит информацию exif о файле изображения";
    }

    @Override
    public void execute(String filePath) {
        File jpegFile = new File(filePath);
        Metadata metadata = null;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Directory exif = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            if (exif == null) {
                System.out.println("Нет exif информации об изображении");
                return;
            }
            Iterator tags = exif.getTags().iterator();
            while (tags.hasNext()) {
                Tag tag = (Tag)tags.next();
                System.out.println(tag);
            }
        }  catch (IOException | JpegProcessingException e) {
            throw new RuntimeException(e);
        }

    }
}
