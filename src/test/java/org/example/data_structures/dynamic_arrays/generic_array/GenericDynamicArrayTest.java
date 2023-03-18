package org.example.data_structures.dynamic_arrays.generic_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GenericDynamicArrayTest {
    
    GenericDynamicArray<DataHolder> genericArray;
    
    
    @BeforeEach
    void setUp() {
        genericArray = new GenericDynamicArray<>(3);
    }
    
    @Test
    void size() {
    }
    
    @Test
    void isEmpty() {
    }
    
    @Test
    void get() {
    }
    
    @Test
    void indexOf() {
    }
    
    @Test
    void contains() {
    }
    
    @Test
    void set() {
    }
    
    @Test
    void insert() {
    }
    
    @Test
    void add() {
        //arrange
        genericArray.add(new DataHolder(0));
        genericArray.add(new DataHolder(1));
        genericArray.add(new DataHolder(2));
        //act
        DataHolder dataHolder = genericArray.get(2);
        //assert
        assertEquals(3, genericArray.size());
        assertEquals(new DataHolder(2), dataHolder);
    }
    
    @Test
    void removeAt() {
    }
    
    @Test
    void remove() {
    }
    
    @Test
    void clear() {
    }
    
    static class DataHolder {
        public int value;
        
        DataHolder(int value) {
            this.value = value;
        }
        
        @Override
        public String toString() {
            return "DataHolder(" + value + ')';
        }
        
        @Override
        public boolean equals(Object obj) {
            // If the object is compared with itself then return true
            if (obj == this) {
                return true;
            }
            // Check if o is an instance of Complex or not
            // "null instanceof [type]" also returns false
            if (!(obj instanceof DataHolder other)) {
                return false;
            }
            
            return this.value == other.value;
        }
    }
    
}