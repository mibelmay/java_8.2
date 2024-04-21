package com.yet.spring.modules.mp3;

import com.mpatric.mp3agic.ID3v1;
import com.mpatric.mp3agic.InvalidDataException;
import com.mpatric.mp3agic.Mp3File;
import com.mpatric.mp3agic.UnsupportedTagException;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class AudioNameModule implements IMp3FileModule {
    @Override
    public String getDescription() {
        return "Функция выводит название mp3 файла";
    }

    @Override
    public void execute(String filePath) {
        try {
            Mp3File mp3file = new Mp3File(filePath);
            if (mp3file.hasId3v1Tag()) {
                ID3v1 id3v1Tag = mp3file.getId3v1Tag();
                System.out.println("Название трека: " + id3v1Tag.getTitle());
            }
        } catch (IOException | InvalidDataException | UnsupportedTagException e) {
            throw new RuntimeException(e);
        }
    }
}
