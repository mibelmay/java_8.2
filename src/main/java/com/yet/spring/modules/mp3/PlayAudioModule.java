package com.yet.spring.modules.mp3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.decoder.Manager;
import javazoom.jl.player.*;
import org.springframework.stereotype.Component;

@Component
public class PlayAudioModule implements IMp3FileModule {
    @Override
    public String getDescription() {
        return "Функция проигрывает аудио файл";
    }

    @Override
    public void execute(String filePath) {
        try {
            FileInputStream fis = new FileInputStream(filePath);
            Player playMP3 = new Player(fis);
            Thread thread = new Thread(() -> {
                try {
                    playMP3.play();
                } catch (JavaLayerException e) {
                    throw new RuntimeException(e);
                }
            });
            thread.start();
            System.out.println("Нажмите enter чтобы остановить");


            Scanner scanner = new Scanner(System.in);
            String ch = scanner.nextLine();

            playMP3.close();
        } catch (FileNotFoundException | JavaLayerException e) {
            throw new RuntimeException(e);
        }
    }
}
