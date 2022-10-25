
package assn2;

public interface List {
  // We give you code for these first 8 methods in both 
  // array implementation and linked cell implementation.
  // The semantics (behavior) of each operation is as we studied 
  // in class, but is repeated here for clarity.
	
  // Do not edit this file!  The code you write should go in LinkedList.java and
  // ArrayList.java.
 
  public boolean ins ( int index, double element ) ;
  /* standard list insert... go to the position in the list given by index,
     make room for the new element by moving elements at index and further
     up one location (to a higher index) so the new element goes in the 
     "hole" that is opened
     */
  public boolean rem ( int index ) ;
  /* go to location in the list given by index and move all elements further 
     along down one position... so that the element in location index+1 is moved
     to index, index+2 is moved to index+1, etc.
     the element that was in location index is gone after the op completes
     */
  public double get( int index ) ;
  /* return the element value stored in the list at location given by index
     */
  public boolean contains( double element ) ;
  /* returns true if the given element is stored in some list item
     */
  public int find ( double element ) ;
  /* similar to contains, except that find returns the index of the item where
     element is stored; this locates the first such occurrance
     */
  public int size( ) ;
  /* returns the count of how many items are in the list
     */
  public boolean isEmpty( ) ;
  /* shorthand for is the list size() == 0
     */
  public void clear();
  /* empty all elements from the list... size() becomes 0; this essentially 
     returns the list to the state it has when it is first created
     */
  
  //================================================================
  // New ops to write for both implementations:
  // We give informal semantics (behavior) for each operation
  // here in the abstraction (the interface).
  //
  // In the ArrayList.java array implementation and LinkedList.java linked  
  // node implementation you will write your own implementation code for these 4 methods
  // and test to make sure your code provides the required behavior.
  // Do not edit this file!
  //================================================================
  
  public boolean set ( int index, double element ) ;
  /* Make the value stored in list at position "index" be "element".
     This differs from ins in that we do not open up space for
     a new element... we stomp over (i.e., overwrite) the value already there.
     Return false if the index is not valid, and 
     return true otherwise. The "set" operation should only 
     ever be performed on a valid index within the list as determined
     by "size".
     */
  /*Example:  For example, if the list is 
	  8.2, -7.3, 3.4, 5.0, 3.4, 2.1
      then after calling "set(2, 1.9)" the result would be
	  8.2, -7,3, 1.9, 5.0, 3.4, 2.1
    */
     
  public int findLast ( double element );
  /* Like find, except here we locate the last occurrence ("find" locates 
     the first occurrence)
     return -1 if the element is not in the list (since -1 is not a valid index)
     otherwise return the largest position in the list where element is found
     */
  /* Example:  Suppose we have the following list: 
        8.2, -7.3, 3.4, 5.0, 3.4, 2.1
    findLast(3.4) would return "4".  However, findLast(1.2) would return "-1".
    */
     
  public boolean inSort ( double element ) ;
  /* A form of ins operations, but here we do not insert based on index;
     rather we look through the list and find the first place where there
     are two element values that "straddle" the element we are adding...
     meaning we find a spot in the list where one element is <= to the item
     we are adding, and the next element (next higher index) is > the one we 
     are adding. The new element goes between these two.
     If the head element is > the one we are adding, then the new element goes
     at the head; if all elements in the list are <= the one we are adding, the
     new element goes at the end.
     return true if the add succeeds (it will almost always succeed); return false
     if for some reason the insert cannot happen (such as in Array Implementation,
     the array has no room for another element).  If the list is empty, just 
     insert the element into the list.
     
     Example:  list is  3.1, 5.5, 18.2, 23.01
     inSort(7.0)  makes this list:  3.1, 5.5, 7.0, 18.2, 23.01
     
     Example: list is 3.1, 5.5, 18.2, 23.01
     inSort(1.5) makes this list: 1.5, 3.1, 5.5, 18.2, 23.01
     
     Example: list is 3.1, 5.5, 18.2, 23.01
     inSort(55.2) makes this list: 3.1, 5.5, 18.2, 23.01, 55.2
     
     Also note the we do not assume the list is sorted when we start looking
     for a "straddle" so here is a strange (but correct) example
     
     Example: list is 1.2, 5.5, 17.03, 12.8, 6.6
     inSort(19.0) makes this list:  1.2, 5.5, 17.03, 12.8, 6.6, 19.0
     
     Note: if we use only inSort to add items to a list (dont use ins)
     then the list will be in increasing sorted order at all times
     */
  
  public boolean bubbleIns ( double element );
  /* Another form of ins operation.  In this one, we look through the list
     to see if the element we want to add is already in the list.  If it is,
     we take the first occurrance of it and move that element to the head of
     the list.  If the element we want to add is NOT already in the list then
     we put the new element at the head.  The net effect on size is this: if
     the element is already there, the size does not change; if the element is
     not already there, then we add it as a new head so the size goes up one.
     Return true if the add succeeds (it almost always will); return false if
     for some reason the add cannot happen (such as in Array Implementation,
     the array has no room for a new element to be stored).  If the list is 
     empty, just insert the element.
     
     example: list is 11.3, 45.1, -5.6, 17.3
     bubbleIns(21.0) makes this list:  21.0, 11.3, 45.1, -5.6, 17.3
     
     list is 11.3, 45.1, -5.6, 17.3
     bubbleIns(-5.6) makes this list: -5.6, 11.3, 45.1, 17.3
     
     list is 11.3, 45.1, -5.6, 17.3, 45.1, 11.3
     bubbleIns(45.1) makes this list: 45.1, 11.3, -5.6, 17.3, 45.1, 11.3
    */

}
