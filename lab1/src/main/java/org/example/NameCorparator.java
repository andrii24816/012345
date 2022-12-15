package org.example;

import java.util.*;

public class NameCorparator implements Comparator<People> {

    public int compare(People p1, People p2)
        {
            return p1.Name.length()-p2.Name.length();

    };

};