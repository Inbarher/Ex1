//package assignments.ex1;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * This JUnit class represents a very partial test class for Ex1.
 * Make sure you complete all the needed JUnits
 */
public class Ex1Test {
        @Test
        void computeNumberTest() {
            String s2 = "1011b2";
            int v = Ex1.number2Int(s2);
            assertEquals(v,11);

            String s10 = "1011bA";
            v = Ex1.number2Int(s10);
            s2 = Ex1.int2Number(v,2);
            int v2 = Ex1.number2Int(s2);
            assertEquals(v,v2);
            assertTrue(Ex1.equals(s10,s2));
        }

        @Test
        void isBasisNumberTest() {
            String[] good = {"1", "1b2", "01b2", "123bA","ABbG", "FbG", "0bA","0", "1bF"};
            for(int i=0;i<good.length;i=i+1) {
                boolean ok = Ex1.isNumber(good[i]);
                assertTrue(ok);
            }
            String[] not_good = {"b2", "2b2", "1G3bG", " BbG", "0bbA", "abB", "!@b2", "A", "1bb2", "b", "10b", "0b","GbG","fbG"}; //1bf
            for(int i=0;i<not_good.length;i=i+1) {
                boolean not_ok = Ex1.isNumber(not_good[i]);
                assertFalse(not_ok);
            }
        }
        @Test
        void int2NumberTest() {
           Assert.assertEquals("6FbG", Ex1.int2Number(111,16));
           Assert.assertEquals("6EbF", Ex1.int2Number(104,15));
           Assert.assertEquals("6DbE", Ex1.int2Number(97,14));
           Assert.assertEquals("6CbD", Ex1.int2Number(90,13));
           Assert.assertEquals("6DbE", Ex1.int2Number(83,12));
        }
        @Test
        void number2IntTest() {
            Assert.assertEquals(111, Ex1.number2Int("6FbG"));
            Assert.assertEquals(104, Ex1.number2Int("6EbF"));
            Assert.assertEquals(97, Ex1.number2Int("6DbE"));
            Assert.assertEquals(90, Ex1.number2Int("6CbD"));
            Assert.assertEquals(83, Ex1.number2Int("6BbC"));
            Assert.assertEquals(76, Ex1.number2Int("6AbB"));
            Assert.assertEquals(69, Ex1.number2Int("69bA"));
            Assert.assertEquals(62, Ex1.number2Int("68b9"));
            Assert.assertEquals(55, Ex1.number2Int("67b8"));
            Assert.assertEquals(48, Ex1.number2Int("66b7"));
            Assert.assertEquals(35, Ex1.number2Int("55b6"));
            Assert.assertEquals(24, Ex1.number2Int("44b5"));
            Assert.assertEquals(15, Ex1.number2Int("33b4"));
            Assert.assertEquals(8, Ex1.number2Int("22b3"));
            Assert.assertEquals(3, Ex1.number2Int("11b2"));
            Assert.assertEquals(-1, Ex1.number2Int("6b0"));
            Assert.assertEquals(-1, Ex1.number2Int("6b1"));
            Assert.assertEquals(-1, Ex1.number2Int("0b1"));
            Assert.assertEquals(-1, Ex1.number2Int("gbG"));
            Assert.assertEquals(-1, Ex1.number2Int("7b7"));
            Assert.assertEquals(-1, Ex1.number2Int("2/3%bA"));
            Assert.assertEquals(-1, Ex1.number2Int("1BF"));
            Assert.assertEquals(-1, Ex1.number2Int("1B"));
            Assert.assertEquals(-1, Ex1.number2Int("b"));
            Assert.assertEquals(-1, Ex1.number2Int("Bb G"));
            Assert.assertEquals(123, Ex1.number2Int("123bA"));
            Assert.assertEquals(123, Ex1.number2Int("123"));

        }
        @Test
        void maxIndexTest() {
            Assert.assertEquals("123bA", Ex1.maxIndex(new String[]{"1", "2","6b0","123bA"}));
            Assert.assertEquals("6DbE", Ex1.maxIndex(new String[]{"6BbC","67b8","6DbE"}));
            Assert.assertEquals("1505", Ex1.maxIndex(new String[]{"2/3%bA","1B","6FbG","1505"}));


        }

        // Add additional test functions - test as much as you can.
    }
