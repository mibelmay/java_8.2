package com.yet.spring.modules;

public interface IFileModule {
    boolean isFileSupported(String fileName);
    String getDescription();
    void execute(String filePath);
}
