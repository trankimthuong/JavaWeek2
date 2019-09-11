package MethodOfLinkedList;

public class MyLinkedList<E> {

    private class Node<E>{
        private Node next;
        private Node prev;
        private E data;

        public Node(E data){
            this.data = data;
        }

        public Node() {

        }

        public E getData(){
            return this.data;
        }

    }

    private Node head;
    private Node tail;
    public int numNodes;

    public MyLinkedList(){

    }

    public void addFirst(E e){
        Node<E> newNode = new Node<>(e);
        if(this.head == null){
            this.head = this.tail = newNode;
        }else{
            this.head.prev = newNode;
            newNode.next = head;
            head = newNode;
        }
        this.numNodes++;
    }

    public void addLast(E e){
        Node<E> newNode = new Node<>(e);
        if(tail == null){
            this.head = this.tail = newNode;
        }else{
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        this.numNodes++;
    }

    public void add(int index, E e){
        if(index == 0) addFirst(e);
        else if(index >= this.numNodes) addLast(e);
        else{
            Node<E> current = head;
            for(int i = 1; i < index; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            temp.prev = current.next;
            (current.next).prev = current;
            this.numNodes++;
        }
    }

    public E removeFirst(){
        if(this.numNodes == 0) return null;
        else{
            Node<E> temp = this.head;
            head.next.prev = null;
            head = head.next;
            this.numNodes--;
            return temp.getData();
        }
    }

    public E removeLast(){
        if(this.numNodes == 0) return null;
        else if(this.numNodes == 1){
            Node<E> temp = head;
            head = tail = null;
            this.numNodes = 0;
            return temp.data;
        }else{
            Node<E> current = head;
            for(int i = 1; i < this.numNodes - 1; i++){
                current = current.next;
            }

            Node<E> temp = tail;
            tail = current;
            tail.next = null;
            this.numNodes--;
            return temp.data;
        }
    }

    public E remove(int index){
        if(index < 0 || index >= this.numNodes) return null;
        else if(index == 0) return removeFirst();
        else if(index == this.numNodes - 1) return removeLast();
        else{
            Node<E> current = head;
            for(int i = 0; i < index - 1; i++){
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = temp.next;
            temp.next.prev = current;
            this.numNodes--;
            return temp.data;
        }
    }

    public boolean remove(E e){
        return true;
    }

    public int size(){
        return this.numNodes;
    }

    public MyLinkedList clone(){
        MyLinkedList<E> newList = new MyLinkedList<>();
        newList.head = this.head;
        newList.tail = this.tail;
        newList.numNodes = this.numNodes;
        return  newList;
    }

    public boolean contains(E o){
        Node temp = this.head;
        for(int i = 0; i < this.numNodes; i++){
            if(temp.data.equals(o))
                return true;
            temp = temp.next;
        }
        return false;
    }

    public int indexOf(E o){
        Node temp = this.head;
        int check = -1;
        for(int i = 0; i < this.numNodes; i++){
            if(temp.data.equals(o)){
                check = i;
                break;
            }
            temp = temp.next;
        }
        return check;
    }

    public boolean add(E e){
        return true;
    }

    public E get(int index){
        Node<E> current = this.head;
        for(int i = 0; i < index; i++){
            current = current.next;
        }
        return current.getData();
    }

    public E getFirst(){
        Node<E> current = this.head;
        return current.data;
    }

    public E getLast(){
        Node<E> current = this.head;
        for(int i = 0; i < this.numNodes - 1; i++){
            current = current.next;
        }
        return current.data;
    }

    public void clear(){
        if(this.numNodes > 0){
            this.head = null;
            this.tail = null;
            this.numNodes = 0;
        }
    }

    public void printList(){
        System.out.println();
        Node temp = head;
        while (temp != null){
            System.out.print(temp.data);
            temp = temp.next;
        }
    }
}
