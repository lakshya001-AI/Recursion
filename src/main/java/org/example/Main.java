package org.example;

public class Main {
    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.insert(34);
        recursion.insert(45);
        recursion.insert(67);
        recursion.insert(90);

        System.out.println();
        System.out.println(recursion.contain(34));
        System.out.println();

        //recursive contain method called here
        System.out.println(recursion.rContain(45));
        System.out.println();

        //recursive insert method called here
        recursion.rInsert(36);
        System.out.println(recursion.rContain(36));


    }
}