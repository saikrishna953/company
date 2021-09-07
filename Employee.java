package com.company;

import java.util.Comparator;

public class Employee {

    int id;
    String name;

    public static Comparator<Employee> employeeidCompare =  new Comparator<Employee>() {
        @Override
        public int compare(Employee o1, Employee o2) {

            return o1.id - o2.id;
        }
    };
}
