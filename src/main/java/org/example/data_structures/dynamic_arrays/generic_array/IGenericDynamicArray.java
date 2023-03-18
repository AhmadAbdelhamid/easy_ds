package org.example.data_structures.dynamic_arrays.generic_array;

public interface IGenericDynamicArray<T> {
    int size();
    
    boolean isEmpty();
    
    T get(int index);
    
    int indexOf(T element);
    
    boolean contains(T element);
    
    void set(int index, T element);
    void insert(int index, T element);
    
    void add(T element);
    
    T removeAt(int index);
    
    boolean remove(T element);
    
    void clear();
}
