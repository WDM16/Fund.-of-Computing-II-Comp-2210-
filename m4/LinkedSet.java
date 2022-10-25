import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * Provides an implementation of the Set interface.
 * A doubly-linked list is used as the underlying data structure.
 * Although not required by the interface, this linked list is
 * maintained in ascending natural order. In those methods that
 * take a LinkedSet as a parameter, this order is used to increase
 * efficiency.
 *
 * @author Dean Hendrix (dh@auburn.edu)
 * @author Will May (you@auburn.edu)
 *
 */
public class LinkedSet<T extends Comparable<T>> implements Set<T> {

    //////////////////////////////////////////////////////////
    // Do not change the following three fields in any way. //
    //////////////////////////////////////////////////////////

    /** References to the first and last node of the list. */
   Node front;
   Node rear;

    /** The number of nodes in the list. */
   int size;

    /////////////////////////////////////////////////////////
    // Do not change the following constructor in any way. //
    /////////////////////////////////////////////////////////

    /**
     * Instantiates an empty LinkedSet.
     */
   public LinkedSet() {
      front = null;
      rear = null;
      size = 0;
   }


    //////////////////////////////////////////////////
    // Public interface and class-specific methods. //
    //////////////////////////////////////////////////

    ///////////////////////////////////////
    // DO NOT CHANGE THE TOSTRING METHOD //
    ///////////////////////////////////////
    /**
     * Return a string representation of this LinkedSet.
     *
     * @return a string representation of this LinkedSet
     */
   @Override
    public String toString() {
      if (isEmpty()) {
         return "[]";
      }
      StringBuilder result = new StringBuilder();
      result.append("[");
      for (T element : this) {
         result.append(element + ", ");
      }
      result.delete(result.length() - 2, result.length());
      result.append("]");
      return result.toString();
   }


    ///////////////////////////////////
    // DO NOT CHANGE THE SIZE METHOD //
    ///////////////////////////////////
    /**
     * Returns the current size of this collection.
     *
     * @return  the number of elements in this collection.
     */
   public int size() {
      return size;
   }

    //////////////////////////////////////
    // DO NOT CHANGE THE ISEMPTY METHOD //
    //////////////////////////////////////
    /**
     * Tests to see if this collection is empty.
     *
     * @return  true if this collection contains no elements, false otherwise.
     */
   public boolean isEmpty() {
      return (size == 0);
   }


    /**
     * Ensures the collection contains the specified element. Neither duplicate
     * nor null values are allowed. This method ensures that the elements in the
     * linked list are maintained in ascending natural order.
     *
     * @param  element  The element whose presence is to be ensured.
     * @return true if collection is changed, false otherwise.
     */
   public boolean add(T element) {
      Node n = new Node(element);
      if (element == null || contains(element)) {
         return false; 
      }
      else if (size == 0) {
         front = n;
         rear = n;
         size++;
         return true;
      }
      else {
         Node o = front;
         for (int i = 0; i < size; i++) {
            if (n.element.compareTo(o.element) < 0) {
               n.next = o;
               n.prev = o.prev;
               if (front == o) {
                  front = n;
               }
               else {
                  o.prev.next = n;
               }
               o.prev = n;
               size++;
               return true;
            }
            if (size - i > 1) {
               o = o.next;
            }
         } 
         o.next = n;
         n.prev = o;
         rear = n;
         size++;
         return true;
      }
   }

    /**
     * Ensures the collection does not contain the specified element.
     * If the specified element is present, this method removes it
     * from the collection. This method, consistent with add, ensures
     * that the elements in the linked lists are maintained in ascending
     * natural order.
     *
     * @param   element  The element to be removed.
     * @return  true if collection is changed, false otherwise.
     */
   public boolean remove(T element) {
      if (element != null) {
         Node n = front;
         for (int i = 0; i < size; i++) {
            if (n.element.compareTo(element) == 0) {
               if (n == front && n != rear) {
                  n.next.prev = null;
                  front = n.next;
               }
               else if (n != front && n == rear) {
                  n.prev.next = null;
                  rear = n.prev;
               }
               else if (n != front) {
                  n.prev.next = n.next;
                  n.next.prev = n.prev;
               }
               else {   
                  front = null;
                  rear = null;
               }
               size--;
               return true;
            }
            if (size - i > 1) {
               n = n.next;
            }
         }
         return false;
      }
      return false;
   }


    /**
     * Searches for specified element in this collection.
     *
     * @param   element  The element whose presence in this collection is to be tested.
     * @return  true if this collection contains the specified element, false otherwise.
     */
   public boolean contains(T element) {
      return locate(element) != null;
   }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
   public boolean equals(Set<T> s) {
      if (s == null || size() != s.size()) {
         return false;
      }
      int num = 0;
      Iterator<T> itr = s.iterator();
      while (itr.hasNext()) {
         T element = itr.next();
         if (contains(element)) {
            num++;
         }
      }
      if (num == size()) {
         return true;
      }
      return false;
   }


    /**
     * Tests for equality between this set and the parameter set.
     * Returns true if this set contains exactly the same elements
     * as the parameter set, regardless of order.
     *
     * @return  true if this set contains exactly the same elements as
     *               the parameter set, false otherwise
     */
   public boolean equals(LinkedSet<T> s) {
      if (s == null || size() != s.size()) {
         return false;
      }
      Node no1 = front;
      Node no2 = s.front;
      for (int i = 0; i < size; i++) {
         if (no1.element.compareTo(no2.element) != 0) {
            return false;
         }
         no1 = no1.next;
         no2 = no2.next;
      }
      return true;
   
   }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
   public Set<T> union(Set<T> s){
      LinkedSet<T> union = new LinkedSet<T>();
      Iterator<T> itr1 = iterator();
      Iterator<T> itr2 = s.iterator();
      while (itr1.hasNext()) {
         T element = itr1.next();
         union.add(element);
      }
      while (itr2.hasNext()) {
         T element = itr2.next();
         union.add(element);
      }
      return union;
   
   }


