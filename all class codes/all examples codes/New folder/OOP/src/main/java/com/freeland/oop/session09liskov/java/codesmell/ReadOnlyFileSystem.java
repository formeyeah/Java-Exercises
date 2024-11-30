package com.freeland.oop.session09liskov.java.codesmell;

import java.io.File;
import java.io.IOException;

public class ReadOnlyFileSystem implements FileSystem {
    public File[] listFiles(String path) {
        // code to list files
        return new File[0];
    }

    public void deleteFile(String path) throws IOException {
        throw new UnsupportedOperationException(); //Throws an Exception for a Behavior It Can’t Fulfill
    }
}