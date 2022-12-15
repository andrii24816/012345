package org.example;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.List;

public class JsonS<Employee> implements InterfaceS<Employee> {

    private ObjectMapper objectMapper;


    public JsonS() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void writeObject(String fileName, Employee object) {
        try {
            objectMapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }


    @Override
    public org.example.Employee readObject(String fileName) {
        try{
            var res = objectMapper.readValue(Paths.get(fileName).toFile(), org.example.Employee.class);
            return res;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeList(String fileName, List object) {
        try{
            objectMapper.writeValue(new File(fileName), object);
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List readObjectsList(String fileName) {
        try{
            List res = objectMapper.readerForListOf(org.example.Employee.class).readValue(new File(fileName));
            return res;
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }

}

