package org.example.data_structures.dynamic_arrays.int_array;

public interface IntArray {
    
    int size();
    
    boolean isEmpty();
    
    int get(int index);
    
    int indexOf(int element);//return an index for given element.
    
    boolean contains(int element);
    
    void set(int index, int element);//replace an element at given index
    
    void insert(int index, int element);//insert elements at given index with shifting elements.
    
    void add(int element);
    
    int removeAt(int index);
    
    boolean remove(int element);
    
    void clear();
}

