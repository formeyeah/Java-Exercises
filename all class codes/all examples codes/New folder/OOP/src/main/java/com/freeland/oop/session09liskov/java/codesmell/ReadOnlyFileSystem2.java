package com.freeland.oop.session09liskov.java.codesmell;

import java.io.File;
import java.io.IOException;

public class ReadOnlyFileSystem2 implements FileSystem {
    public File[] listFiles(String path) {
        // code to list files
        return new File[0];
    }

    public void deleteFile(String path) throws IOException {
        // Do nothing.
        // deleteFile operation is not supported on a read-only file system
    }
}