import java.util.Arrays;

/**
* Defines a class with static methods 
* designed to provide useful functionality on arrays
*
* @author   Will May (wdm0032@auburn.edu)
* @author   Dean Hendrix (dh@auburn.edu)
* @version  9/5/2020
*
*/
public final class Selector {

   /**
    * No instantiation for this class.
    *
    */
   private Selector() { }


   /**
    * Selects the minimum value from the array a.
    *
    */
   public static int min(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int min = a[0]; 
      for (int i = 0; i < a.length; i++) {
         if (a[i] < min) { 
            min = a[i];
         }
      }
      return min;
   }


   /**
    * Selects the maximum value from the array a. 
    *
    */
   public static int max(int[] a) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int max = a[0]; 
      for (int i = 0; i < a.length; i++) {
         if (a[i] > max) {
            max = a[i]; 
         }
      }
      return max;
   }


   /**
    * Selects the kth minimum value from the array a. 
    *
    */
   public static int kmin(int[] a, int k) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      int sameValues = 0; 
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] == a[i+1]) {
            sameValues++;
         }
      }
      if (k > a.length - sameValues) {
         throw new IllegalArgumentException();
      }
      
      int[] b = Arrays.copyOf(a, a.length); 
      
      Arrays.sort(b); 
    
      for (int i = 0; i < k - 1; i++) {
         if (b[i] == b[i+1]) { 
            k++;
         }
      }
      
      int kmin = b[k - 1];
      return kmin;
   }


   /**
    * Selects the kth maximum value from the array a. 
    *
    */
   public static int kmax(int[] a, int k) {
   
      if (a == null) {
         throw new IllegalArgumentException();
      }
      
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      
      if (k < 1 || k > a.length) {
         throw new IllegalArgumentException();
      }
      
      int sameValues = 0;
      for (int i = 0; i < a.length - 1; i++) {
         if (a[i] == a[i+1]) {
            sameValues++;
         }
      }
      
      if (k > a.length - sameValues) {
         throw new IllegalArgumentException();
      }
      
      int[] b = Arrays.copyOf(a, a.length); 
      
      for (int i = 0; i < b.length; i++) {
         b[i] = b[i] * -1;
      }
      Arrays.sort(b); 
      for (int i = 0; i < b.length; i++) {
         b[i] = b[i] * -1;
      }
      
      for (int i = 0; i < k - 1; i++) {
         if (b[i] == b[i+1]) { 
            k++;
         }
      }
      
      int kmax = b[k - 1];
      return kmax;
   }


   /**
    * Returns an array containing all the values in a in the
    * range.
    *
    */
   public static int[] range(int[] a, int low, int high) {
      if (a == null) {
         throw new IllegalArgumentException();
      }
      if (a.length == 0) {
         throw new IllegalArgumentException();
      }
      int[] rangeArray = new int[0]; 
      int j = 0; 
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= high && a[i] >= low) { 
            rangeArray = Arrays.copyOf(rangeArray, rangeArray.length + 1);
            rangeArray[j] = a[i];
            j++;
         }
      }
      return rangeArray;
   }


   /**
    * Returns the smallest value in a that is greater than or equal to
    * the given key. 
    *
    */
   public static int ceiling(int[] a, int key) {
      if (a == null) { 
         throw new IllegalArgumentException();
      }
      if (a.length == 0) { 
         throw new IllegalArgumentException();
      }
      boolean notFound = true;
      int ceiling = Selector.max(a); 
      for (int i = 0; i < a.length; i++) {
         if (a[i] >= key && a[i] <= ceiling) {
            ceiling = a[i];
            notFound = false; 
         }
      }
      if (notFound) { 
         throw new IllegalArgumentException();
      }
      
      return ceiling;
   }


   /**
    * Returns the largest value in a that is less than or equal to
    * the given key. 
    *
    */
   public static int floor(int[] a, int key) {
      if (a == null) { 
         throw new IllegalArgumentException();
      }
      if (a.length == 0) { 
         throw new IllegalArgumentException();
      }
      boolean notFound = true;
      int floor = Selector.min(a); 
      for (int i = 0; i < a.length; i++) {
         if (a[i] <= key && a[i] >= floor) {
            floor = a[i];
            notFound = false; 
         }
      }
      if (notFound) { 
         throw new IllegalArgumentException();
      }
      
      return floor;
   }

}