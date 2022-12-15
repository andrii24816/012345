//package org.example;
//import com.example.gymde.lab1.Emloyee;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
//
//import java.io.File;
//import java.io.IOException;
//import java.nio.file.Paths;
//import java.util.List;
//
//public class JsonS implements InterfaceS<Emloyee> {
//
//    private ObjectMapper objectMapper;
//
//
//    public JsonS() {
//        objectMapper = new ObjectMapper();
//        objectMapper.registerModule(new JavaTimeModule());
//    }
//
//    @Override
//    public void writeObject(String fileName, Emloyee object) {
//        try {
//            objectMapper.writeValue(new File(fileName), object);
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }
//    }
//
//
//    @Override
//    public Emloyee readObject(String fileName) {
//        try{
//            var res = objectMapper.readValue(Paths.get(fileName).toFile(), Emloyee.class );
//            return res;
//        }
//        catch (IOException e){
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public void writeList(String fileName, List object) {
//        try{
//            objectMapper.writeValue(new File(fileName), object);
//        }
//        catch(IOException e){
//            throw new RuntimeException(e);
//        }
//    }
//
//    @Override
//    public List readObjectsList(String fileName) {
//        try{
//            List res = objectMapper.readerForListOf(Emloyee.class).readValue(new File(fileName));
//            return res;
//        }
//        catch(IOException e){
//            throw new RuntimeException(e);
//        }
//    }
//
//}
//
