package org.example.data_structures.dynamic_arrays.int_array;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class IntArrayTest {
    
    IntArrayImpl intArray;
//    GenericDynamicArray<Integer> intArray;
    
    @BeforeEach
    public void setUp() {
        intArray = new IntArrayImpl(3);
//        intArray = new GenericDynamicArray<Integer>(3);
    }
    
    @Test
    public void test_throw_illegalArgumentException_when_add_num_less_than_zero() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new IntArrayImpl(-1),
                "Illegal Capacity: -1"
        );
    }
    
    @Test
    public void test_return_correct_size() {
        //arrange
        intArray.add(0);
        intArray.add(1); // size should be 2 here
        //act
        intArray.add(2);
        int size = intArray.size();
        //assert
        assertEquals(size, 3);
    }
    
    @Test
    public void test_Array_Resize_When_Element_Added() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        
        //act
        intArray.add(3);
        int size = intArray.size();
        int capacity = intArray.capacity;
        
        //assert
        assertEquals(size, 4);
        assertEquals(capacity, 6);
    }
    
    @Test
    public void test_indexOf_should_return_element_with_given_index() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        //act
        int element = intArray.indexOf(2);
        //assert
        assertEquals(element, 2);
    }
    
    @Test
    public void test_removeAt_fail_when_index_lowerThan_zero() {
        //arrange
        intArray.add(0);
        //act
        
        //assert
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> intArray.removeAt(-1),
                ""
        );
        
    }
    
    @Test
    public void test_removeAt_fail_when_index_largerThan_size() {
        //arrange
        intArray.add(0);
        //act
        int size = intArray.size();
        //assert
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> intArray.removeAt(size + 1),
                ""
        );
    }
    
    @Test
    public void test_removeAt_fail_when_index_equal_size() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        //act
        int size = intArray.size();
        //assert
        assertThrows(
                IndexOutOfBoundsException.class,
                () -> intArray.removeAt(size),
                ""
        );
    }
    
    @Test
    public void test_removeAt_return_removed_element() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        //act
        int removed = intArray.removeAt(0);
        //assert
        assertEquals(0, removed);
    }
    
    @Test
    public void test_removeAt_elements_shifted_after_remove_success() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        //act
        intArray.removeAt(2);
        int new_shifted_value = intArray.get(2);
        //assert
        assertEquals(new_shifted_value, 3);
    }
    
    @Test
    public void test_remove_element_return_false_when_fail() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3); // should be shifted
        //act
        boolean isRemoved = intArray.remove(5);
        //assert
        assertFalse(isRemoved);
    }
    
    @Test
    public void test_remove_element_shifted_after_remove_and_return_true_when_success() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3); // should be shifted
        //act
        boolean isRemoved = intArray.remove(0);
        int new_shifted_value = intArray.get(0);
        //assert
        assertTrue(isRemoved);
        assertEquals(new_shifted_value, 1);
    }
    
    @Test
    public void test_insert_index_should_insert_at_zero() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        
        int insert_index = 0;
        int inserted_num = 5;
        
        //act
        intArray.insert(insert_index, 5);
        String expected_arr = "[5, 0, 1, 2, 3, 4]";
        
        //assert
        assertEquals(inserted_num, intArray.get(insert_index));
        assertEquals(expected_arr, intArray.toString());
    }
    
    @Test
    public void test_insert_index_should_insert_at_last_index() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        
        int insert_index = intArray.size() - 1;
        int inserted_num = 5;
        
        //act
        intArray.insert(insert_index, 5);
        String expected_arr = "[0, 1, 2, 3, 5, 4]";
        
        //assert
        assertEquals(inserted_num, intArray.get(insert_index));
        assertEquals(expected_arr, intArray.toString());
    }
    
    @Test
    public void test_insert_index_should_insert_and_shift_elements() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        
        int insert_index = 2;
        int inserted_num = 5;
        
        //act
        intArray.insert(insert_index, 5);
        String expected_arr = "[0, 1, 5, 2, 3, 4]";
        
        //assert
        assertEquals(inserted_num, intArray.get(insert_index));
        assertEquals(expected_arr, intArray.toString());
    }
    
    @Test
    public void test_toString() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        
        String result = intArray.toString();
        String expected = "[0, 1, 2, 3]";
        assertEquals(expected, result);
    }
    
    @Test
    public void test_clear() {
        //arrange
        intArray.add(0);
        intArray.add(1);
        intArray.add(2);
        intArray.add(3);
        intArray.add(4);
        intArray.add(5);
        //act
        intArray.clear();
        intArray.add(6);
        intArray.add(7);
        
        assertEquals(7, intArray.get(1));
    }
}
