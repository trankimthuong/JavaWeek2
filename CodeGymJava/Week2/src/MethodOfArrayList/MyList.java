package MethodOfArrayList;

public class MyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    private Object elements[] = (E[])new Object[DEFAULT_CAPACITY];

    public MyList(){

    }

    public MyList(int DEFAULT_CAPACITY){
        elements = new Object[DEFAULT_CAPACITY];
    }

    public void add(int index, E element){
        ensureCapacity();
        for(int i = size - 1; i >= index; i--){
            elements[i + 1] = elements[i];
        }
        elements[index] = element;
        this.size++;
    }

    public void ensureCapacity(){
        if(size >= elements.length){
            E[] newElements = (E[])(new Object[2*size + 1]);
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    private void checkIndex(int index){
        if(index < 0|| index >= size)
            throw new IndexOutOfBoundsException("index " + index + " out of bounds");
    }

    public E remove(int index){
        checkIndex(index);
        E e = (E) elements[index];
        for(int i = index; i < size - 1; i++){
            elements[i] = elements[i + 1];
        }
        elements[size - 1] = null;
        size--;
        return e;
    }

    public int size(){
        return size;
    }

    public E clone(){
        E[] cloneElements = (E[]) elements;
        return (E) cloneElements;
    }

    public boolean contains(E o){
        for(int i = 0; i < size; i++){
            if(o.equals(elements[i])){
                return true;
            }
        }
        return false;
    }

    public int indexOf(E o){
        for(int i = 0; i < size; i++){
            if(o.equals(elements[i])){
                return i;
            }
        }
        return -1;
    }

    public E get(int i){
        checkIndex(i);
        return (E) elements[i];
    }

    public void clear(){
        elements = (E[])new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder("[");
        for(int i = 0; i < size; i++){
            result.append(elements[i]);
            if(i < size - 1)
                result.append(", ");
        }

        return result.toString() + "]";
    }
}
