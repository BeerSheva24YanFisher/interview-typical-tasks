package telran.interview;
public class MyArray<T> {
	private Object[] myArray;
    private int size;

	public MyArray(int size) {
        this.size = size;
        this.myArray = new Object[size];
	}
	
	public void setAll(T value) {
        for (int i = 0; i < size; i++) {
            myArray[i] = value;
        }
		
	}

    public void set(int index, T value) {
        if (index >= 0 && index < size) {
            myArray[index] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }
	
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index >= 0 && index < size) {
            return (T) myArray[index];
        } else {
            throw new  ArrayIndexOutOfBoundsException();
        }
    }
	
}