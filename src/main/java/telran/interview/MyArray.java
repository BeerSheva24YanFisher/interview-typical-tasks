package telran.interview;

import java.util.HashMap;

public class MyArray<T> {
    T valueDef;
    private HashMap<Integer, T> myArray;
    private int size;

    public MyArray(int size) {
        this.size = size;
        this.myArray = new HashMap<>(size);
    }

    public void setAll(T value) {
        myArray = new HashMap<>();
        valueDef = value;
    }

    public void set(int index, T value) {
        if (index >= 0 && index < size) {
            myArray.put(index, value);
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            T res = myArray.get(index);
            return res != null ? res : valueDef;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
}