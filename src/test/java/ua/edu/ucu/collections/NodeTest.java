package ua.edu.ucu.collections;

import org.junit.Before;
import org.junit.Test;
import ua.edu.ucu.collections.immutable.Node;

import static org.junit.Assert.assertEquals;

public class NodeTest {
    Node node;
    @Before
    public void setUp() {
        node = new Node(1);
        node.setValue(2);
        Node previous = new Node(3);
        node.setPrevious(previous);

    }

    @Test
    public void everything() {
        assertEquals(2, node.getValue());
        assertEquals(3, node.getPrevious().getValue());
        assertEquals("2", node.toString());
    }
}