    /**
     * Returns a set that is the union of this set and the parameter set.
     *
     * @return  a set that contains all the elements of this set and the parameter set
     */
   public Set<T> union(LinkedSet<T> s){
      if (s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> set = new LinkedSet<T>();
      Node n = front;
      while (n != null) {
         set.add(n.element);
         n = n.next;
      }
      Iterator<T> itr = s.iterator();    
      while (itr.hasNext()) {
         set.add(itr.next());
      }
      return set;
   
   }


    /**
     * Returns a set that is the intersection of this set and the parameter set.
     *
     * @return  a set that contains elements that are in both this set and the parameter set
     */
   public Set<T> intersection(Set<T> s) {
      Set<T> set = new LinkedSet<T>(); 
      Iterator<T> itr = s.iterator();
      while (itr.hasNext()) {
         T element = itr.next();
         if (contains(element)) {
            set.add(element);
         }
      }
      return set;
   
   }

    /**
     * Returns a set that is the intersection of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in both
     *            this set and the parameter set
     */
   public Set<T> intersection(LinkedSet<T> s) {
      LinkedSet<T> set = new LinkedSet<T>(); 
      Iterator<T> itr = s.iterator();
      while (itr.hasNext()) {
         T element = itr.next();
         if (contains(element)) {
            set.add(element);
         }
      }
      return set;
   }


    /**
     * Returns a set that is the complement of this set and the parameter set.
     *
     * @return  a set that contains elements that are in this set but not the parameter set
     */
   public Set<T> complement(Set<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      Set<T> set = new LinkedSet<T>();    
      Node n = front;    
      while (n != null) {   
         if (!s.contains((T)n.element)) {
            set.add((T)n.element);
         }
         n = n.next;         
      }
      return set;
   }


    /**
     * Returns a set that is the complement of this set and
     * the parameter set.
     *
     * @return  a set that contains elements that are in this
     *            set but not the parameter set
     */
   public Set<T> complement(LinkedSet<T> s) {
      if (s == null) {
         throw new NullPointerException();
      }
      LinkedSet<T> set = new LinkedSet<T>();    
      Node n = front;    
      while (n != null) {   
         if (!s.contains((T)n.element)) {
            set.add((T)n.element);
         }
         n = n.next;         
      }
      return set;
   }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in ascending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
   public Iterator<T> iterator() {
      return new LinkedIterator();
   
   }


    /**
     * Returns an iterator over the elements in this LinkedSet.
     * Elements are returned in descending natural order.
     *
     * @return  an iterator over the elements in this LinkedSet
     */
   public Iterator<T> descendingIterator() {
      return new DescendingIterator();
   
   }


    /**
     * Returns an iterator over the members of the power set
     * of this LinkedSet. No specific order can be assumed.
     *
     * @return  an iterator over members of the power set
     */
   public Iterator<Set<T>> powerSetIterator() {
      return new PowerIterator();
   
   }



    //////////////////////////////
    // Private utility methods. //
    //////////////////////////////

    // Feel free to add as many private methods as you need.
   private Node locate(T element) {
      Node n = front;
      while (n != null) {
         if (n.element.equals(element)) {
            return n;
         }
         n = n.next;
      }
      return null;
   }
   
   /**
    * LinkedIterator.
    */
    
   private class LinkedIterator implements Iterator<T> {
      private Node n;
      
      public LinkedIterator() {
         n = front;
      }
      
      public boolean hasNext() {
         return n != null;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T result = n.element;
         n = n.next;
         return result;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   /**
    * DescendingIterator.
    */
    
   private class DescendingIterator implements Iterator<T> {
      private Node n;
      
      public DescendingIterator() {
         n = rear;
      }
     
      public boolean hasNext() {
         return n != null;
      }
      
      public T next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         T result = n.element;
         n = n.prev;
         return result;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }
   
   /**
    * PowerSetIterator.
    */
    
   private class PowerIterator implements Iterator<Set<T>> {
      private Node n;
      private int m;
      
      public PowerIterator() {
         m = 0;
         n = front;
      }
      
      public boolean hasNext() {
         return m < (int) Math.pow(2, size);
      }
      
      public Set<T> next() {
         if (!hasNext()) {
            throw new NoSuchElementException();
         }
         if (front == null) {
            Set<T> sete = new LinkedSet<>();
            m++;
            return sete;
         }
         n = front;
         StringBuilder binary = new StringBuilder();
         binary.append(Integer.toBinaryString(m).toCharArray());
         
         Set<T> set = new LinkedSet<>();
         for (; binary.length() < size;) {
            binary.insert(0, 0);
         }
         for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
               set.add(n.element);
            }
            n = n.next;
         }
         m++;
         return set;
      }
      
      public void remove() {
         throw new UnsupportedOperationException();
      }
   }

    ////////////////////
    // Nested classes //
    ////////////////////

    //////////////////////////////////////////////
    // DO NOT CHANGE THE NODE CLASS IN ANY WAY. //
    //////////////////////////////////////////////

    /**
     * Defines a node class for a doubly-linked list.
     */
   class Node {
        /** the value stored in this node. */
      T element;
        /** a reference to the node after this node. */
      Node next;
        /** a reference to the node before this node. */
      Node prev;
   
        /**
         * Instantiate an empty node.
         */
      public Node() {
         element = null;
         next = null;
         prev = null;
      }
   
        /**
         * Instantiate a node that containts element
         * and with no node before or after it.
         */
      public Node(T e) {
         element = e;
         next = null;
         prev = null;
      }
   }

}

