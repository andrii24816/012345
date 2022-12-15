package org.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public abstract class ListOfPeople{

    public static void main(String[] args) {
        List<People> stringList = new ArrayList<>();
        stringList.add(new People.Builder("Tom").build());//добавление элементов
        stringList.add(new People.Builder("jim", 23566, 84, 878784).build());
        stringList.add(new People.Builder("Sergey", 236, 102, 878).build());
        stringList.add(new People.Builder("Sergey", 2376, 12, 8758).build());
        stringList.add(new People.Builder("Andri", 11236, 132, 8078).build());

        System.out.println("add worker\n");
        Add(stringList);
        System.out.println("Every worker In list\n");
        SeeAll(stringList);

        System.out.println("Every worker In list(Sort for exp)\n");
        Collections.sort(stringList);
        SeeAll(stringList);

        System.out.println("Every worker In list(Sort for lengh name)\n");
        NameCorparator Corp = new NameCorparator();
        stringList.sort(Corp);
        SeeAll(stringList);

        System.out.println("Found sergey`s\n");
        Found(stringList);
        System.out.println("Delete all\n");
        for(int i=stringList.size()-1; i>=0; i--) {
            DeleteLast(stringList);
        }
        check(stringList);

    }

    private static void DeleteLast(List<People> stringList) {
        stringList.remove(stringList.size() - 1);
    }

    private static void Add(List<People> stringList) {
        Scanner in = new Scanner(System.in);



        System.out.println("Input name\n");
        String Name = "Sergey";// in.nextLine();

        int Number = 0, LeaseTerm = 0, CodeP=0;
        String I1="Input number\n";
        String I2="Input exp\n";
        String I3="Input Code of pasport\n";

        boolean bError = true;
        while (bError) {
            System.out.println(I1);
            if (in.hasNextInt() &&  in.nextInt()>10000000 &&  in.nextInt()<100000000)
                Number = in.nextInt();
            else {
                I1="Input correct number\n";
                System.out.println(I1);
                in.next();
                continue;
            }
            System.out.println(I2);
            if (in.hasNextInt() &&  in.nextInt()>=0)
                LeaseTerm = in.nextInt();
            else {
                I2="Input correct exp\n";
                System.out.println(I2);
                in.next();
                continue;
            }

            System.out.println(I3);
            if (in.hasNextInt() &&  in.nextInt()>100000 &&  in.nextInt()<1000000)
                CodeP = in.nextInt();
            else {
                I3="Input corect Code of pasport\n";
                System.out.println(I3);
                in.next();
                continue;
            }
            bError = false;
            stringList.add(new People.Builder(Name, Number, LeaseTerm, CodeP).build());
        }
    }


        private static void Found(List<People> stringList) {
        for(int i=0; i<stringList.size(); i++) {
            if (stringList.get(i).Name=="Sergey") {
                System.out.println((stringList.get(i)).toString());
            }
        }
    }

    private static void check(List<People> stringList) {
        System.out.println("list empty - "+ stringList.isEmpty());
    }

    private static void SeeAll(List<People> stringList) {
        for(int i=0; i<stringList.size(); i++) {
            System.out.println((stringList.get(i)).toString());
        }
    };
};