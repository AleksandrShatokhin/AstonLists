package CustomCollections;

public class CNode<T> {
    public T Data;
    public CNode<T> Next;

    public  CNode(T data)
    {
        Data = data;
    }
}
