package CustomCollections;

public class CLinkedList<T> {
    private CNode<T> head;
    private CNode<T> tail;
    private int size;

    public boolean isEmpty()
    {
        return size == 0;
    } // Проверка на пустой список

    public int getSize()
    {
        return size;
    } // Получить размер списка

    /*
    Добавить новый элемент в список
    Увеличить размер списка
     */
    public void AddElement(T data)
    {
        CNode<T> node = new CNode<>(data); // Создаем новый элемент списка и записываем в него значение

        if (head == null) // Проверяем на null головной элемент списка
        {
            head = node; // И если он пустой, присваеваем ему созданный элемент списка
        }
        else
        {
            tail.Next = node; // Иначе мы созданный элемент списка записываем в следующий элемент списка после головного
        }

        tail = node; // Присваеваем созданный элемент последнему хвостовому элементу списка
        size = size + 1; // Увеличиваем размер списка на единицу
    }

    // Получение значения головного элемента списка
    public T getElement()
    {
        CNode<T> temp = head; // Создаем временное поле для хранения значения текущего головного элемента
        Remove(head.Data); // Удаляем головной элемент
        return temp.Data; // Возвращаем временное поле с данными
    }

    // Удаление элемента по входящим данным
    public boolean Remove(T data)
    {
        CNode<T> current = head; // Создаем временное поле для хранения головного элемента списка
        CNode<T> previous = null; // Создаем временное поле для хранения элемента перед головным элементом списка

        /*
        Для перебора значений всех элементов списка запускаем цикл и ждем,
        когда эн закончит перебор всех элементов попав в null
         */
        while (current != null && current.Data != null)
        {
            if (current != null && current.Data != null) // Когда перебор попадает null значения
            {
                if (previous != null) // Проверяем присвоено ли значение временному полю
                {
                    previous.Next = current.Next; // предыдущий элемент теперь становится на замену текущего элемента

                    if (current.Next == null)
                    {
                        tail = previous; // предыдущий элемент теперь становится хвостовым элементом списка
                    }
                }
                else
                {
                    head = head.Next; // головному элементу списка присваиваем значение следующего за ним элемента

                    if (head == null)
                    {
                        tail = null;
                    }
                }

                size = size - 1; // уменьшаем размер списка на единицу
                return true;
            }

            previous = current;
            current = current.Next;
        }

        return  false;
    }

    // Добавить элемент первым в список
    public void AddFirst(T data)
    {
        CNode<T> node = new CNode<>(data); // Создаем новый элемент списка и записываем в него значение
        node.Next = head; // для нового элемента списка головное значение должно стать следующим элементом
        head = node; // теперь головным элементом будет считаться новосозданный элемент

        if (isEmpty()) // если же список был пустым
        {
            tail = head; // хвостовой элемент станет головным элементом списка
        }

        size = size + 1; // размер списка увеличиваем на единицу
    }

    // Проверка на наличие данных в списке
    public boolean Contains(T data)
    {
        CNode<T> current = head; // создаем временное поле для хранения головного элемента списка

        /*
        Для перебора значений всех элементов списка запускаем цикл и ждем,
        когда эн закончит перебор всех элементов попав в null
         */
        while (current != null && current.Data != null)
        {
            if (current.Data == data) return true; // если данные в списке найдены, возвращаем true
            current = current.Next;
        }
        return false; // если данные в списке не найдены, возвращаем false
    }

    // зачищаем все элементы списка
    public void Clear()
    {
        head = null;
        tail = null;
        size = 0;
    }
}
