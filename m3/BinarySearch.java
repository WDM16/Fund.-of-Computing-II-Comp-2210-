import java.util.Arrays;
import java.util.Comparator;
/**
 * Used to represent BinarySearch operation.
 *
 * @author  Will May (wdm0032@auburn.edu)
 *
 */
public class BinarySearch {

   /**
    * Returns the index of the first key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) { 
      if(a == null || key == null || comparator == null) 
         throw new NullPointerException();
   
      int oIndex = Arrays.binarySearch(a, key, comparator);
   
      if(oIndex < 0)
         return -1;
   
      while(oIndex - 1 >= 0 && comparator.compare(key, a[oIndex - 1]) == 0)
         oIndex--;
        
      return oIndex;
   }

   /**
    * Returns the index of the last key in a[] that equals the search key, 
    * or -1 if no such key exists. This method throws a NullPointerException
    * if any parameter is null.
    */
   public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) { 
      if(a == null || key == null || comparator == null)
         throw new NullPointerException();
   
      int oIndex = Arrays.binarySearch(a, key, comparator);
   
      if(oIndex < 0)
         return -1;
   
      while(oIndex + 1 < a.length && comparator.compare(key, a[oIndex + 1]) == 0)
         oIndex++;
        
      return oIndex;
   }
}