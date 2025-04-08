package org.howard.edu.lsp.assignment6;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;


public class IntegerSetTest {
    @Test
    @DisplayName("Test case for equals")
    public void testEquals() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        IntegerSet set2 = new IntegerSet();
        set2.add(1);
        set2.add(2);
        assertFalse(set1.equals(set2));


        set2.add(3);
        assertTrue(set1.equals(set2));
    }


    @Test
    @DisplayName("Test case for isEmpty")
    public void testIsEmpty() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty());


        set.add(1);
        assertFalse(set.isEmpty());
    }


    @Test
    @DisplayName("Test case for clear")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        assertFalse(set.isEmpty());


        set.clear();
        assertTrue(set.isEmpty());
    }


    @Test
    @DisplayName("Test case for contains")
    public void testContains() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);


        assertTrue(set.contains(1));
        assertFalse(set.contains(3));
    }


    @Test
    @DisplayName("Test case for add")
    public void testAdd() {
        IntegerSet set = new IntegerSet();
        set.add(1);


        assertTrue(set.contains(1));
        assertEquals(1, set.length());


        set.add(2);
        assertTrue(set.contains(2));
        assertEquals(2, set.length());
    }


    @Test
    @DisplayName("Test case for add duplicate")
    public void testAddDuplicate() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1); // Adding duplicate


        assertTrue(set.contains(1));
        assertEquals(1, set.length()); // Length should remain 1
    }


    @Test
    @DisplayName("Test case for remove")
    public void testRemove() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);


        assertTrue(set.contains(1));
        assertEquals(2, set.length());


        set.remove(1);
        assertFalse(set.contains(1));
        assertEquals(1, set.length());
    }


    @Test
    @DisplayName("Test case for remove non-existing element")
    public void testRemoveNonExisting() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);


        assertFalse(set.contains(3)); // 3 is not in the set
        set.remove(3); // Removing non-existing element
        assertEquals(2, set.length()); // Length should remain the same
    }


    @Test
    @DisplayName("Test case for union")
    public void testUnion() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);


        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(3, set1.length());
    }


    @Test
    @DisplayName("Test case for union with null set")
    public void testUnionWithNullSet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = null;


        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for union with empty set")
    public void testUnionWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = new IntegerSet();


        set1.union(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for intersect")
    public void testIntersect() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);


        set1.intersect(set2);
        assertTrue(set1.contains(2));
        assertTrue(set1.contains(3));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for intersect with null set")
    public void testIntersectWithNullSet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = null;


        set1.intersect(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for intersect with empty set")
    public void testIntersectWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = new IntegerSet();


        set1.intersect(set2);
        assertTrue(set1.isEmpty());
        assertEquals(0, set1.length());
    }


    @Test
    @DisplayName("Test case for diff")
    public void testDiff() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);


        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(3));
        assertEquals(1, set1.length());
    }


    @Test
    @DisplayName("Test case for diff with null set")
    public void testDiffWithNullSet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = null;


        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for diff with empty set")
    public void testDiffWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = new IntegerSet();


        set1.diff(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for complement")
    public void testComplement() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set1.add(3);


        IntegerSet set2 = new IntegerSet();
        set2.add(2);
        set2.add(3);
        set2.add(4);


        set1.complement(set2);
        assertTrue(set1.contains(4));
        assertFalse(set1.contains(2));
        assertFalse(set1.contains(3));
        assertEquals(1, set1.length());
    }


    @Test
    @DisplayName("Test case for complement with null set")
    public void testComplementWithNullSet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = null;


        set1.complement(set2);
        assertTrue(set1.contains(1));
        assertTrue(set1.contains(2));
        assertEquals(2, set1.length());
    }


    @Test
    @DisplayName("Test case for complement with empty set")
    public void testComplementWithEmptySet() {
        IntegerSet set1 = new IntegerSet();
        set1.add(1);
        set1.add(2);


        IntegerSet set2 = new IntegerSet();


        set1.complement(set2);
        assertFalse(set1.contains(1));
        assertFalse(set1.contains(2));
        assertTrue(set1.isEmpty());
    }


    @Test
    @DisplayName("Test case for smallest")
    public void testSmallest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);


        assertEquals(1, set.smallest());
    }


    @Test
    @DisplayName("Test case for smallest with empty set")
    public void testSmallestEmptySet() {
        IntegerSet set = new IntegerSet();
        try {
            set.smallest();
            fail("Expected IntegerSetException");
        } catch (IntegerSetException e) {
            assertEquals("IntegerSet is empty", e.getMessage());
        }
    }


    @Test
    @DisplayName("Test case for largest")
    public void testLargest() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);


        assertEquals(3, set.largest());
    }


    @Test
    @DisplayName("Test case for largest with empty set")
    public void testLargestEmptySet() {
        IntegerSet set = new IntegerSet();
        try {
            set.largest();
            fail("Expected IntegerSetException");
        } catch (IntegerSetException e) {
            assertEquals("IntegerSet is empty", e.getMessage());
        }
    }


    @Test
    @DisplayName("Test case for length")
    public void testLength() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);


        assertEquals(3, set.length());
    }


    @Test
    @DisplayName("Test case for toString")
    public void testToString() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);


        assertEquals("[1, 2, 3]", set.toString());
    }


}
