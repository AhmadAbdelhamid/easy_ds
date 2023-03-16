package org.example.data_structures.dynamic_arrays.int_array;

import java.util.Arrays;

public class IntArrayImpl implements IntArray {
    
    private static final int DEFAULT_CAPACITY = 8;
    Integer[] array;
    
    /**
     * @param [length] refers to the number of elements that are currently stored in the array.
     * It represents the size of the array in terms of the number of elements it currently holds.
     */
    int length = 0;
    /**
     * refers to the maximum number of elements that an array can hold.
     * It represents the total amount of memory allocated for the array.
     */
    public int capacity = 0;
    
    /**
     * Init array @param DEFAULT_CAPACITY
     */
    public IntArrayImpl() {
        this(DEFAULT_CAPACITY);
    }
    
    public IntArrayImpl(int capacity) {
        if (capacity < 0) throw new IllegalArgumentException("Illegal Capacity" + capacity);
        this.capacity = capacity;
        array = new Integer[capacity];
    }
    
    public IntArrayImpl(int[] array) {
        //TODO: I need to implement arrays copy.
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
    public int get(int index) {
        return array[index];
    }
    
    @Override
    public int indexOf(int element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element)
                return i;
        }
        return -1;
    }
    
    @Override
    public boolean contains(int element) {
        return indexOf(element) != -1;
    }
    
    @Override
    public void set(int index, int element) {
        array[index] = element;
    }
    
    @Override
    public void add(int element) {
        if (length == capacity) {
            capacity *= 2; //double the size
            copyArray();
        }
        array[length++] = element;
    }
    
    private void copyArray() {
        Integer[] new_array = new Integer[capacity];
        for (int i = 0; i < length; i++) {
            new_array[i] = array[i];
        }
        array = new_array;
    }
    
    @Override
    public int removeAt(int index) {
        if (index >= length || index < 0) throw new IndexOutOfBoundsException();
        Integer removedElement = array[index];
        Integer[] new_array = new Integer[length - 1]; // new_array size will be less than array size by one
        for (int i = 0, j = 0; i < length; i++, j++) {
            if (i == index)
                j--; //skip for new array to replace removed element with next element
            else
                new_array[j] = array[i];
        }
        array = new_array;
        capacity = --length;
        
        return removedElement;
    }
    
    @Override
    public boolean remove(int element) {
        for (int i = 0; i < length; i++) {
            if (array[i] == element) {
                removeAt(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void clear() {
        for (int i = 0; i < length/*length or capacity*/; i++) {
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
