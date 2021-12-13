package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    ImmutableLinkedList list1;
    ImmutableLinkedList list2;
    ImmutableLinkedList list3;
    ImmutableLinkedList list4;
    Object number1;
    Object number2;
    Object[] numbers = new Object[]{1};

    @Before
    public void setUp() {
        list1 = new ImmutableLinkedList();
        list2 = new ImmutableLinkedList(new Object[]{1, 2, 3});
        list3 = (ImmutableLinkedList) list2.clear();
        list3 = list2.addFirst(1);
        list4 = new ImmutableLinkedList();

        list1 = (ImmutableLinkedList) list1.add(1);
        list1 = (ImmutableLinkedList) list1.add(1, 2);
        list1 = (ImmutableLinkedList) list1.remove(0);

        list2 = (ImmutableLinkedList) list2.addAll(new Object[]{4,6});
        list2 = (ImmutableLinkedList) list2.addAll(0, new Object[]{0});
        list2 = (ImmutableLinkedList) list2.set(list2.size()-1,5);
        number1 = list2.getHead();
        number2 = list2.getTail();

    }

    @Test
    public void everything() {
        assertEquals(2, list2.indexOf(1));
        assertEquals(1, list1.size());
        assertFalse(list3.isEmpty());
        assertTrue(list4.isEmpty());
        assertEquals(-1, list2.indexOf(25));
        assertEquals(3, list2.get(3));
        assertNotSame(number1, number2);
        assertEquals(numbers[0], list3.toArray()[0]);
    }
}
