package org.howard.edu.lsp.assignment6;


public class Driver {


    public static void main(String[] args) {


        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        System.out.println("Value of Set1 is:"+set1.toString());
        System.out.println("Smallest value in Set1 is:"+set1.smallest());
        System.out.println("Largest value in Set1 is:"+set1.largest());


        IntegerSet set2 = new IntegerSet();
        set2.add(3);
        set2.add(4);
        set2.add(5);


        System.out.println("Union of Set1 and Set2");
        System.out.println("Value of Set1 is:"+set1.toString());
//        Set1: [1, 2, 3]
        System.out.println("Value of Set2 is:"+set2.toString());
//        Set2: [3, 4, 5]
        set1.union(set2);// union of set1 and set2
        System.out.println("Result of union of Set1 and Set2");
        System.out.println(set1.toString());




        System.out.println("Intersection of Set1 and Set2");
        System.out.println("Value of Set1 is:"+set1.toString());
//        Set1: [1, 2, 3, 4, 5]
        System.out.println("Value of Set2 is:"+set2.toString());
//        Set2: [3, 4, 5]
        set1.intersect(set2);// intersection of set1 and set2
        System.out.println("Result of intersection of Set1 and Set2");
        System.out.println(set1.toString());


        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        System.out.println("Difference of Set1 and Set2");
        System.out.println("Value of Set1 is:"+set1.toString());
//        Set1: [1, 2, 3]
        System.out.println("Value of Set2 is:"+set2.toString());
//        Set2: [3, 4, 5]
        set1.diff(set2);// difference of set1 and set2
        System.out.println("Result of difference of Set1 and Set2");
        System.out.println(set1.toString());


        set1.clear();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        System.out.println("Complement of Set1 And Set2");
        System.out.println("Value of Set1 is:"+set1.toString());
//        Set1: [1, 2, 3]
        System.out.println("Value of Set2 is:"+set2.toString());
//        Set2: [3, 4, 5]
        set1.complement(set2);// complement of set1 and set2
        System.out.println("Result of complement of Set1 and Set2");
        System.out.println(set1.toString());


        System.out.println("Is Set1 empty?"+set1.isEmpty());
        System.out.println("Is Set2 empty?"+set2.isEmpty());


        set1.clear();
        set2.clear();
        System.out.println("Is Set1 empty?"+set1.isEmpty());
        System.out.println("Is Set2 empty?"+set2.isEmpty());


        set1.add(1);
        set1.add(2);
        set1.add(3);
        set2.add(3);
        set2.add(2);
        set2.add(1);
        System.out.println("Set1 contains 1?"+set1.contains(1));
        System.out.println("Set2 contains 1?"+set2.contains(1));


        System.out.println("Set1 equals Set2?"+set1.equals(set2));


        set1.remove(1);
        System.out.println("Set1 after removing 1:"+set1.toString());
    }
}
