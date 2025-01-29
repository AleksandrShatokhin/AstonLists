package CustomCollections;

public class CLinkedList<T> {
    private CNode<T> head;
    private CNode<T> tail;
    private int count;

    public boolean IsEmpty()
    {
        return count == 0;
    }

    public int getCount()
    {
        return count;
    }

    public void AddElement(T data)
    {
        CNode<T> node = new CNode<>(data);

        if (head == null)
        {
            head = node;
        }
        else
        {
            tail.Next = node;
        }

        tail = node;
        count = count + 1;
    }

    public T getHeadElement()
    {
        CNode<T> temp = head;
        Remove(head.Data);
        return temp.Data;
    }

    public boolean Remove(T data)
    {
        CNode<T> current = head;
        CNode<T> previous = null;

        while (current != null && current.Data != null)
        {
            if (current != null && current.Data != null)
            {
                if (previous != null)
                {
                    previous.Next = current.Next;

                    if (current.Next == null)
                    {
                        tail = previous;
                    }
                }
                else
                {
                    head = head.Next;

                    if (head == null)
                    {
                        tail = null;
                    }
                }

                count = count - 1;
                return true;
            }

            previous = current;
            current = current.Next;
        }

        return  false;
    }

    public void AddFirst(T data)
    {
        CNode<T> node = new CNode<>(data);
        node.Next = head;
        head = node;

        if (IsEmpty())
        {
            tail = head;
        }

        count = count + 1;
    }

    public boolean Contains(T data)
    {
        CNode<T> current = head;
        while (current != null && current.Data != null)
        {
            if (current.Data == data) return true;
            current = current.Next;
        }
        return false;
    }

    public void Clear()
    {
        head = null;
        tail = null;
        count = 0;
    }
}
