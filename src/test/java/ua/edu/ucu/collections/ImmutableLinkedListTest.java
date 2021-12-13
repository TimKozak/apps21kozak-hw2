package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableLinkedListTest {
    ImmutableLinkedList list1;
    ImmutableLinkedList list2;
    ImmutableLinkedList list3;

    @Before
    public void setUp() {
        list1 = new ImmutableLinkedList();
        list2 = new ImmutableLinkedList(new Object[]{1, 2, 3});
        list3 = (ImmutableLinkedList) list2.clear();

        list1 = (ImmutableLinkedList) list1.add(1);
        list1 = (ImmutableLinkedList) list1.add(1, 2);
        list1 = (ImmutableLinkedList) list1.remove(0);

        list2 = (ImmutableLinkedList) list2.addAll(new Object[]{4,6});
        list2 = (ImmutableLinkedList) list2.addAll(0, new Object[]{0});
        list2 = (ImmutableLinkedList) list2.set(list2.size()-1,5);
    }

    @Test
    public void everything() {
        assertEquals(1, list2.indexOf(1));
        assertEquals(1, list1.size());
        assertTrue(list3.isEmpty());
    }
}
