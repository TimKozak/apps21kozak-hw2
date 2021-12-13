package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.ImmutableArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ImmutableArrayListTest {
    ImmutableArrayList array1;
    ImmutableArrayList array2;
    ImmutableArrayList array3;

    @Before
    public void setUp() {
        array1 = new ImmutableArrayList();
        array2 = new ImmutableArrayList(new Object[]{1, 2, 3});
        array3 = (ImmutableArrayList) array2.clear();

        array1 = (ImmutableArrayList) array1.add(1);
        array1 = (ImmutableArrayList) array1.add(1, 2);
        array1 = (ImmutableArrayList) array1.remove(0);

        array2 = (ImmutableArrayList) array2.addAll(new Object[]{4,6});
        array2 = (ImmutableArrayList) array2.addAll(0, new Object[]{0});
        array2 = (ImmutableArrayList) array2.set(array2.size()-1,5);
    }

    @Test
    public void everything() {
        assertEquals(1, array2.indexOf(1));
        assertEquals(2, array1.size());
        assertTrue(array3.isEmpty());
    }
}
