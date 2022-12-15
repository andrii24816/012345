package org.example;

import java.io.IOException;
import java.util.List;

public interface InterfaceS<T> {
    void writeObject(String fileName, T object) throws IOException;

    Employee readObject(String fileName) throws IOException, InstantiationException, IllegalAccessException;

    void writeList(String fileName, List<T> object);

    List<T> readObjectsList(String fileName);
}
