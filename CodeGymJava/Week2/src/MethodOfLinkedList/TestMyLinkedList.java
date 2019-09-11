package MethodOfLinkedList;

public class TestMyLinkedList {
    public static void main(String[] args) {
        MyLinkedList<String> stringList = new MyLinkedList<>();
        stringList.addFirst("c");
        stringList.addFirst("b");
        stringList.addFirst("a");
        stringList.printList();
        stringList.addLast("d");
        stringList.printList();
        stringList.add(3,"h");
        stringList.printList();

        String x = stringList.removeFirst();
        System.out.println(x);
        stringList.printList();
//        MyLinkedList newList;
//        newList = stringList.clone();
//
//        newList.printList();
//        System.out.println(stringList.contains("d"));
//        System.out.println(stringList.indexOf("f"));
          System.out.println(stringList.getLast());
    }
}
