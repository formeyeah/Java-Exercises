package com.freeland.oop.session17decorator.file;

public interface DataSource {
    void writeData(String data);
    String readData();
}
