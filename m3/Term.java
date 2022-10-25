import java.util.Comparator;
/**
 * Used to represent a query/weight pair.
 *
 * @author  Will May (wdm0032@auburn.edu)
 *
 */
public class Term implements Comparable<Term> {

   private String query;
   private long weight;

    /**
     * Initialize a term with the given query and weight.
     * This method throws a NullPointerException if query is null,
     * and an IllegalArgumentException if weight is negative.
     */
   public Term(String query, long weight) { 
      if (query == null) {
         throw new NullPointerException("null");
      }
      if (weight < 0) {
         throw new IllegalArgumentException("negative");
      }
      String queryIn = query;
      long weightIn = weight;
   
   }
   


    /**
     * Compares the two terms in descending order of weight.
     */
   public static Comparator<Term> byDescendingWeightOrder() { 
      return 
         new Comparator<Term>() {
            @Override
            public int compare(final Term t1, final Term t2) {
               return Long.valueOf(t2.weight).compareTo(Long.valueOf(t1.weight));
            }
         };
   
   }

    /**
     * Compares the two terms in ascending lexicographic order of query,
     * but using only the first length characters of query. This method
     * throws an IllegalArgumentException if length is less than or equal
     * to zero.
     */
   public static Comparator<Term> byPrefixOrder(int length) { 
      if(length <= 0)
         throw new IllegalArgumentException();
      return 
         new Comparator<Term>() {
            public int compare(Term t1, Term t2) {
               String subQuery1 = t1.query; 
               if(t1.query.length() > length)
                  subQuery1 = t1.query.subSequence(0, length).toString();
            	
               String subQuery2 = t2.query; 
               if(t2.query.length() > length)
                  subQuery2 = t2.query.subSequence(0, length).toString();
            	
               return subQuery1.compareTo(subQuery2);
            }
         };
   
   
   
   }

    /**
     * Compares this term with the other term in ascending lexicographic order
     * of query.
     */
   @Override
    public int compareTo(Term other) { 
      return this.query.compareTo(other.query);
   }

    /**
     * Returns a string representation of this term in the following format:
     * query followed by a tab followed by weight
     */
   @Override
    public String toString(){ 
      return String.format(this.query, "\t", this.weight);
   }

}