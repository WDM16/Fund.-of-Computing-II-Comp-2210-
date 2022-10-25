import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Lab test 1.
 */
public class LabTest1 {
    
    //-----------------------------------------------------------
    //   P R O B L E M   O N E


    /**
     * Returns the number of odd integers in the given array.
     */
   public static int countOdds(int[] a) {
      int count = 0;
      for (int i = 0; i < a.length; i++) {
         if (a[i] % 2 == 1) {
            count++;
         }
      }
      return count;
   }



    //-----------------------------------------------------------
    //   P R O B L E M   T W O


    /**
     * Returns a collection that contains all the values in Collection parameter `set` 
     * that are strictly greater than the parameter `toElement` with respect to the total order 
     * defined by the Comparator parameter `order`. 
     *
     * Example:
     * 
     * set = [2, 4, 6, 8, 10] 
     * toElement = 5
     * order = (a Comparator that defines ascending numeric order)
     * return value = [6, 8, 10]
     * 
     */
   public static <T> Collection<T> tailSet(Collection<T> set, 
                                            T toElement,
                                            Comparator<T> order) {
      Collection<T> result = new ArrayList<T>();
      for (T elem : set) {
         if (order.compare(elem, toElement) > 0) {
            result.add(elem);
         }
      }
   
      return result;
   }


}

