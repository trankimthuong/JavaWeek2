package ClassLinkedListBasic;

public class TestMyLinkedList {
    public static void main(String[] args) {
        System.out.println("/=/=/=/= TESTING /=/=/=/=");
        MyLinkedList link1 = new MyLinkedList(10);
        link1.addFirst(11);
        link1.addFirst(12);
        link1.addFirst(13);

        link1.add(4,9);
        link1.add(4,8);
        link1.printList();
    }
}
