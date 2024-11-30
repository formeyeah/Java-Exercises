package com.freeland.oop.session09liskov.java.codesmell;

import java.io.File;
import java.io.IOException;

public interface FileSystem {
    File[] listFiles(String path);

    void deleteFile(String path) throws IOException;
}