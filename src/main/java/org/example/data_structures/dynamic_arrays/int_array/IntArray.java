package org.example.data_structures.dynamic_arrays.int_array;

public interface IntArray {
    
    int size();
    
    boolean isEmpty();
    
    int get(int index);
    
    int indexOf(int element);
    
    boolean contains(int element);
    
    void set(int index, int element);
    
    void add(int element);
    
    int removeAt(int index);
    
    boolean remove(int element);
    
    void clear();
}

