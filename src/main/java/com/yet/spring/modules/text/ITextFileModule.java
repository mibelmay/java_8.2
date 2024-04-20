package com.yet.spring.modules.text;

import com.yet.spring.modules.IFileModule;

public interface ITextFileModule extends IFileModule {
    @Override
    default boolean isFileSupported(String fileName) {
        return fileName.endsWith(".txt") || fileName.endsWith(".docx");
    }
}
