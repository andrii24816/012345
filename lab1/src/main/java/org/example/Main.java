package org.example;



public class Main {
    public static void main(java.lang.String[] args) {

        People Tom = new People.Builder()
        .withName("Tom")
        .withPhoneNumber(3806676)
        .withExp(35)
        .withCodeP(9529)
                .build();

        People Tom1 = new People.Builder("Tom").build();

        People jim = new People.Builder("jim", 23566, 84, 878784).build();
        System.out.println(Tom);
        System.out.println(Tom1);
        System.out.println(jim);

        System.out.println(Tom.hashCode());
        System.out.println(Tom.equals(Tom1));
        System.out.println(Tom1.equals(jim));

        Employee sam = new Employee("Sam", "Oracle");
        System.out.println(sam.toString());

        Employee sam1 = new Employee("Sam", "Apple", "director",15222);
        System.out.println(sam1.toString());

        System.out.println(sam1.equals(sam));
        System.out.println(sam.hashCode());



    }
}