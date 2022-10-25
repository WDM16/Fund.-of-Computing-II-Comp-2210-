import org.junit.Assert;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;


public class MinOfThreeTest {


   /** Fixture initialization (common initialization
    *  for all tests). **/
   @Before public void setUp() {
   }


   
   /** Test case for the min1 method. */
   @Test
   public void testMin1() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test case for the min1 method. */
   @Test
   public void testMin1Take2() {
      int a = 2;
      int b = 2;
      int c = 3;
      int expected = 2;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test case for the min1 method. */
   @Test
   public void testMin1Take3() {
      int a = 3;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min1(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test case for the min2 method. */
   @Test
   public void testMin2() {
      int a = 1;
      int b = 2;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test case for the min2 method. */
   @Test
   public void testMin2Take2() {
      int a = 2;
      int b = 1;
      int c = 3;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }
   
   /** Test case for the min2 method. */
   @Test
   public void testMin2Take3() {
      int a = 3;
      int b = 2;
      int c = 1;
      int expected = 1;
      int actual = MinOfThree.min2(a, b, c);
      assertEquals(expected, actual);
   }






}
