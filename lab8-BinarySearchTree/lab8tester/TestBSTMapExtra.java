package lab8tester;
import java.util.Set;
import java.util.Map;
import java.util.HashSet;
import static org.junit.Assert.*;
import org.junit.Test;
import BinarySearchTree.BSTMap;

/** Tests of optional parts of lab 8. */
public class TestBSTMapExtra {

    /* 
    * Sanity test for keySet, only here because it's optional
    */
    @Test
    public void sanityKeySetTest() {
    	BSTMap<String, Integer> b = new BSTMap<String, Integer>();
        HashSet<String> values = new HashSet<String>();
        for (int i = 0; i < 455; i++) {
            b.put("hi" + i, 1);   
            values.add("hi" + i);
        }
        assertEquals(455, b.size()); //keys are there
        Set<String> keySet = b.keySet();
        assertTrue(values.containsAll(keySet));
        assertTrue(keySet.containsAll(values));
    }

    /* Remove Test 
     * 
     * Note for testRemoveRoot:
     * 
     * Just checking that c is gone (perhaps incorrectly) 
     * assumes that remove is BST-structure preserving.
     * 
     * More exhaustive tests could be done to verify 
     * implementation of remove, but that would require doing
     * things like checking for inorder vs. preorder swaps,
     * and is unnecessary in this simple BST implementation.
     */
    @Test
    public void testRemoveRoot() {
        BSTMap<String,String> q = new BSTMap<String,String>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a"); // a b c d e
        assertTrue(null != q.remove("c"));
        assertFalse(q.containsKey("c"));
        assertTrue(q.containsKey("a"));     
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        assertTrue(q.containsKey("e"));
    }
    
    /* Remove Test 2 
     * test the 3 different cases of remove
     */
    @Test
    public void testRemoveThreeCases() {
        BSTMap<String,String> q = new BSTMap<String,String>();
        q.put("c","a");
        q.put("b","a");
        q.put("a","a");
        q.put("d","a");
        q.put("e","a");                         // a b c d e                            
        assertTrue(null != q.remove("e"));      // a b c d
        assertTrue(q.containsKey("a"));     
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("c"));
        assertTrue(q.containsKey("d"));
        assertTrue(null != q.remove("c"));      // a b d
        assertTrue(q.containsKey("a"));     
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("d"));
        q.put("f","a");                         // a b d f
        assertTrue(null != q.remove("d"));      // a b f
        assertTrue(q.containsKey("a"));     
        assertTrue(q.containsKey("b"));
        assertTrue(q.containsKey("f"));
    }

    public static void main(String[] args) {
        jh61b.junit.TestRunner.runTests(TestBSTMapExtra.class);
    }
}