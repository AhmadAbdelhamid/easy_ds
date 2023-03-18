package org.example.data_structures.dynamic_arrays.generic_array;

@SuppressWarnings("unchecked")
public class GenericDynamicArray<T> implements IGenericDynamicArray<T> {
    
    private T[] array;
    int length = 0;
    public int capacity;
    
    public GenericDynamicArray() {
        this(8);
    }
    
    public GenericDynamicArray(int capacity) {
        this.capacity = capacity;
        this.array = (T[]) new Object[capacity];
    }
    
    @Override
    public int size() {
        return length;
    }
    
    @Override
    public boolean isEmpty() {
        return length == 0;
    }
    
    @Override
    public T get(int index) {
        return array[index];
    }
    
    @Override
    public int indexOf(T element) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(element)) {
                return i;
            }
        }
        return -1;
    }
    
    @Override
    public boolean contains(T element) {
        return indexOf(element) != -1;
    }
    
    @Override
    public void set(int index, T element) {
        if (index < 0) throw new IllegalArgumentException();
        array[index] = element;
    }
    
    @Override
    public void insert(int index, T element) {
        if (index < 0) throw new IllegalArgumentException();
        T[] new_array = (T[]) new Object[length + 1];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                new_array[j] = element;
                j++;
            }
            new_array[j] = array[i];
        }
        capacity = ++length;
        array = new_array;
    }
    
    @Override
    public void add(T element) {
        // compare bet. length and capacity.
        if (length == capacity) {
            // double the size of array.
            capacity *= 2;
            // create new array with new capacity.
            T[] new_array = (T[]) new Object[capacity];
            // copy current array to new array.
            for (int i = 0; i < length; i++) {
                new_array[i] = array[i];
            }
            // assign current array to new one.
            array = new_array;
        }
        array[length++] = element;
    }
    
    @Override
    public T removeAt(int index) {
        if (index < 0 || index >= length) throw new IndexOutOfBoundsException();
        T removed_element = array[index];
        T[] new_array = (T[]) new Object[capacity];
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index) {
                //in this case i will be larger than j so the next element of the one to be removed will replace it.
                j--;
            } else {
                new_array[j] = array[i];
            }
        }
        capacity = --length;
        array = new_array;
        return removed_element;
    }
    
    @Override
    public boolean remove(T element) {
        for (int i = 0; i < length; i++) {
            if (array[i].equals(element)) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < length; i++) {
            array[i] = null;
        }
        length = 0;
    }
    
    @Override
    public String toString() {
        if (length == 0) return "[]";
        else {
            StringBuilder sb = new StringBuilder(length).append("[");
            for (int i = 0; i < length - 1; i++) {
                sb.append(array[i]).append(", ");
            }
            return sb.append(array[length - 1]).append("]").toString();
        }
        
    }
}
