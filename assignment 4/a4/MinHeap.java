package a4;

import java.util.Arrays;

public class MinHeap implements Heap {
  
  private int size = 0; // number of elements currently in the heap
  private int[] elts;   // heap array
  private int max;      // array declared size
  
  // ================================================
  // constructors
  // ================================================
  
  public MinHeap(int umax) { // user defined heap size
    this.max = umax;
    this.elts = new int[umax];
  }
  public MinHeap( ) { // default heap size is 100
    this.max = 100;
    this.elts = new int[100];
  }

  //==================================================
  // methods we need to grade
  //==================================================
  
  public int[] getArray() { // do not change this method
    return this.elts;
  }
  
  //=========================================================
  // public methods -- Implement these for the assignment.
  // Note that we want a Min Heap... so the operations
  // getFront and delFront and insert have to compare 
  // for min being at the root  
  //=========================================================



  public void insert(int p){
    //Hint: remember to update size.  Also, remember that we skip index 0 in the array.
    /*Your code here */
    if (size == max)
    {
      return;
    }

    // First insert the new key at the end
    size++;
    int i = size;
    elts[i] = p;

    // Fix the min heap property if it is violated
    while (i != 0 && elts[parent(i)] > elts[i])
    {
      swap(elts, i, parent(i));
      i = parent(i);
    }
  }


  public void delFront(){
    /*Your code here */
    if (size <= 0)
      return;
    if (size == 1) {
      size--;
    }
    elts[0] = elts[size-1];
    size--;
    MinHeapify(0);
  }


  public int getFront() throws IllegalStateException {
    //Return the element at the front (i.e., the smallest) element in the min-heap.
    //If the min-heap has no elements, throw an IllegalStateException.
    /*Your code here */
    if(size > 0) {
      return elts[1];
    }
    throw new IllegalStateException(); //Dummy return statement. Remove (or move elsewhere) when you implement!
  }
  
  public boolean empty( ) {
    /*Your code here */
    return size == 0;
  }


  public int size() {
    /*Your code here */
    return size;
  }


  public void clear() { 
    /*Your code here */
    elts = new int[max];
    size = 0;
  }
  
  public void build (int[] e, int ne) {
    //Hint: remember to skip slot 0 in the heap array.
    /* Your code here */
    elts = new int[this.max];
    for (int i = 0; i < e.length ; i++) {
      elts[i + 1] = e[i];

    }
  }
  
  public int[] sort() {
    // Hint: the smallest element will go in slot 0
    int[] sorted = elts.clone();
    for (int i = 1; i <= size; i++) {
      for (int j = i + 1; j <= size; j++) {
        if (sorted[i] > sorted[j]) {
          swap(sorted, i, j);
        }
      }
    }
    for (int i = 0; i < size; i++) {
      sorted[i] = sorted[i+1];
    }
    return sorted;
  }
  void MinHeapify(int i)
  {
    int l = left(i);
    int r = right(i);
    int smallest = i;
    if (l < size && elts[l] < elts[i])
      smallest = l;
    if (r < size && elts[r] < elts[smallest])
      smallest = r;
    if (smallest != i)
    {
      swap(elts, i, smallest);
      MinHeapify(smallest);
    }
  }

  void swap(int[] arr, int i, int j)
  {
    int temp = arr[i];
    arr[i] = arr[j];
    arr[j] = temp;
  }



  int parent(int i) { return (i-1)/2; }

  int left(int i) { return (2*i + 1); }

  int right(int i) { return (2*i + 2); }}

