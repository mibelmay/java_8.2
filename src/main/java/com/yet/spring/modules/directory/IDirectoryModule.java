package com.yet.spring.modules.directory;

import com.yet.spring.modules.IFileModule;

import java.io.File;

public interface IDirectoryModule extends IFileModule {
    @Override
    default boolean isFileSupported(String fileName) {
        return new File(fileName).isDirectory();
    }
}
