import java.util.Arrays;
import java.util.Comparator;
   
/**
 * Used to represent BinarySearch operation.
 *
 * @author  Will May (wdm0032@auburn.edu)
 *
 */
public class Autocomplete {
   private Term[] terms;


	/**
	 * Initializes a data structure from the given array of terms.
	 * This method throws a NullPointerException if terms is null.
	 */
   public Autocomplete(Term[] terms) { 
      this.terms = terms;
   
   }

	/** 
	 * Returns all terms that start with the given prefix, in descending order of weight. 
	 * This method throws a NullPointerException if prefix is null.
	 */
   public Term[] allMatches(String prefix) { 
      if (prefix == null) {
         throw new NullPointerException();
      }
             	
      int start = BinarySearch.firstIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
      int end = BinarySearch.lastIndexOf(terms, new Term(prefix, 0), Term.byPrefixOrder(prefix.length()));
   
      if (start == -1)
         return new Term[0];
        
      Term[] matches = new Term[end - start + 1];
      for(int i = 0; start <= end; i++, start++) { 
         matches[i] = this.terms[start];
      }
   
      return matches;
   
   }

}