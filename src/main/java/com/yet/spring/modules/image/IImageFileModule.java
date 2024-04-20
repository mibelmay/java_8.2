package com.yet.spring.modules.image;

import com.yet.spring.modules.IFileModule;

public interface IImageFileModule extends IFileModule {
    @Override
    default boolean isFileSupported(String fileName) {
        return fileName.endsWith(".png") || fileName.endsWith(".jpg");
    }
}