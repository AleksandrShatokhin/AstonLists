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

    /*
    Добавить новый элемент в конец списка
    Увеличить размер списка
     */
    public void AddElement(T element) {
        if (size == elements.length) {
            increaseCapacity(); // если достигнут последний элемент массива, увеличиваем его размер
        }
        elements[size + 1] = element; //Добавляем элемент в массив, увеличиваем количество элементов в списке
    }

    /*
    Добавить новый элемент в список по указанному индексу
    Сдвинуть существующие элементы вправо
    Увеличить размер списка
     */
    public void AddElement(int index, T element) {
        checkIndex(index); // проверяем индекс (должен быть не меньше нуля и не больше размера массива)
        if (size == elements.length) {
            increaseCapacity(); // если достигнут последний элемент массива, увеличиваем его размер
        }
        System.arraycopy(elements, index, elements, index + 1, size - index); //Сдвигаем элементы на 1 вправо
        elements[index] = element; //Добавляем элемент
        size = size + 1; // увеличиваем размер массива на единицу
    }

    // Получить элемент по указанному индексу
    public T getElement(int index) {
        checkIndex(index); // проверяем индекс (должен быть не меньше нуля и не больше размера массива)
        return (T) elements[index]; // возвращаем елемент массива
    }

    // Удалить элемент массива по указанному индексу
    public T remove(int index) {
        checkIndex(index); // проверяем индекс (должен быть не меньше нуля и не больше размера массива)
        T removedElement = (T) elements[index]; // берем элемент по указанному индексу
        System.arraycopy(elements, index + 1, elements, index, size - index - 1); // сдвигаем массив за исключением выбранного элемента
        elements[size - 1] = null; // зачищаем последний элемент
        return removedElement; // возвращаем удаляемый эдемент
    }

    // Зачистить элементы массива
    public void clear() {
        for (int i = 0; i < size; i++) { // Перебираем все элементы массива и устанавливаем им значение null
            elements[i] = null;
        }
        size = 0; //Указываем нулевое количество элементов
    }

    public void sort() {
        Arrays.sort((T[]) elements, 0, size);
    } // Сортируем список

    // Увеличить емкость массива на 1.5
    private void increaseCapacity() {
        int newCapacity = (int) (elements.length * capacityMulty);
        elements = Arrays.copyOf(elements, newCapacity);
    }

    // Проверить индекс (должен быть не меньше нуля и не больше размера массива)
    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
        }
    }
}