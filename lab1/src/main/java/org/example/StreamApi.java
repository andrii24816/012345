package org.example;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class StreamApi {

    public static void main(String[] args) {
        Stream<People> Ps = Stream.of(new People.Builder("Tom").build(),
                new People.Builder("jim", 23566, 84, 878784).build(),
                new People.Builder("Sergey", 236, 102, 878).build(),
                new People.Builder("Sergey", 2376, 12, 8758).build(),
                new People.Builder("Andri", 11236, 132, 8078).build());


//        Add(stringList);
//        System.out.println("Every worker In list\n");
        //       SeeAll(stream);

        //     System.out.println("Every worker In list(Sort for exp)\n");
        //     Collections.sort(stringList);
        //    SeeAll(stringList);
        //
        System.out.println("Every worker In list(Sort for lengh name)\n");
        Ps.sorted(new NameCorparator())
                .forEach(p->System.out.printf("Info{ " +
                        "Name - " + p.GetName()+ " |" +
                        "CodeP - " + p.GetCodeP() + " |" +
                        "Phone Number +" + p.GetPhoneNumber() + " |" +
                        "Exp " + p.GetExp() + "mounth |" +
                        "}\n"));


                //SeeAll(Ps);
//        Ps.forEach(p1->System.out.printf("Info{ " +
//                "Name - " + p1.GetName()+ " |" +
//                "CodeP - " + p1.GetCodeP() + " |" +
//                "Phone Number +" + p1.GetCodeP() + " |" +
//                "Exp " + p1.GetExp() + "mounth |" +
//                '}'));
           System.out.println("Found sergey`s\n");
        Ps.filter(s1 -> s1.GetName()=="Sergey")
                .forEach(s1->System.out.printf("Info{ " +
                        "Name - " + s1.GetName()+ " |" +
                        "CodeP - " + s1.GetCodeP() + " |" +
                        "Exp " + s1.GetExp() + "mounth |" +
                        "Lease Term " + s1.GetExp() + "mounth |" +
                        "}\n"));
        //  System.out.println("Delete all\n");
        //    for(int i=stringList.size()-1; i>=0; i--) {
        //         DeleteLast(stringList);
        //     }
        //     check(stringList);

    }


    private static void SeeAll(Stream<People> stream) {
            stream.forEach(p->System.out.printf("Info{ " +
                    "Name - " + p.GetName()+ " |" +
                    "CodeP - " + p.GetCodeP() + " |" +
                    "Phone Number +" + p.GetCodeP() + " |" +
                    "Lease Term " + p.GetExp() + "mounth |" +
                    '}'));
        }


    private static void DeleteLast(List<People> stringList) {
        stringList.remove(stringList.size() - 1);
    }

    private static void Add(List<People> stringList) {
        Scanner in = new Scanner(System.in);
        System.out.println("Input name\n");
        String Name = "Sergey";// in.nextLine();
        System.out.println("Input number\n");
        int Number = in.nextInt();
        System.out.println("Input exp\n");
        int LeaseTerm = in.nextInt();
        System.out.println("Input Code of pasport\n");
        int CodeP = in.nextInt();

        stringList.add(new People.Builder(Name, Number, LeaseTerm, CodeP).build());
    }

    private static void Found(List<People> stringList) {
        for (int i = 0; i < stringList.size(); i++) {
            if (stringList.get(i).Name == "Sergey") {
                System.out.println((stringList.get(i)).toString());
            }
        }
    }

    private static void check(List<People> stringList) {
        System.out.println("list empty - " + stringList.isEmpty());
    }


};