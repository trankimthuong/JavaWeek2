package MethodOfArrayList;

import testList.MyArrayList;

public class MyListTest {
    public static void main(String[] args) {
        MyList<String> list = new MyList<String>();

        list.add(0,"America");
        System.out.println("(1)" + list);
        list.add(0,"Canada");
        System.out.println("(2)" + list);
        list.add(1,"Russia");
        System.out.println("(3)" + list);
        list.add(2,"France");
        System.out.println("(4)" + list);
        list.add(2, "Germany");
        System.out.println("(5)" + list);
        list.add(5, "Norway");
        System.out.println("(6)" + list);
        list.remove(1);
        System.out.println("(7)" + list);
        list.remove(2);
        System.out.println("(8)" + list);

        System.out.println(list.contains("canada"));
        System.out.println(list.contains("Canada"));
        System.out.println(list.contains("America"));
    }
}
