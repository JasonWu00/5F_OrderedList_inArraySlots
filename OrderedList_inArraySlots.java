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
        //return indexOf_recursive(findMe, 0, size());
        return indexRecursion(0, size(), findMe);
    }

    public int indexRecursion(int low, int high, Integer findMe) {
      int output = -1;

      if (low > high) {
        //if the findMe is not in the ArrayList
        System.out.println("It's not in this list.");
        output = -1;
      }

      else {
        int pageToCheck = (low + high) /2;
        //had the divide by 2 inside the parentheses and that broke everything
        int comparison = findMe.compareTo(list_iAS.get(pageToCheck));


        if (comparison == 0) {//when you find it
          System.out.println("We got it");
          System.out.println(pageToCheck);
          return pageToCheck;
        }

        /*else if (comparison < 0) {
          //recursive case number zero
          return indexRecursion(low, pageToCheck-1, findMe);
          //recursive call
        }

        else {
          return indexRecursion(pageToCheck+1, high, findMe);
        }*/
        if( comparison == 0)    // detect base case
            return pageToCheck; // solution other base case
        // recursive cases
        else
            if( comparison < 0)
                // findMe's spot precedes pageToCheck
                return indexRecursion( low
                                     , pageToCheck-1
                                     , findMe);
            else
                // findMe's spot follows pageToCheck
                return indexRecursion( pageToCheck+1
                                      , high
                                      , findMe);
      }

      return output;
    }


    public int indexWhileStyle( Integer findMe) {
      int low = 0;
      int high = size() ;
      int output = -1;
      boolean IntegerFound = false;

      while (low <= high && IntegerFound == false) {
        int pageToCheck = (low + high) / 2;
        int comparison = findMe.compareTo(get(pageToCheck));

        if (high - low == 1 && comparison != 0) {
          //when the method narrows down to 1 page and findMe
          //is not on said page
          System.out.println("It's not in this list.");
          //IntegerFound = true;
          output = -1;
          IntegerFound = true;
        }
        else if (comparison == 0) {
          //when the method finds findMe
          output = pageToCheck;
          IntegerFound = true;
          System.out.println("We got it");
          System.out.println(pageToCheck);
        }

        else if (comparison < 0) {
          //check the front half of the ArrayList
          high = pageToCheck -1;
          System.out.println("Checking the front half");
        }

        else {
          //check the back half
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
