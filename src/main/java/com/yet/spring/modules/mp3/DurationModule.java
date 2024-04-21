package com.yet.spring.modules.mp3;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;

import com.mpatric.mp3agic.UnsupportedTagException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class DurationModule implements IMp3FileModule {
    @Override
    public String getDescription() {
        return "Функция выводит длительность трека в секундах";
    }

    @Override
    public void execute(String filePath) {
        try {
            Mp3File mp3file = new Mp3File(filePath);
            if (mp3file.hasId3v1Tag()) {
                System.out.println("Длительность трека: " + mp3file.getLengthInSeconds());
            }
        } catch (IOException | InvalidDataException | UnsupportedTagException e) {
            System.out.println(e.getMessage());
        }
    }
}
