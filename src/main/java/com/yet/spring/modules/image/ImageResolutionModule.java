package com.yet.spring.modules.image;

import com.drew.imaging.jpeg.JpegMetadataReader;
import com.drew.imaging.jpeg.JpegProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import com.drew.metadata.exif.ExifSubIFDDirectory;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

@Component
public class ImageResolutionModule implements IImageFileModule {
    @Override
    public String getDescription() {
        return "Функция выводит разрешение файла в пикселях";
    }

    @Override
    public void execute(String filePath) {
        File jpegFile = new File(filePath);
        Metadata metadata;
        try {
            metadata = JpegMetadataReader.readMetadata(jpegFile);
            Directory exif = metadata.getFirstDirectoryOfType(ExifSubIFDDirectory.class);
            if (exif == null) {
                System.out.println("Нет exif информации об изображении");
                return;
            }
            String resolution = exif.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_HEIGHT) +
                    " x " + exif.getString(ExifSubIFDDirectory.TAG_EXIF_IMAGE_WIDTH) + " pixels";
            System.out.println(resolution);
        }  catch (IOException | JpegProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
