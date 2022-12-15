package org.example;



import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.JacksonXmlModule;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;


import java.io.File;
import java.io.IOException;
import java.util.List;

public abstract class XmlS implements InterfaceS<Employee> {

    private ObjectMapper objectMapper;

    public XmlS() {
        JacksonXmlModule xmlModule = new JacksonXmlModule();
        xmlModule.setDefaultUseWrapper(false);
        objectMapper = new XmlMapper(xmlModule);
        objectMapper.registerModule(new JavaTimeModule());
    }

    @Override
    public void writeObject(String fileName, Employee object) {
        try{
            objectMapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public Employee readObject(String fileName) {
        try{
            var res = objectMapper.readValue(new File(fileName), Employee.class);
            return (Employee) res;
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void writeList(String fileName, List<Employee> object) {
        try{
            objectMapper.writeValue(new File(fileName), object);
        }
        catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Employee> readObjectsList(String fileName) {
        try{
            return objectMapper.readerForListOf(Employee.class).readValue(new File(fileName));
        }
        catch(IOException e){
            throw new RuntimeException(e);
        }
    }
}
