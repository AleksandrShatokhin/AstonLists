package CustomCollections;

import java.util.Arrays;

public class CArrayList<T>{
    private static final int capacity = 10;
    private static final double capacityMulty = 1.5f;
    private Object[] elements;
    private int size;

    public int getSize() {
        return size;
    }
    public boolean isEmpty() {
        return size == 0;
    }

    public CArrayList() {
        this.elements = new Object[capacity];
        this.size = 0;
    }

    public void AddElement(T element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        elements[size++] = element;
    }

    public void add(int index, T element) {
        checkIndex(index);
        if (size == elements.length) {
            increaseCapacity();
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public T getElement(int index) {
        checkIndex(index);
        return (T) elements[index];
    }

    public T remove(int index) {
        checkIndex(index);
        T removedElement = (T) elements[index];
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        elements[--size] = null;
        return removedElement;
    }

    public void clear() {
        for (int i = 0; i < size; i++) { //Проходимся счетчиком по массиву и ставим везде null.
            elements[i] = null;
        }
        size = 0; //Указываем нулевое количество элементов
    }

    public void sort() {
        Arrays.sort((T[]) elements, 0, size);
    }

    private void increaseCapacity() {
        int newCapacity = (int) (elements.length * capacityMulty);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
}