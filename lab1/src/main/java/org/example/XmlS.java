//package org.example;
//
//public class XmlS implements InterfaceS<Employee>{
//
//    private ObjectMapper objectMapper;
//
//
//
//
//    public XmlS(){
//
//        JacksonXmlModule xmlModule = new JacksonXmlModule();
//
//        xmlModule.setDefaultUseWrapper(false);
//
//        objectMapper = new XmlMapper(xmlModule);
//
//        objectMapper.registerModule(new JavaTimeModule());
//
//    }
//
//
//
//
//    @Override
//
//    public void writeObject(String fileName, Employee object){
//
//        try {
//
//            objectMapper.writeValue(new File(fileName), object);
//
//        }
//
//        catch (IOException e){
//
//            throw new RuntimeException(e);
//
//        }
//
//    }
//
//
//
//
//    @Override
//
//    public Employee readObject(String fileName){
//
//        try {
//
//            var res = objectMapper.readValue(new File(fileName), Employee.class);
//
//            return (Employee) res;
//
//        }
//
//        catch (IOException e){
//
//            throw new RuntimeException(e);
//
//        }
//
//    }
//
//
//
//
//    @Override
//
//    public void writeList(String fileName, List<Employee> object){
//
//        try {
//
//            objectMapper.writeValue(new File(fileName), object);
//
//        }
//
//        catch (IOException e){
//
//            throw new RuntimeException(e);
//
//        }
//
//    }
//
//
//
//
//    @Override
//
//    public List<Circle> readObjectsList(String fileName, Class<Employee> tClass){
//
//        try {
//
//            return objectMapper.readerForListOf(Employee.class).readValue(new File(fileName));
//
//        }
//
//        catch (IOException e){
//
//            throw new RuntimeException(e);
//
//        }
//
//    }