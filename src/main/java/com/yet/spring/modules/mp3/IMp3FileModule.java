package com.yet.spring.modules.mp3;

import com.yet.spring.modules.IFileModule;

public interface IMp3FileModule extends IFileModule {
    @Override
    default boolean isFileSupported (String fileName) {
        return fileName.endsWith(".mp3");
    }
}
