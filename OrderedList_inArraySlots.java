/**
  OrderedList_inArraySlots, holding Integers

  A list with the invariant the elements are in order by
  increasing value, implemented using a
  ArrayList<Integer>

  Credit to today's class notes on Piazza.
 */
public class OrderedList_inArraySlots
    implements OrderedList {

    private java.util.ArrayList<Integer> list_iAS;


    /**
      @return the index of the first occurrence of
              \findMe in this list, or -1 if
              \findMe is absent from this list.
     */
    public int indexOf( Integer findMe) {
        return indexRecursion( list_iAS, findMe);
    }

    public int indexRecursion(java.util.ArrayList<Integer> list, Integer findMe) {
      int low = 0;
      int high = list.size() ;
      int output = -1;
      boolean IntegerFound = false;
      int pageToCheck = (low + high / 2);

      if (high - low == 1 && list.get(pageToCheck) != findMe) {
        //if the findMe is not in the ArrayList
        System.out.println("It's not in this list.");
        output = -1;
      }
      else if (list.get(pageToCheck) == findMe) {//when you find it
        System.out.println("We got it");
        System.out.println(pageToCheck);
        output = pageToCheck;
      }
      else if (list.get(pageToCheck) > findMe) {
        //recursive case number zero
        java.util.ArrayList<Integer> frontHalf = list;
        System.out.println("Checking the front half");
        while (frontHalf.size() > high - pageToCheck)
          frontHalf.remove(0);
        //Construct an ArrayList equivalent to the front half
        //of the ArrayList we are given by removing the elements
        //that does not pertain to the part we need.
        output = indexRecursion(frontHalf, findMe);
        //recursive call
      }
      else {
        java.util.ArrayList<Integer> backHalf = list;
        System.out.println("Checking the back half");
        while (backHalf.size() > pageToCheck - low)
          backHalf.remove(pageToCheck);
        output = indexRecursion(backHalf, findMe);
      }
      return -1;
    }

    public int indexWhileStyle( Integer findMe) {
      int low = 0;
      int high = size() ;
      int output = -1;
      boolean IntegerFound = false;

      while (low < high && IntegerFound == false) {
        int pageToCheck = (low + high) / 2;
        /*if (high - low == 1) {
          System.out.println("narrowed down to 1 page.");
          IntegerFound = true;
          output = pageToCheck;
        }*/
        if (high - low == 1) {

        }
        if (get(pageToCheck) == findMe) {
          output = pageToCheck;
          IntegerFound = true;
          System.out.println("We got it");
          System.out.println(pageToCheck);
        }
        else if (get(pageToCheck) > findMe) {
          high = pageToCheck -1;
          System.out.println("Checking the front half");
        }
        else {
          low = pageToCheck +1;
          System.out.println("Checking the back half");
        }
      }
      return output;

    }


    // ------ code from previous assignments below here ----

    public OrderedList_inArraySlots() {
        list_iAS = new java.util.ArrayList<Integer>();
    }

    /**
      @return the number of elements in this list
     */
    public int size(){
        return list_iAS.size();
    }

    /**
      @return a string representation of this Orderedlist_iAS
     */
    public String toString() {
        return list_iAS.toString();
    }


    /**
      Put @value where it belongs in the list.
      @pre: the list is in increasing order
     */
     public boolean add( Integer value) {
         int dest = 0;
         for( ; dest < list_iAS.size() && list_iAS.get( dest) < value
              ; dest++) ;
         // System.out.println( "OL adding " + value
         //                   + " at index " + dest);
         list_iAS.add( dest, value);
         return true;
     }


     /**
      @return element @index from this list
      precondition: @index is within the bounds of the array.
          (Having warned the user about this precondition,
           you should NOT complicate your code to check
           whether the condition was violated.)
     */
    public Integer get( int index ) {
        return list_iAS.get( index);
    }


    /**
      Remove the element at position @index in this list.

      Shift any subsequent elements to the left (that is,
      decrease the index associated with each).

      @return the value that was removed from the list
     */
    public Integer remove( int index) {
        return list_iAS.remove( index);
    }
}
